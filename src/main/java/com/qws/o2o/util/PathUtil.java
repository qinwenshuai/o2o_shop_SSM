package com.qws.o2o.util;

/**
 *
 * 项目名称：o2o   
 * 类名称：PathUtil   
 * 类描述：   
 * 创建人：秦文帅   
 * 创建时间：2019年9月26日 下午2:33:29   
 * 
 */
public class PathUtil {
	private static String seperator = System.getProperty("file.separator");
	//返回项目图片的根路径
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/projectdev/image";
		} else {
			//linux
			basePath = "/Users/baidu/work/image";
		}
		//将/替换成系统对应的分隔符
		basePath = basePath.replace("/", seperator);
		return basePath;
	}
	//依据不同的业务需求，返回项目图片子路径。如将图片分别存储在各自的店面下
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/images/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
