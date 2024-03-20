package com.baseAdmin.mapper.second;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.baseAdmin.second.pojo.T1;

public interface TT1Mapper {
	List<T1> selectData(Map<String, Object> map);

}
