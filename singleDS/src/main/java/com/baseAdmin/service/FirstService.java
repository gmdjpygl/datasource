package com.baseAdmin.service;

import com.baseAdmin.dynamicdata.CurDataSource;
import com.baseAdmin.dynamicdata.DataSourceNames;
import com.baseAdmin.dynamicdata.DynamicDataSource;
import com.baseAdmin.mapper.T1Mapper;
import com.baseAdmin.mapper.T2Mapper;
import com.baseAdmin.pojo.T1;
import com.baseAdmin.pojo.T2;
import com.baseAdmin.util.GsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FirstService {
	@Autowired
	private T1Mapper t1Mapper;
	@Autowired
	private T2Mapper t2Mapper;

	public PageInfo<T1> getT1(Map<String, Object> params) {
		DynamicDataSource.setDataSource(DataSourceNames.SECOND);
		List<T2> list3 = t2Mapper.selectT2(null);
		System.out.println(GsonUtil.BeanToJson(list3));
		DynamicDataSource.setDataSource(DataSourceNames.FIRST);
		List<T1> list2 = t1Mapper.selectData(null);

		PageHelper.startPage(-1, 0);
		List<T1> list = t1Mapper.selectData(null);
		PageInfo<T1> pageInfo = PageInfo.of(list);
		return pageInfo;
	}
	@CurDataSource(name=DataSourceNames.SECOND)
	public List<T2> getSecond(Map<String, Object> params) {
		List<T2> list = t2Mapper.selectT2(null);
		return list;
	}

}
