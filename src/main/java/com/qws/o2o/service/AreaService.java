package com.qws.o2o.service;

import java.util.List;

import com.qws.o2o.entity.Area;

public interface AreaService {

	/**
	 * 获取区域列表，优先从缓存获取
	 * 
	 * @return
	 */
	List<Area> getAreaList();

}
