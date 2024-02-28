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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

@Configuration
@MapperScan(basePackages = "com.baseAdmin.mapper.master", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class DruidConfigMaster {
	@Primary
	@Bean(name = "masterDataSource")
	@ConfigurationProperties("spring.datasource.druid.master")
	public DataSource primary() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
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
	
	
	

	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "masterSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
