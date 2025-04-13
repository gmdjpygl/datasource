package com.baseAdmin.controller;

import java.util.HashMap;
import java.util.Map;

import com.baseAdmin.dempAop.service.MathService;
import com.baseAdmin.dempAop.service.MathServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baseAdmin.service.TService;
import com.baseAdmin.util.GsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/t")
@CrossOrigin(origins = "*")
@Api(tags="测试")
public class TController {
	@Autowired
	TService tService;
	@Autowired
	MathService mathService;
	
	
    @ApiOperation("方法1")
	@GetMapping(value = { "/getT1" })
	public Object getT1() throws Exception {
		return tService.getT1(null);
	}
	@GetMapping(value = { "/getT2" })
	public Object getT2() throws Exception {
		return tService.getT2(null);
	}
	@ApiOperation("aopAdd")
	@GetMapping(value = { "/aopAdd" })
	public Object add() throws Exception {
		return mathService.add(1,3);
	}
}
