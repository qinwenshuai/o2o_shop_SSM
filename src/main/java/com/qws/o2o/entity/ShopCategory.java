package com.qws.o2o.entity;

import java.util.Date;

/**
 *
 * 项目名称：o2o   
 * 类名称：ShopCategory   
 * 类描述：  店铺类别 
 * 创建人：秦文帅   
 * 创建时间：2019年9月26日 上午9:54:34   
 * 
 */
public class ShopCategory {
	
	// 主键ID
		private Long shopCategoryId;
		// 类别名
		private String shopCategoryName;
		// 类别描述
		private String shopCategoryDesc;
		// 类别图片地址(针对一级类别)
		private String shopCategoryImg;
		// 权重，越大越排前显示
		private Integer priority;
		// 创建时间
		private Date createTime;
		// 最近的更新时间
		private Date lastEditTime;
		// 父类别
		private ShopCategory parent;

		public Long getShopCategoryId() {
			return shopCategoryId;
		}

		public void setShopCategoryId(Long shopCategoryId) {
			this.shopCategoryId = shopCategoryId;
		}

		public String getShopCategoryName() {
			return shopCategoryName;
		}

		public void setShopCategoryName(String shopCategoryName) {
			this.shopCategoryName = shopCategoryName;
		}

		public String getShopCategoryDesc() {
			return shopCategoryDesc;
		}

		public void setShopCategoryDesc(String shopCategoryDesc) {
			this.shopCategoryDesc = shopCategoryDesc;
		}

		public String getShopCategoryImg() {
			return shopCategoryImg;
		}

		public void setShopCategoryImg(String shopCategoryImg) {
			this.shopCategoryImg = shopCategoryImg;
		}

		public Integer getPriority() {
			return priority;
		}

		public void setPriority(Integer priority) {
			this.priority = priority;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public Date getLastEditTime() {
			return lastEditTime;
		}

		public void setLastEditTime(Date lastEditTime) {
			this.lastEditTime = lastEditTime;
		}

		public ShopCategory getParent() {
			return parent;
		}

		public void setParent(ShopCategory parent) {
			this.parent = parent;
		}


}
