package com.baseAdmin.service;

import com.baseAdmin.dynamicdata.CurDataSource;
import com.baseAdmin.dynamicdata.DataSourceNames;
import com.baseAdmin.mapper.GwjcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@CurDataSource(name = DataSourceNames.GWJC)//@CurDataSource(name = DataSourceNames.SECOND)
@Service
public class GwjcService {

	@Autowired
	private GwjcMapper gwjcMapper;

	public List<Map<String, Object>> selectGwjcMoniMainSite(Map<String, Object> params) {
		List<Map<String, Object>> list = gwjcMapper.selectGwjcMoniMainSite(null);
		return list;
	}


}
