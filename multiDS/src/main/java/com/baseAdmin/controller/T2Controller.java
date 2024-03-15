package com.baseAdmin.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.baseAdmin.service.SecondService;
import com.baseAdmin.service.T2Service;
import com.baseAdmin.util.GsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/t2")
//@CrossOrigin(origins = "*")
//@Api(tags="测试")
public class T2Controller {
	@Autowired
	T2Service tService;
	@Autowired
	SecondService secondService;
	
	
	@GetMapping(value = { "/getT1" })
	public Object getT1() throws Exception {
		return null;
	}
}
