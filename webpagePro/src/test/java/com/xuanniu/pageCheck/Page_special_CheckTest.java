package com.xuanniu.pageCheck;

/** 
 * @author sungq 
 * @version 创建时间：2015年6月1日 下午3:39:22 
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

public class Page_special_CheckTest {
	
//	String[] account = { "99913920001", "123456" };
//	String loginUrl = "https://www.xuanniu.com/?dev=1";
	
	String loginUrl = "https://www.xuanniu.com/";
	String[] account = { "15313926589", "1234567" };

	@Test
	public void specialPageTest() throws IOException {
		System.out.println("========{选牛网部分页面检查}========");
		BasicExplorer be = new BasicExplorer();
		be.initChrome();
		be.launchChromeUrl(loginUrl);
		// -----------
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-hhmmss");
		String path = "LinkPage_" + df.format(date).toString();
		// --------------

		try {
			// ------step1: 登录
			WebElement mobile = ConstantParam.chromeDriver.findElement(By.name("mobile"));
			mobile.sendKeys(account[0]);

			WebElement password = ConstantParam.chromeDriver.findElement(By.name("password"));
			password.sendKeys(account[1]);

			WebElement loginBtn = ConstantParam.chromeDriver.findElement(By.cssSelector("#login > div.toolsbd > form > div.formbtn > button"));
			loginBtn.click();

			Thread.sleep(1000);
			// -------进入我的账户
			WebElement loginMyAccount = ConstantParam.chromeDriver.findElement(By.linkText("进入我的账户"));
			loginMyAccount.click();

			// ==================tep2: {资金明细}部分页面超检查========================
			be.launchChromeUrl("https://www.xuanniu.com/member/asset");

			String[] zjMingxiKey = { "资金流水", "充值提现", "红包流水", "配资流水", "投资流水", "利息流水", "冻结流水", };
			String[] zjMingxiVal = { "#li_bts_0 > a", "#li_bts_1 > a", "#li_bts_2 > a", "#li_bts_3 > a", "#li_bts_4 > a", "#li_bts_5 > a", "#li_bts_6 > a" };

			for (int i = 0; i < zjMingxiVal.length; i++) {
				System.out.println(i + " " + zjMingxiKey[i] + "page tab check");
				WebElement zjLs = ConstantParam.chromeDriver.findElement(By.cssSelector(zjMingxiVal[i]));
				zjLs.click();
				Thread.sleep(1000);
				// ----------保存图片---------
				String filename = zjMingxiKey[i] + ".png";
				be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
			}

			//======================step2.1: {充值、提现}操作部分页面检查=======================

			String[] zjChongzhiKey = { "充值", "提现" };
			String[] zjChongzhiVal = { "body > div.p-w > div.g-right.right > div.m-amount.f14 > dl.on > dd > ul > li.last > a.u-button-sml", "body > div.p-w > div.g-right.right > div.m-amount.f14 > dl.on > dd > ul > li.last > a.u-button-sml-2" };

			for (int i = 0; i < zjChongzhiVal.length; i++) {
				System.out.println("充值体现、页面操作");
				System.out.println(i + " " + zjChongzhiKey[i] + "操作");
				WebElement zj = ConstantParam.chromeDriver.findElement(By.cssSelector(zjChongzhiVal[i]));
				zj.click();
				Thread.sleep(1000);
				// ----------保存图片---------
				String filename = zjChongzhiKey[i] + ".png";
				be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
				// ---------------------
				be.backChrome();
				Thread.sleep(1000);
			}

			// ========================tep3: {我的红包}部分页面检查===============================
			be.launchChromeUrl("https://www.xuanniu.com/member/gift/list");
			String[] myHongbaoKey = { "未使用", "已使用", "已过期" };
			for (int i = 0; i < myHongbaoKey.length; i++) {
				System.out.println(i + " " + myHongbaoKey[i] + "page tab check");
				WebElement MyHongbao = ConstantParam.chromeDriver.findElement(By.linkText(myHongbaoKey[i]));
				MyHongbao.click();
				Thread.sleep(1000);
				// ----------保存图片---------
				String filename = myHongbaoKey[i] + ".png";
				be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
				// ---------------------
			}
			// ==========================tep4: {股票配资}部分页面检查==================================
			be.launchChromeUrl("https://www.xuanniu.com/withCapital");
			String[] pzWayKey = { "按月配资", "按天配资" };
			String[] pzWayVal = { " #m-swtags > div > p.on > a", "#m-swtags > div > p:nth-child(2) > a" };

			for (int i = 0; i < pzWayKey.length; i++) {
				System.out.println(i + " " + pzWayKey[i] + " pz way check");
				WebElement pzWay = ConstantParam.chromeDriver.findElement(By.cssSelector(pzWayVal[i]));
				pzWay.click();
				Thread.sleep(1000);

				// ----------保存图片---------
				String filename = pzWayKey[i] + ".png";
				be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
			}

		} catch (Exception e) {
			System.out.println("exception e: " + e.toString());
		} finally {
			// ----step、chromedriver.exe的删除
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("taskkill /f /im chromedriver.exe");
		}
	}

}
