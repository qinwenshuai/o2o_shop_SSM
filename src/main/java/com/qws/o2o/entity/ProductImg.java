package com.qws.o2o.entity;

import java.util.Date;

/**
 *
 * 项目名称：o2o   
 * 类名称：ProductImg   
 * 类描述：   商品图片
 * 创建人：秦文帅   
 * 创建时间：2019年9月26日 上午10:00:09   
 * 
 */
public class ProductImg {
	// 主键ID
		private Long productImgId;
		// 图片地址
		private String imgAddr;
		// 图片简介
		private String imgDesc;
		// 权重，越大越排前显示
		private Integer priority;
		// 创建时间
		private Date createTime;
		// 标明是属于哪个商品的图片
		private Long productId;

		public Long getProductImgId() {
			return productImgId;
		}

		public void setProductImgId(Long productImgId) {
			this.productImgId = productImgId;
		}

		public String getImgAddr() {
			return imgAddr;
		}

		public void setImgAddr(String imgAddr) {
			this.imgAddr = imgAddr;
		}

		public String getImgDesc() {
			return imgDesc;
		}

		public void setImgDesc(String imgDesc) {
			this.imgDesc = imgDesc;
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

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}


}
