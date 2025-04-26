package com.baseAdmin.dataSource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.util.StringUtils;

@Configuration
@MapperScan(basePackages = "com.baseAdmin.master", sqlSessionTemplateRef = "masterSqlSessionTemplate")
public class DruidConfigMaster {
/*	@Autowired
	MybatisProperties mybatisProperties;*/
	@Bean(name="mybatisConfig")
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration globalConfiguration() {
		return new org.apache.ibatis.session.Configuration();
	}
	@Bean(name="masterMybatisProperties")
	@ConfigurationProperties(prefix = "mybatis.master")
	public MybatisPropertiesCustom getMasterMybatisProperties() {
		return new MybatisPropertiesCustom();
	}
	@Primary
	@Bean(name = "masterDataSource")
	@ConfigurationProperties("spring.datasource.druid.master")
	public DataSource dataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("masterMybatisProperties") MybatisPropertiesCustom mybatisProperties, @Qualifier("masterDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		org.apache.ibatis.session.Configuration configuration = mybatisProperties.getConfiguration();
		bean.setConfiguration(configuration);
		bean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());


		/*bean.setTypeAliasesPackage(mybatisProperties.getTypeAliasesPackage());*/
		//bean.setMapperLocations(mapperLocations);
		//bean.setMapperLocations(
		//		new PathMatchingResourcePatternResolver().getResources("classpath:mappers/primary/**/*Mapper.xml"));
		// 多数据时 application-mybatis.yml不启使用,需要手动配置
		//org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		// 自动将数据库中的下划线转换为驼峰格式
		//configuration.setMapUnderscoreToCamelCase(true);
	//	configuration.setCallSettersOnNulls(true);
		/*bean.setConfiguration(mybatisConfig);*/
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
