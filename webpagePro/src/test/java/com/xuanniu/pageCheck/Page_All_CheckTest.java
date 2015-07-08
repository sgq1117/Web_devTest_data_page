package com.xuanniu.pageCheck;

/** 
 * @author sungq 
 * @version 创建时间：2015年5月29日 上午10:09:59 
 * 类说明 
 */

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.Web.ConstantParam;

public class Page_All_CheckTest {

	
//	String[] account = { "99913920001", "123456" };
//	String loginUrl = "https://www.xuanniu.com/?dev=1";
	
	String loginUrl = "https://www.xuanniu.com/";
	String[] account = { "15313926589", "1234567" };
	@SuppressWarnings("rawtypes")
	@Test
	public void onlinePageChecktest() throws IOException {
		System.out.println("========{选牛网所有页面检查}========");
		BasicExplorer be = new BasicExplorer();
		be.initChrome();
		be.launchChromeUrl(loginUrl);
		// ----url和对应的title
		Map<String, String> linkTitleMap = new LinkedHashMap<String, String>();
		// ----
		try {
			// ------step1: 登录
			WebElement mobile = ConstantParam.chromeDriver.findElement(By.name("mobile"));
			mobile.sendKeys(account[0]);

			WebElement password = ConstantParam.chromeDriver.findElement(By.name("password"));
			password.sendKeys(account[1]);

			WebElement loginBtn = ConstantParam.chromeDriver.findElement(By.cssSelector("#login > div.toolsbd > form > div.formbtn > button"));
			loginBtn.click();

			Thread.sleep(1000);
			// ------step2: 页面检查、保存路径、时间类型
			Date date = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-hhmmss");
			String path = "staticUrl_"+df.format(date).toString();
			// ------ step3
			Conf cf = new Conf();
			Map urlMap = cf.allurlMap();
			Iterator iter = urlMap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String urlKey = (String) entry.getKey();
				String urlVal = (String) entry.getValue();
				System.out.println("Launch to====>" + urlKey + "<====>" + urlVal);
				be.launchChromeUrl(urlVal);
				Thread.sleep(2000);
				// ------step3: 对每个页面进行截图
				String filename = urlKey + ".png";
				be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
				// ------ step4: 存储url对应的title
				linkTitleMap.put(urlVal, ConstantParam.chromeDriver.getTitle());
			}
			// ------step 4: chrome driver 进程的kill
		} catch (Exception e) {
			System.out.println("exception e: " + e.toString());
		} finally {
			// ---- step5：url对应title的输出
			Iterator iter = linkTitleMap.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				String linkTitleKey = (String) entry.getKey();
				String LinkTitleUrl = (String) entry.getValue();
				System.out.println(linkTitleKey+"====>"+LinkTitleUrl);
			}
			// ----step6、chromedriver.exe的删除
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("taskkill /f /im chromedriver.exe");
		}
	}

}
