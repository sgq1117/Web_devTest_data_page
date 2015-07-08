package com.xuanniu.WebElement;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author sungq
 * @version 创建时间：2015年6月5日 下午4:42:11 类说明
 */

public class HttpDayIndex {
	// static String[] account = { "99913920001", "123456" };
	static String[] account = { "15313926589", "1234567" };
	
	/**
	 * 5000、3倍配资、4天、当天交易
	 * @return
	 */
	@SuppressWarnings("rawtypes")
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

		// -------------配资-------
		Map<String, String> mapV20 = new LinkedHashMap<String, String>();
		mapV20.put("页面", "配资");
		mapV20.put("动作", "page_click");
		mapV20.put("索引", "body > div.p-menu > div > div.menu.right.f16 > ul > li.li2 > a");

		Map<String, String> mapV21 = new LinkedHashMap<String, String>();
		mapV21.put("页面", "天配资");
		mapV21.put("动作", "day_page_click");
		mapV21.put("索引", "#m-swtags > div > p:nth-child(2) > a > em");
		
				
		Map<String, String> mapV22 = new LinkedHashMap<String, String>();
		mapV22.put("页面", "天配资");
		mapV22.put("动作", "margin_send");
		mapV22.put("索引", "#amount");
		mapV22.put("数值", "5000");
		
		/*
		 * 利率 : #swbox > div.multiple.left > div.tags > ul > li:nth-child(3) > em
		 */
		Map<String, String> mapV23 = new LinkedHashMap<String, String>();
		mapV23.put("页面", "天配资");
		mapV23.put("动作", "rate_click");
		mapV23.put("索引", "#swbox > div.multiple.left > div.tags > ul > li:nth-child(8) > em");

		Map<String, String> mapV24 = new LinkedHashMap<String, String>();
		mapV24.put("页面", "天配资");
		mapV24.put("动作", "usedate_send");
		mapV24.put("索引", "#swbox > div.confirm.right > div.table > table > tbody > tr:nth-child(5) > td:nth-child(2) > input");
		mapV24.put("数值", "4");

		Map<String, String> mapV25 = new LinkedHashMap<String, String>();
		mapV25.put("页面", "天配资");
		mapV25.put("动作", "startTime_click");
		mapV25.put("索引", "#date1");

		Map<String, String> mapV26 = new LinkedHashMap<String, String>();
		mapV26.put("页面", "天配资");
		mapV26.put("动作", "button_click");
		mapV26.put("索引", "#button");

		// ----------确认-------
		Map<String, String> mapV31 = new LinkedHashMap<String, String>();
		mapV31.put("页面", "确认");
		mapV31.put("动作", "coupon_click");
		mapV31.put("索引", "#giftSelect > option");

		Map<String, String> mapV32 = new LinkedHashMap<String, String>();
		mapV32.put("页面", "确认");
		mapV32.put("动作", "sure_click");
		mapV32.put("索引", "	#button");

		// -------
		// -------------------------------
		List<Map> list = new ArrayList<Map>();
		list.add(mapV11);
		list.add(mapV12);
		list.add(mapV13);
		list.add(mapV14);

		list.add(mapV20);
		list.add(mapV21);
		list.add(mapV22);
		list.add(mapV23);
		list.add(mapV24);
		list.add(mapV25);
		list.add(mapV26);

		list.add(mapV31);
		list.add(mapV32);

		JSONArray ja2 = JSONArray.fromObject(list);
		jo.put("天配资测试", ja2);
		// --

		// --
//		System.out.println(jo.toString());
		return jo.toString();

	}
}
