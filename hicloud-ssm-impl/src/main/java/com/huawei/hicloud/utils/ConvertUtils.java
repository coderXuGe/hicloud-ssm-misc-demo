package com.huawei.hicloud.utils;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class ConvertUtils {

	public static <T> T object2Class(Object obj, Class<T> clazz) {
		String objJsonStr = JSONObject.toJSONString(obj);
		T newObj = JSONObject.parseObject(objJsonStr, clazz);
		return newObj;
	}
	
	public static <T> List<T> object2ClassList(Object obj, Class<T> clazz) {
		String objJsonStr = JSONObject.toJSONString(obj);
		List<T> newObj = JSONObject.parseArray(objJsonStr, clazz);
		return newObj;
	}
}
