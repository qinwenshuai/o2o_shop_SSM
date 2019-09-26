package com.qws.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 项目名称：o2o   
 * 类名称：HttpServletRequestUtil   
 * 类描述：   
 * 创建人：秦文帅   
 * 创建时间：2019年9月26日 下午2:33:59   
 * 
 */
public class HttpServletRequestUtil {
	//从request对象中接收到的参数值是String类型（如年龄），则对String类型进行转整数处理
	public static int getInt(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}

	public static long getLong(HttpServletRequest request, String key) {
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}

	public static Double getDouble(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}

	public static boolean getBoolean(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}
	//从request对象中接收到的参数值是String类型，则对String类型进行去空串处理
	public static String getString(HttpServletRequest request, String key) {
		try {
			String result = request.getParameter(key);
			if (result != null) {
				result = result.trim();
			}
			if ("".equals(result)) {
				result = null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
