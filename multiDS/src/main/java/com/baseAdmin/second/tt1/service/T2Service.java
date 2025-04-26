package com.baseAdmin.second.tt1.service;

import java.util.List;
import java.util.Map;

import com.baseAdmin.second.tt1.mapper.T2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baseAdmin.second.pojo.T2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class T2Service {
	@Autowired
	private T2Mapper tt1Mapper;

	public PageInfo<T2> getT2(Map<String, Object> params) {

		PageHelper.startPage(1, 5);
		List<T2> list = tt1Mapper.selectData(null);
		PageInfo<T2> pageInfo = PageInfo.of(list);
		return pageInfo;

	}

}
