package com.baseAdmin.second.tt1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baseAdmin.second.tt1.service.SecondService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/tt1")
@CrossOrigin(origins = "*")
@Api(tags="测试tt1")
public class TT1Controller {
	@Autowired
	SecondService secondService;
	
	
    @ApiOperation("方法1")
	@GetMapping(value = { "/getT1" })
	public Object getT1() throws Exception {
		return secondService.getTT1(null);
	}
}
