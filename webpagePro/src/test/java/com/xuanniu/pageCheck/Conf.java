package com.xuanniu.pageCheck;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sungq
 * @version 创建时间：2015年5月29日 上午11:15:03 类说明
 */

public class Conf {

	@SuppressWarnings("rawtypes")
	public Map allurlMap() {
//		HashMap<String, String> map = new HashMap<String, String>();
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("1.0、首页", "https://www.xuanniu.com/");
		map.put("1.1、注册-页面","https://www.xuanniu.com/register");
		map.put("1.2、注册-验证码", "https://www.xuanniu.com/v1/api0/image/captcha?action=register&1433384771393");
		map.put("2.1、个人中心-个人首页", "https://www.xuanniu.com/member/index");
		map.put("2.2.1、股票配资-操盘账户", "https://www.xuanniu.com/member/financing");
		map.put("2.2.2、股票配资-配资合约", " https://www.xuanniu.com/member/contract/list");
		map.put("2.3.1、我的理财-我的投资-投标中", "https://www.xuanniu.com/member/p2p/current");
		map.put("2.3.2、我的理财-我的投资-计息中", " https://www.xuanniu.com/member/p2p/history?s=2");
		map.put("2.3.3、我的理财-我的投资-结算完成", "https://www.xuanniu.com/member/p2p/history?s=3&period=1");
		map.put("2.4、安全设置", "https://www.xuanniu.com/member/security");
		map.put("2.5、资金明细", "https://www.xuanniu.com/member/asset");
		map.put("2.6.1、我要充值-账户充值-在线充值", "https://www.xuanniu.com/member/asset/deposit");
		map.put("2.6.2、我要充值-充值记录-充值记录", "https://www.xuanniu.com/member/asset/depositList");
		map.put("2.7.1、我要提现-账户提现-我要提款", "https://www.xuanniu.com/member/asset/withdraw");
		map.put("2.7.2、我要提现-账户提现-提款记录", "https://www.xuanniu.com/member/asset/withdrawlist");
		map.put("2.7.3、我要提现-账户提现-添加提现银行卡", "https://www.xuanniu.com/member/asset/bindcard");
		map.put("2.8、我的红包-我的红包", "https://www.xuanniu.com/member/gift/list");
		map.put("2.9、代理返佣", "https://www.xuanniu.com/brokerageIndex");
		map.put("2.9.1、我的佣金", "https://www.xuanniu.com/member/brokerage/list");
		map.put("2.9.2、推广大人榜-佣金总榜","https://www.xuanniu.com/brokerageTop");
		map.put("2.9.3、佣金周榜","https://www.xuanniu.com/brokerageTop");
		map.put("3.1.1、股票配资", "https://www.xuanniu.com/help/help.shtml");
		map.put("3.1.2、操盘规则", "https://www.xuanniu.com/help/rule.shtml");
		map.put("3.1.3、常见问题", "https://www.xuanniu.com/help/qa.shtml");
		map.put("3.1.4、安全保障", "https://www.xuanniu.com/help/safe.shtml");
		map.put("3.1.5、新手指引", "https://www.xuanniu.com/help/guidelines.shtml");
		map.put("3.1.6、配资流程", "https://www.xuanniu.com/help/flow.shtml");
		map.put("3.1.7、配资技巧", "https://www.xuanniu.com/help/skill.shtml");
		map.put("3.1.8、操盘必读", "https://www.xuanniu.com/help/read.shtml");
		map.put("3.1.9、名词解释", "https://www.xuanniu.com/help/glossary.shtml");
		map.put("3.2.0、网站公告", "https://www.xuanniu.com/notices");
		map.put("3.2.1、媒体报道", "https://www.xuanniu.com/reports");
		map.put("4.0、交易软件", "https://www.xuanniu.com/help/soft.shtml");
		map.put("5.1.1、投资理财-All", "https://www.xuanniu.com/p2pList");
		map.put("5.2.1、状态-投标中", "https://www.xuanniu.com/p2pList?status=2");
		map.put("5.2.2、状态-投标结束", "https://www.xuanniu.com/p2pList?status=3");
		map.put("5.2.3、状态-计息中", "https://www.xuanniu.com/p2pList?status=4");
		map.put("5.2.4、状态-还款结束", "https://www.xuanniu.com/p2pList?status=5");
		map.put("5.3.1、期限-0-3个月", "https://www.xuanniu.com/p2pList?period=1");
		map.put("5.3.2、期限-3-6个月", "https://www.xuanniu.com/p2pList?period=2");
		map.put("5.3.3、期限-6-9个月", "https://www.xuanniu.com/p2pList?period=3");
		map.put("5.3.4、期限-9~12个月", "https://www.xuanniu.com/p2pList?period=4");
		map.put("5.4.1、收益-12%以下", "https://www.xuanniu.com/p2pList?rate=1");
		map.put("5.4.2、收益-12~15%", "https://www.xuanniu.com/p2pList?rate=2");
		map.put("5.4.3、收益-15~18%", "https://www.xuanniu.com/p2pList?rate=3");
		map.put("5.4.4、收益-18%以上", "https://www.xuanniu.com/p2pList?rate=4");
		map.put("6.1.1、股票配资-All", "https://www.xuanniu.com/withCapital");
		map.put("6.1.2、股票配资-按月配资", "https://www.xuanniu.com/withCapital?margin=2000&tradeAccountId=");
		map.put("6.1.3、股票配资-按天配资", "https://www.xuanniu.com/withCapital?usedateUnit=1&margin=2000&tradeAccountId=");
		return map;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		Conf cf = new Conf();
		
//		Map urlMap = cf.allurlMap();
//		Iterator iter = urlMap.entrySet().iterator();
//		while (iter.hasNext()) {
//			Map.Entry entry = (Map.Entry) iter.next();
//			Object key = entry.getKey();
//			Object val = entry.getValue();	
//			System.out.println(key+"-"+val);
//		}
		Runtime runtime = Runtime.getRuntime();
	    Process proc = runtime.exec("taskkill /f /im chromedriver.exe");
	}
}
