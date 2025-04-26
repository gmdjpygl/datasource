package com.baseAdmin.second.tt1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baseAdmin.second.tt1.service.T2Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/t2")
@CrossOrigin(origins = "*")
@Api(tags="测试t2")
public class T2Controller {
	@Autowired
	T2Service secondService;
	
	
    @ApiOperation("方法1")
	@GetMapping(value = { "/getT2" })
	public Object getT2() throws Exception {
		return secondService.getT2(null);
	}
}
