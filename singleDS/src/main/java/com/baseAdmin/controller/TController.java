package com.baseAdmin.controller;

import com.baseAdmin.dempAop.service.MathService;
import com.baseAdmin.service.GwjcService;
import com.baseAdmin.service.SecondService;
import com.baseAdmin.service.FirstService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/t")
@CrossOrigin(origins = "*")
@Api(tags="测试")
public class TController {
	@Autowired
    FirstService tService;
	@Autowired
    SecondService secondService;
	@Autowired
	MathService mathService;
	@Autowired
	GwjcService gwjcService;
	
	
    @ApiOperation("方法1")
	@GetMapping(value = { "/getT1" })
	public Object getT1() throws Exception {
		return tService.getT1(null);
	}
	@ApiOperation("getSecond")
	@GetMapping(value = { "/getSecond" })
	public Object getSecond() throws Exception {
		return tService.getSecond(null);
	}
	@GetMapping(value = { "/getWorkorderInfo" })
	public Object getT2() throws Exception {
		return secondService.getWorkorderInfo(null);
	}
	@ApiOperation("aopAdd")
	@GetMapping(value = { "/aopAdd" })
	public Object add() throws Exception {
		return mathService.add(1,3);
	}
	@ApiOperation("selectGwjcMoniMainSite")
	@GetMapping(value = { "/selectGwjcMoniMainSite" })
	public Object selectGwjcMoniMainSite() throws Exception {
		return gwjcService.selectGwjcMoniMainSite(null);
	}
}
