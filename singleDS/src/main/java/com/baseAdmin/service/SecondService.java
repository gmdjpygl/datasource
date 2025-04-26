package com.baseAdmin.service;

import com.baseAdmin.dynamicdata.CurDataSource;
import com.baseAdmin.dynamicdata.DataSourceNames;
import com.baseAdmin.mapper.T1Mapper;
import com.baseAdmin.mapper.T2Mapper;
import com.baseAdmin.pojo.T2;
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

	public List<T2> getWorkorderInfo(Map<String, Object> params) {
		List<T2> list = t2Mapper.selectT2(null);
		return list;
	}


}
