package com.xyy.web.controller;

import com.xyy.common.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private Environment env;


	@GetMapping(value = "/isNull")
	public Object isNull(String p) {
		return CommonUtil.isNull(p);
	}
	

}
