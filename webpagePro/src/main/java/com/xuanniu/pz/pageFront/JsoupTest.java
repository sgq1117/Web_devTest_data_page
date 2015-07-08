package com.xuanniu.pz.pageFront;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author sungq
 * @version 创建时间：2015年6月6日 下午1:58:15 类说明
 */

public class JsoupTest {
	// ---http://blog.chinaunix.net/uid-25885064-id-3443543.html
	// ================================================================
	/**
	 * parse
	 */

//	String TbInprocess = "https://www.xuanniu.com/p2pList?status=2";
//	String p2pUrl = "https://www.xuanniu.com/p2pDetail?id=";
	String loginUrl = "https://www.xuanniu.com/";
	String Url = null;
	String fiId = "1676";

	public void parseUrl() {
		try {
			Document doc = Jsoup.connect(loginUrl).get();
			Elements hrefs = doc.select("a[href]");
			System.out.println(hrefs);
			System.out.println("---------1---------");
//			String element = hrefs.select("[href^=/p2pDetail]").toString();
			// System.out.println(element);
//			if (element.contains(fiId)) {
//				Url = p2pUrl + fiId;
//			} else {
//				System.out.println("none");
//			}
			
//			System.out.println("Url: " + Url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JsoupTest t = new JsoupTest();
		t.parseUrl();
	}

}
