package com.baseAdmin.dataSource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages = "com.baseAdmin.mapper.second", sqlSessionTemplateRef = "secondSqlSessionTemplate")
public class DruidConfigSecond {
	@Bean(name = "secondDataSource")
	@ConfigurationProperties("spring.datasource.druid.second")
	public DataSource primary() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "secondSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage("com.baseAdmin.pojo");
		//bean.setMapperLocations(
		//		new PathMatchingResourcePatternResolver().getResources("classpath:mappers/primary/**/*Mapper.xml"));
		// 多数据时 application-mybatis.yml不启使用,需要手动配置
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		// 自动将数据库中的下划线转换为驼峰格式
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setCallSettersOnNulls(true);
		bean.setConfiguration(configuration);
		return bean.getObject();
	}

	@Bean(name = "secondTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("secondDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "secondSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("secondSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
