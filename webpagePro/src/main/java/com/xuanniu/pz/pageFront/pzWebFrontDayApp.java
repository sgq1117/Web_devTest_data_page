package com.xuanniu.pz.pageFront;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.Web.ConstantParam;
import com.xuanniu.WebElement.HttpDayIndex;

/**
 * @author sungq
 * @version 创建时间：2015年6月6日 上午11:49:29 类说明
 */

public class pzWebFrontDayApp {
	static BasicExplorer be = new BasicExplorer();
	static String loginUrl = "https://www.xuanniu.com/";

	public static String pzDayApply() throws IOException, InterruptedException {

		System.out.println("step1: --按天pzWebMonth配资 -----");
		// ----首页登录-----
		be.initChrome();
		be.launchChromeUrl(loginUrl);
		// -----配资合约单
		String pzHyOrder = null;
		// ----截图操作相关
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-hhmmss");
		String path = "PzDayFlow_" + df.format(date).toString();
		String fileIndex = "首页" + ".png";
		be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, fileIndex);
		// -----------
		try {
			// ------业务逻辑------------------------------------------
			String jsonString = HttpDayIndex.CreateIndexJson();
			JSONObject jb = JSONObject.fromObject(jsonString);
			JSONArray ja = jb.getJSONArray("天配资测试");
			// ---- 测试动作-------------------------------------
			for (int i = 0; i < ja.size(); i++) {
				String page = ja.getJSONObject(i).getString("页面");
				String action = ja.getJSONObject(i).getString("动作");
				String pageIndex = ja.getJSONObject(i).getString("索引");
				// ----页面位置
				WebElement pageElement = ConstantParam.chromeDriver.findElement(By.cssSelector(pageIndex));
				if (action.contains("_send")) {
					System.out.println("step " + i + ":" + page + ":" + action + " send ");
					pageElement.clear();
					String pageValue = ja.getJSONObject(i).getString("数值");
					pageElement.sendKeys(pageValue);

					// ----------保存图片---------
					Thread.sleep(1000);
					String filename = action + ".png";
					be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
					// -------
					Thread.sleep(1000);
				} else {
					System.out.println("step " + i + ":" + page + ":" + action + " click");
					pageElement.click();
					// ----------保存图片---------
					Thread.sleep(1000);
					String filename = action + ".png";
					be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
					Thread.sleep(1000);
				}
			}

			// ----step4: 审核返回配资合约单
			String currentUrl = ConstantParam.chromeDriver.getCurrentUrl();
//			 System.out.println("current url is: " + currentUrl);
			String destString[] = currentUrl.split("/");
			pzHyOrder = destString[destString.length - 1];
//			System.out.println("天配资合约 订单号："+pzHyOrder);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception: " + e.toString());

		} finally {
			// ----step、chromedriver.exe的删除
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("taskkill /f /im chromedriver.exe");
		}

		return pzHyOrder;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		 pzDayApply();
	}
}
