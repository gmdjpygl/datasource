package com.baseAdmin.second.tt1.service;

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

import com.baseAdmin.mapper.master.T2Mapper;
import com.baseAdmin.mapper.second.TT1Mapper;
import com.baseAdmin.pojo.T1;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SecondService {
	@Autowired
	private TT1Mapper tt1Mapper;

	public PageInfo<T1> getTT1(Map<String, Object> params) {

		PageHelper.startPage(0, 6);
		List<T1> list = tt1Mapper.selectData(null);
		PageInfo<T1> pageInfo = PageInfo.of(list);
		return pageInfo;
	}

}
