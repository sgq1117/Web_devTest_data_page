
package com.xuanniu.peizi; 
/** 
* @author sungq 
* @version 创建时间：2015年5月27日 下午12:05:26 
* 类说明 
*/ 

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.Web.ConstantParam;

public class PeiziWebDayTest {
	BasicExplorer befIn = new BasicExplorer();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	// 按天配资
	@Test
	public void peiziDayTest() {
		System.out.println("case1: ---按天配资 ----");
		String loginUr = "http://www.xuanniu.com/";
		String PeiziUrlIndex = "http://www.xuanniu.com/withCapital?usedateUnit=1";
		String PeiziUrlResult = "http://www.xuanniu.com/disposeTreaty?margin=2000&usedateUnit=1&ruleId=1&usedate=2&tradeStartTime=1";
		/**
		 * margin: 投资本金、配资保证金
		 * usedateUnit: 2：按月配资， 1：按天配资
		 * ruleId: 配资比例  10：1倍配资，  14: 5倍金额
		 * usedate: 资金使用期限 2~20
		 * tradeStartTime: 0: 今天、1:下个交易日
		 */
		befIn.initChrome();
		befIn.launchChromeUrl(loginUr);
		try {
			// --login
			WebElement mobile = ConstantParam.chromeDriver.findElement(By.name("mobile"));
			mobile.sendKeys(ConstantParam.pzMobile);

			WebElement password = ConstantParam.chromeDriver.findElement(By.name("password"));
			password.sendKeys(ConstantParam.pzPassword);

			WebElement loginBtn = ConstantParam.chromeDriver.findElement(By.id("loginBtn"));
			loginBtn.click();

			Thread.sleep(1000);

			// --按天配资
			befIn.launchChromeUrl(PeiziUrlIndex);
			Thread.sleep(3000);
			befIn.launchChromeUrl(PeiziUrlResult);
		} catch (Exception e) {

		} finally {

		}
	}

}

