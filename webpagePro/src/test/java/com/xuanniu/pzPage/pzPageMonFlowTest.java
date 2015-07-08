package com.xuanniu.pzPage;

/** 
 * @author sungq 
 * @version 创建时间：2015年6月6日 下午12:18:26 
 * 类说明 
 */

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.pz.pageBack.PzWebBackSendBdApp;
import com.xuanniu.pz.pageFront.pzWebFrontMonApp;
import com.xuanniu.pz.pageFront.pzWebFrontTbApp;
import com.xuanniu.pz.pageUtils.pzWebCommon;

public class pzPageMonFlowTest {


	@Test
	public void pzTbMonFlowTest() {
		try {
			/*
			 * 配资申请
			 */
			String pzHyOrder = pzWebFrontMonApp.pzMonApply();
			Thread.sleep(2000);
			System.out.println("月配资 pzHyOrder: " + pzHyOrder);
			/*
			 * 发布标的
			 */
			PzWebBackSendBdApp.SendBd(pzHyOrder);
			/*
			 * 投标
			 */
//			String fcId = pzWebCommon.getfcId(pzHyOrder);
			pzWebFrontTbApp.TouBiao(pzHyOrder, "5000");

			
		} catch (IOException e) {
			System.out.println("IOException e " + e.toString());
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException e: " + e.toString());
			e.printStackTrace();
		}
	}

}
