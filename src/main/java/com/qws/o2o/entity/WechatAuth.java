package com.qws.o2o.entity;

import java.util.Date;

/**
 *
 * 项目名称：o2o   
 * 类名称：WechatAuth   
 * 类描述：   微信登陆
 * 创建人：秦文帅   
 * 创建时间：2019年9月26日 上午9:47:29   
 * 
 */
public class WechatAuth {
	// 主键ID
		private Long wechatAuthId;
		// 微信获取用户信息的凭证，对于某个公众号具有唯一性
		private String openId;
		// 创建时间
		private Date createTime;
		// 用户信息
		private PersonInfo personInfo;

		public Long getWechatAuthId() {
			return wechatAuthId;
		}

		public void setWechatAuthId(Long wechatAuthId) {
			this.wechatAuthId = wechatAuthId;
		}

		public String getOpenId() {
			return openId;
		}

		public void setOpenId(String openId) {
			this.openId = openId;
		}

		public Date getCreateTime() {
			return createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		public PersonInfo getPersonInfo() {
			return personInfo;
		}

		public void setPersonInfo(PersonInfo personInfo) {
			this.personInfo = personInfo;
		}


}
