package com.qws.o2o.dto;

import java.util.List;

import com.qws.o2o.entity.Shop;
import com.qws.o2o.enums.ShopStateEnum;

public class ShopExecution {
	// 结果状态 为整数，如0
		private int state;  

		// 状态标识 为字符串，说明state整数的业务意义。 如0表示在审核中
		private String stateInfo;

		// 店铺数量
		private int count;

		// 操作的shop(增删改店铺的时候用到)
		private Shop shop;

		// shop列表(查询店铺列表的时候使用)
		private List<Shop> shopList;

		public ShopExecution() {

		}

		// 店铺操作失败的时候使用的构造器
		public ShopExecution(ShopStateEnum stateEnum) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
		}

		// 店铺操作成功的时候使用的构造器
		public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.shop = shop;
		}

		// 店铺操作成功的时候使用的构造器
		public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.shopList = shopList;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

		public String getStateInfo() {
			return stateInfo;
		}

		public void setStateInfo(String stateInfo) {
			this.stateInfo = stateInfo;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public Shop getShop() {
			return shop;
		}

		public void setShop(Shop shop) {
			this.shop = shop;
		}

		public List<Shop> getShopList() {
			return shopList;
		}

		public void setShopList(List<Shop> shopList) {
			this.shopList = shopList;
		}


}
