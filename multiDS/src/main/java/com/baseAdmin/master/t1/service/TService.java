package com.baseAdmin.master.t1.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baseAdmin.master.t1.mapper.T1Mapper;
import com.baseAdmin.pojo.T1;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TService {
	@Autowired
	private T1Mapper t1Mapper;

	public PageInfo<T1> getT1(Map<String, Object> params) {
		List<T1> list2 = t1Mapper.selectData(null);

		PageHelper.startPage(100,5);
		List<T1> list = t1Mapper.selectData(null);
		PageInfo<T1> pageInfo = PageInfo.of(list);
		return pageInfo;
	}


}
