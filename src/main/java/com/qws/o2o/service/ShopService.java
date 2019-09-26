package com.qws.o2o.service;

import com.qws.o2o.dto.ImageHolder;
import com.qws.o2o.dto.ShopExecution;
import com.qws.o2o.entity.Shop;
import com.qws.o2o.exceptions.ShopOperationException;

public interface ShopService {
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;

}
