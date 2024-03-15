package com.baseAdmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude={
        DataSourceAutoConfiguration.class,// 如果想在项目中使用多数据源就需要排除它，手动指定多数据源
        DataSourceTransactionManagerAutoConfiguration.class,
})

public class MultiDSApplication {
	public static void main(String[] args) {
		SpringApplication.run(MultiDSApplication.class, args);
		
	}

}
