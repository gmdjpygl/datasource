package com.baseAdmin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 *  在 Spring Boot 应用中，如果需要将应用打包成 WAR 包并部署到外部的 Servlet 容器中，就需要使用 SpringBootServletInitializer。
 *  通过创建一个继承自 SpringBootServletInitializer 的类，并在该类中重写 configure() 方法，
 *  可以创建一个 Servlet 容器初始化器，用于配置外部的 Servlet 容器。
 * @author Administrator
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SingleDSApplication.class);
	}

}
