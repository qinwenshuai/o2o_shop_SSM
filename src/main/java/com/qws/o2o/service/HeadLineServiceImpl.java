package com.qws.o2o.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qws.o2o.dao.HeadLineDao;
import com.qws.o2o.entity.HeadLine;
import com.qws.o2o.exceptions.HeadLineOperationException;

@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Autowired
	private HeadLineDao headLineDao;

	private static Logger logger = LoggerFactory
			.getLogger(HeadLineServiceImpl.class);

	@Override
	@Transactional
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
		try {
			return headLineDao.queryHeadLine(headLineCondition);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new HeadLineOperationException(e.getMessage());
		}
	}
}

