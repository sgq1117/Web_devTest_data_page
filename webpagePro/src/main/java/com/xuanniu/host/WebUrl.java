package com.xuanniu.host;

import java.io.UnsupportedEncodingException;

public class WebUrl {
	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÏàµÈ
	 * 
	 * @param url1
	 * @param url2
	 * @return
	 */
	public boolean compare(String url1, String url2) {
		if (url1.equals(url2)) {
			System.out.println("{Equal ok}");
			return true;
		} else {
			System.out.println("{Not Equal}");
			return false;
		}
	}

	/**
	 * UrlDecode
	 * 
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String urlDecode(String url) throws UnsupportedEncodingException {
		String decoded_url = java.net.URLDecoder.decode(url, "utf-8");
		return decoded_url;
	}

	/**
	 * UrlEncode
	 * 
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String urlEncode(String url) throws UnsupportedEncodingException {
		String encoded_url = java.net.URLEncoder.encode(url, "utf-8");
		return encoded_url;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		String url1 = "ip=192.168.155.57&port=36165&cmd=invoke+com.jd.coupon.batch.api.BatchUtilsService.sendCoupons(%221%22%2C%222%22%2C%223%22%2C3%2C4%2C5%2C%226%22%2C%227%22%2C8%2C9%2C%222014-12-10+00%3A00%3A00%3A00%22%09++)&invokekey=&encoding=GBK";
		String url2 = new WebUrl().urlDecode(url1);
		/*
		 * 
		 */
		// -----------------urldecode----------
		String urls[] = {
				"http://test.saf.jd.com/saf/servicemanage/viewService2.html?interfaceId=com.jd.coupon.batch.api.BatchUtilsService&html=datagrid-manageService2.html?pageNumber%301%20pageSize%3015%20q_interfaceId%30com.jd.coupon.batch.api.BatchUtilsService",
				"http://test.saf.jd.com/saf/servicemanage/viewService2.html?interfaceId=com.jd.coupon.batch.api.BatchUtilsService&html=datagrid-manageService2.html?pageNumber%301%20pageSize%3015%20q_interfaceId%30com.jd.coupon.batch.api.BatchUtilsService",
				"http://erp1.360buy.com/newHrm/Verify.aspx?ReturnUrl=http%3a%2f%2fcouponmanagercenter.360buy.com%2fcouponbatch%2faddCouponBatch.action",
				"http%3a%2f%2fcouponmanagercenter.360buy.com%2fcouponbatch%2faddCouponBatch.action",
				"http%3a%2f%2fcouponmanagercenter.360buy.com%2femployee%2freceiveIndex.jd%3ft%3dTue+Jan+13+2015+09%3a17%3a09+GMT+0800+(%ufffd%u0439%ufffd%ufffd%ufffd%u05fc%u02b1%ufffd%ufffd)",
				"http://erp1.jd.com/newhrm/sso.aspx?ReturnUrl=http://couponmanagercenter.360buy.com/couponbatch/addCouponBatch.action&optiontype=login&token=9rwIFapMfE0nYh3KtEgx6fC1xJRexOq%2fX9%2bHMQ6%2bHIYSiidpNCxVxw%3d%3d",
				"http://erp1.jd.com/newhrm/sso.aspx?ReturnUrl=http://couponmanagercenter.360buy.com/couponbatch/addCouponBatch.action&amp;optiontype=login&amp;token=9rwIFapMfE0pgUqb7zLKUWEN36LOqyJgBJsXnB1hD9Kb4db9fJ4IpQ%3d%3d",
				"http://erp1.jd.com/newhrm/sso.aspx?ReturnUrl=htp://couponmanagercenter.360buy.com/couponbatch/addCouponBatch.action&optiontype=login&token=9rwIFapMfE0pgUqb7zLKUf9gHDVAXXPYx7RRkPoIjY0mvb9Zf6LSkA%3d%3d",
				"http://erp1.360buy.com/newHrm/Verify.aspx?ReturnUrl=http%3a%2f%2fcouponmanagercenter.360buy.com%2fcouponbatch%2faddYfCouponBatch.action",
				"http://couponmanagercenter.360buy.com/couponbatch/addYfCouponBatch.action?success=0&couponConfigQuery.batchKey=&couponBatchQuery.batchId=0",
				"http://erp1.360buy.com/newHrm/Verify.aspx?ReturnUrl=http%3A%2F%2Fcouponmanagercenter.360buy.com%2Fcouponbatch%2FaddYfCouponBatch.action" };

		// System.out.println(new urlCode().urlDecode(urls[5]));
		// System.out.println(new urlCode().urlDecode(urls[6]));
		// System.out.println(new urlCode().urlDecode(urls[7]));
		System.out.println(new WebUrl().urlDecode(urls[10]));
		// --------

	}
}
