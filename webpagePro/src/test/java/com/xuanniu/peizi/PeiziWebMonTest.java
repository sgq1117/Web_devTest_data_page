package com.xuanniu.peizi;

/** 
 * @author sungq 
 * @version 
 * 类说明 
 */

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.Web.ConstantParam;

public class PeiziWebMonTest {

	String loginUrl = "http://www.xuanniu.com/";
	String[] account = { "99913920001", "123456" };

	// String[] account = { "15313926589", "1234567" };

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Begin-Peizi xuaniu web");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("End-Peizi Xuanniu Web");
	}

	@Test
	public void pzMonTest() {
		System.out.println("step1: --按月配资 -----");
		BasicExplorer be = new BasicExplorer();
		String PeiziUrlIndex = "http://www.xuanniu.com/withCapital";
		String PeiziUrlResult = "http://www.xuanniu.com/disposeTreaty?margin=5000&usedateUnit=2&tradeAccountId=&ruleId=12&usedate=4&interest=1.9";
		String PeiziList = "http://www.xuanniu.com/member/contract/list";

		be.initChrome();
		be.launchChromeUrl(loginUrl);
		try {
			// ----step1: 登录
			WebElement mobile = ConstantParam.chromeDriver.findElement(By.name("mobile"));
			mobile.sendKeys(account[0]);

			WebElement password = ConstantParam.chromeDriver.findElement(By.name("password"));
			password.sendKeys(account[1]);

			WebElement loginBtn = ConstantParam.chromeDriver.findElement(By.id("loginBtn"));
			loginBtn.click();

			Thread.sleep(1000);
			// ----step2 : 生成配资单
			be.launchChromeUrl(PeiziUrlIndex);
			Thread.sleep(2000);
			be.launchChromeUrl(PeiziUrlResult);

			WebElement peiziBtn = ConstantParam.chromeDriver.findElement(By.id("button"));
			peiziBtn.click();

			// --- step3:配资列表查看
			Thread.sleep(2000);
			be.launchChromeUrl(PeiziList);

		} catch (Exception e) {

		} finally {
			// ----chromedriver.exe的删除
		}

	}

	// @Test
	public void pzTbTest() throws IOException {
		System.out.println("step2: ----投标----");
		BasicExplorer be = new BasicExplorer();
		be.initChrome();
		be.launchChromeUrl(loginUrl);

		String tbUrl = "http://www.xuanniu.com/p2pDetail?id=1226";
		try {
			// ----step1: 登录
			WebElement mobile = ConstantParam.chromeDriver.findElement(By.name("mobile"));
			mobile.sendKeys(ConstantParam.tbMobile);

			WebElement password = ConstantParam.chromeDriver.findElement(By.name("password"));
			password.sendKeys(ConstantParam.tbPassword);

			WebElement loginBtn = ConstantParam.chromeDriver.findElement(By.id("loginBtn"));
			loginBtn.click();

			Thread.sleep(1000);
			// ----step2: 投标
			be.launchChromeUrl(tbUrl);
			WebElement amount = ConstantParam.chromeDriver.findElement(By.name("amount"));
			amount.sendKeys("14000");

			WebElement submitBtn = ConstantParam.chromeDriver.findElement(By.id("submitBtn"));
			submitBtn.click();

		} catch (Exception e) {

		} finally {
			Runtime runtime = Runtime.getRuntime();
			Process proc = runtime.exec("taskkill /f /im chromedriver.exe");
		}

	}

}
