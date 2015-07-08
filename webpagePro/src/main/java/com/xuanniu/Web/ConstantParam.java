package com.xuanniu.Web;

import org.openqa.selenium.WebDriver;

public class ConstantParam {
	/**
	 * Mark
	 * constatnParam
	 */
											
	public static final String firefoxBin = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
	public static final String chromeBin="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
	public static final String ieBin="C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer64.exe";
	
	/*
	 * Accoount: 登录
	 */
	public static String pzMobile = "99913920001";
	public static String pzPassword = "1234567";
	
	public static String nokPwd ="12345678";
	
	public static String tbMobile = "99913920002";
	public static String tbPassword ="1234567";
	
	/*
	 * explore: 浏览器
	 */
	public static WebDriver driver;
	public static WebDriver chromeDriver;
	public static WebDriver firefoxDriver;
	public static WebDriver ieDriver;
}
