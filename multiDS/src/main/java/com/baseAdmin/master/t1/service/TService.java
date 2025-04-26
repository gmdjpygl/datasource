package com.baseAdmin.master.t1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baseAdmin.master.pojo.T1;
import com.baseAdmin.master.t1.mapper.T1Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TService {
	@Autowired
	private T1Mapper t1Mapper;

	public PageInfo<T1> getT1(Map<String, Object> params) {
		List<T1> list2 = t1Mapper.selectData(null);

		PageHelper.startPage(1,5);
		List<T1> list = t1Mapper.selectData(null);
		PageInfo<T1> pageInfo = PageInfo.of(list);
		return pageInfo;
	}


}
