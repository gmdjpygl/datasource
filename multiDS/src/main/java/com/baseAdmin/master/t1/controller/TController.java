package com.baseAdmin.master.t1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baseAdmin.master.t1.service.TService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/t")
@CrossOrigin(origins = "*")
@Api(tags="测试t")
public class TController {
	@Autowired
	TService tService;
	@Autowired
	private ApplicationContext applicationContext;
	
    @ApiOperation("方法1")
	@GetMapping(value = { "/getT1" })
	public Object getT1() throws Exception {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		return tService.getT1(null);
	}
}
