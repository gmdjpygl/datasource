package com.baseAdmin.service;

import com.baseAdmin.dynamicdata.CurDataSource;
import com.baseAdmin.dynamicdata.DataSourceNames;
import com.baseAdmin.mapper.T1Mapper;
import com.baseAdmin.mapper.T2Mapper;
import com.baseAdmin.pojo.T1;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@CurDataSource(name = DataSourceNames.SECOND)//@CurDataSource(name = DataSourceNames.SECOND)
@Service
public class SecondService {
	@Autowired
	private T1Mapper t1Mapper;
	@Autowired
	private T2Mapper t2Mapper;

	public PageInfo<T1> getT1(Map<String, Object> params) {
		List<T1> list2 = t1Mapper.selectData(null);

		PageHelper.startPage(-1, 0);
		List<T1> list = t1Mapper.selectData(null);
		PageInfo<T1> pageInfo = PageInfo.of(list);
		return pageInfo;
	}

	public List<Map<String, Object>> getT2(Map<String, Object> params) {
		List<Map<String, Object>> list = t2Mapper.selectData(null);
		return list;
	}

}
