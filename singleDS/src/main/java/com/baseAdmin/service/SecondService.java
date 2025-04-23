package com.baseAdmin.service;

import com.baseAdmin.dynamicdata.CurDataSource;
import com.baseAdmin.dynamicdata.DataSourceNames;
import com.baseAdmin.mapper.T1Mapper;
import com.baseAdmin.mapper.T2Mapper;
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

	public List<Map<String, Object>> getWorkorderInfo(Map<String, Object> params) {
		List<Map<String, Object>> list = t2Mapper.selectWorkorderInfo(null);
		return list;
	}


}
