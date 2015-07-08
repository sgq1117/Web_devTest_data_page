package com.xuanniu.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author sungq
 * @version 创建时间：2015年6月6日 下午4:12:47 类说明
 */

public class HttpLoginIndex {
	// static String[] account = { "99913920001", "123456" };
	static String[] account = { "15313926589", "1234567" };

	public static String CreateIndexJson() {

		// JSON格式数据解析对象
		JSONObject jo = new JSONObject();
		// ----------首页---------------
		// 下面构造四个map、一个list
		Map<String, String> mapV11 = new LinkedHashMap<String, String>();
		mapV11.put("页面", "首页");
		mapV11.put("动作", "mobile_send");
		mapV11.put("索引", "#loginMobile");
		mapV11.put("数值", account[0]);

		Map<String, String> mapV12 = new LinkedHashMap<String, String>();
		mapV12.put("页面", "首页");
		mapV12.put("动作", "password_send");
		mapV12.put("索引", "#loginForm > ul > li:nth-child(2) > input");
		mapV12.put("数值", account[1]);

		Map<String, String> mapV13 = new LinkedHashMap<String, String>();
		mapV13.put("页面", "首页");
		mapV13.put("动作", "loginBtn_click");
		mapV13.put("索引", "#loginBtn");

		Map<String, String> mapV14 = new LinkedHashMap<String, String>();
		mapV14.put("页面", "首页");
		mapV14.put("动作", "loginAccount_click");
		mapV14.put("索引", "#inContainer > dl.button > dd > a");
		//------------
		
		List<Map> list = new ArrayList<Map>();
		list.add(mapV11);
		list.add(mapV12);
		list.add(mapV13);
		list.add(mapV14);
		
		JSONArray ja2 = JSONArray.fromObject(list);
		jo.put("登陆", ja2);
		
		return jo.toString();
	}
}
