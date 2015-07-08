package com.xuanniu.pz.pageFront;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.Web.ConstantParam;
import com.xuanniu.WebElement.HttpToubIndex;
import com.xuanniu.pz.pageUtils.pzWebCommon;

/**
 * @author sungq
 * @version 创建时间：2015年6月6日 下午12:40:25 类说明
 */

public class pzWebFrontTbApp {
	// ----
	static BasicExplorer be = new BasicExplorer();
	static String loginUrl = "https://www.xuanniu.com/";
	static String p2p_pre_Url = "https://www.xuanniu.com/p2pDetail?id=";
	static String pwp_Url = null;

	// ----
	// String url1 = "https://www.xuanniu.com/p2pList?status=2";
	// String url2 = "https://www.xuanniu.com/p2pDetail?id=10131";
	public static void TouBiao(String fcSn, String amount) throws IOException {
		System.out.println("step1: ----配资投标 -----");
		be.initChrome();
		be.launchChromeUrl(loginUrl);
		// -----------------
		String fcId = pzWebCommon.getfcId(fcSn);
		// --------截图相关----
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-hhmmss");
		String path = "PzMonFlow_" + df.format(date).toString();
		String fileIndex = "首页" + ".png";
		be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, fileIndex);

		try {
			// ----投标页面的到达
			String jsonString = HttpToubIndex.CreateIndexJson();
			JSONObject jb = JSONObject.fromObject(jsonString);
			JSONArray ja = jb.getJSONArray("投标测试");
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
					// ---------------------------
					Thread.sleep(1000);
				} else {
					System.out.println("step " + i + ":" + page + ":" + action + " click");
					pageElement.click();
					// ----------保存图片---------
					Thread.sleep(1000);
					String filename = action + ".png";
					be.snapshot((TakesScreenshot) ConstantParam.chromeDriver, path, filename);
					// ---------------------------
					Thread.sleep(1000);
				}
			}
			// ----验证是否到达投标页面的总页面、断言比较
			String act_url = ConstantParam.chromeDriver.getCurrentUrl();
			String exp_url = "https://www.xuanniu.com/p2pList?status=2";
			if (act_url.equals(exp_url)) {
				System.out.println("{Ok} with the exp_dest_url: " + exp_url);
				// ----------------------
				Document doc = Jsoup.connect(exp_url).get();
				Elements hrefs = doc.select("a[href]");
				System.out.println("---------1---------");
				String element = hrefs.select("[href^=/p2pDetail]").toString();
				// ---- 是否含有期待的标的页面
				if (element.contains(fcId)) {
					// System.out.println("ok: " + element);
					pwp_Url = p2p_pre_Url + fcId;
				} else {
					System.out.println("{NOK}--without he dest p2p_contract_id: " + fcId);
				}

				// ----------------------
			} else {
				System.out.println("{NOk} with the exp_dest_url: " + exp_url);
			}

			// ----跳转至目的页面
			be.launchChromeUrl(pwp_Url);
			// ----投标操作
			WebElement amountElement = ConstantParam.chromeDriver.findElement(By.cssSelector("#amount"));
			amountElement.clear();
			amountElement.sendKeys(amount);

			WebElement submitElement = ConstantParam.chromeDriver.findElement(By.cssSelector("#submitBtn"));
			submitElement.click();
			// ------
			Thread.sleep(1000);
			System.out.println("投标后的url:" + ConstantParam.chromeDriver.getCurrentUrl());

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
		TouBiao("PZ00010176", "1000");
	}
}
