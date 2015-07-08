package com.xuanniu.pz.pageBack;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.Web.ConstantParam;
import com.xuanniu.pz.pageUtils.pzWebCommon;

/**
 * @author sungq
 * @version 创建时间：2015年6月6日 上午11:07:57 类说明
 */

public class PzWebBackSendBdApp {
	// ===================================================
	static BasicExplorer be = new BasicExplorer();
	static String[] account = { "admin", "admin" };
	static String loginUrl = "https://back.xuanniu.com/";
	// ---
	static String pzUrl = "https://back.xuanniu.com/peizi";

	// ======================================================
	

	/**
	 * 发布标的
	 * 
	 * @throws IOException
	 */
	public static void SendBd(String fcSn) throws IOException {
		System.out.println("step1: --配资后台审核流程、标的发布 -----");
		// -----------------
		// String FcId = getfcId(fcSn);
		// System.out.println("FcId: " + FcId);
		String fcId = pzWebCommon.getfcId(fcSn);
		// ---------------
		be.initChrome();
		be.launchChromeUrl(loginUrl);
		// ------financing_contract_id处理---------
		System.out.println("处理的fcId: " + fcId);
		// ---------------------------------------
		try {
			// ----step1: login页面--
			be.launchBacklLogin(loginUrl, account[0], account[1]);
			Thread.sleep(1000);
			// ----step2: pz管理页面
			be.launchChromeUrl(pzUrl);
			Thread.sleep(1000);
			// ----step3: 页面点击
			List<WebElement> bdLink = ConstantParam.chromeDriver.findElements(By.linkText("发布标的"));
			// System.out.println("bdLink" + bdLink);
			for (WebElement ele : bdLink) {
				// System.out.println(ele.getAttribute("onclick"));
				String attribute = ele.getAttribute("onclick");
				if (attribute.contains(fcId)) {
					// ----click
					ele.click();
					// ----alert confirm
					Thread.sleep(1000);
					Alert alert = ConstantParam.chromeDriver.switchTo().alert();
					Thread.sleep(1000);
					System.out.println("Accept the alert: " + alert.getText());
					alert.accept();
					break;
				}
			}
			// bdLink.click();
			// ------alert------
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception: " + e.toString());
		} finally {
			// ----step、chromedriver.exe的删除
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("taskkill /f /im chromedriver.exe");
		}
	}

	public static void main(String[] args) throws IOException {
		String fcSn = "PZ00010175";
		SendBd(fcSn);
	}
}
