package com.xuanniu.pz.pageUtils;

/**
 * @author sungq
 * @version 创建时间：2015年6月6日 下午4:03:31 类说明
 */

public class pzWebCommon {
	/**
	 * get financing_tract_sn 的id
	 * 
	 * @param fcSn
	 * @return
	 */
	public static String calcfcId(String fcSn) {
		System.out.println("====Back start====");
		String fcIds = fcSn.replace("PZ", "").trim();
		while (fcIds.startsWith("0")) {
			fcIds = fcIds.substring(1, fcIds.length());
		}

		// String fcId = calcfcId(fcIds, String.valueOf(1));
		// System.out.println("fcId: "+fcId);
		return fcIds;
	}

	public static String getfcId(String fcSn) {
		String fcIds = calcfcId(fcSn);
		int fcIdsValue = Integer.parseInt(fcIds);
		/*
		 * 配资合约单和p2p标的单的数据管理、database可查、page的仅能做观察直觉上的数量对、哎悲催
		 */
		int numValue = 1;
		int intFcId = fcIdsValue - numValue;

		String strFcId = String.valueOf(intFcId);
		return strFcId;
	}

	public static void main(String[] args) {
		String fcSn = "PZ00010131";
		System.out.println("fcsn id is: " + getfcId(fcSn));

		// String fcid = calcfcId(fcSn);
		// System.out.println("fcid: " + fcid);

	}
}
