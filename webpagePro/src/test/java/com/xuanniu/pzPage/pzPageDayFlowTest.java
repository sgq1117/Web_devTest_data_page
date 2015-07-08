package com.xuanniu.pzPage; 
/** 
* @author sungq 
* @version 创建时间：2015年6月6日 下午12:31:26 
* 类说明 
*/ 

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xuanniu.pz.pageBack.PzWebBackSendBdApp;
import com.xuanniu.pz.pageFront.pzWebFrontDayApp;
import com.xuanniu.pz.pageFront.pzWebFrontMonApp;
import com.xuanniu.pz.pageFront.pzWebFrontTbApp;

public class pzPageDayFlowTest {

	@Test
	public void pzTbDayFlowTest() {
		try {
			/*
			 * 配资申请
			 */
			String pzHyOrder = pzWebFrontDayApp.pzDayApply();
			Thread.sleep(2000);
			System.out.println("天配资 pzHyOrder: " + pzHyOrder);
			/*
			 * 发布标的
			 */
			PzWebBackSendBdApp.SendBd(pzHyOrder);
			
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


