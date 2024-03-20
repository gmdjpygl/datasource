package com.baseAdmin.master.t1.mapper;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

import com.baseAdmin.master.pojo.T1;

public interface T1Mapper {
	List<T1> selectData(Map<String, Object> map);

}
