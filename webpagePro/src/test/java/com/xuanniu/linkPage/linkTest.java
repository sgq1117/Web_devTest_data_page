package com.xuanniu.linkPage;

/** 
 * @author sungq 
 * @version 创建时间：2015年6月10日 上午10:29:03 
 * 类说明 
 */

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class linkTest {

	String loginUrl = "https://www.xuanniu.com/";

	@Test
	public void linkTest() {
		try {
			Document doc = Jsoup.connect(loginUrl).get();
			Elements hrefs = doc.select("a[href]");
			System.out.println("href: " + hrefs);
			// System.out.println(hrefs);
			System.out.println("---------1---------");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
