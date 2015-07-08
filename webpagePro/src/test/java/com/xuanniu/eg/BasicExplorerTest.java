package com.xuanniu.eg;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.xuanniu.Web.BasicExplorer;
import com.xuanniu.Web.ConstantParam;

public class BasicExplorerTest {
	BasicExplorer bef = new BasicExplorer();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		System.out.println("Begin");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("End");

		/*
		 * BasicExplorer bef = new BasicExplorer();
		 * bef.snapshot((TakesScreenshot) ConstantParam.driver, "login",
		 * "firstpicture");
		 */
	}

	@Test
	public void testChome_register() {

		bef.initChrome();
		bef.launchChromeUrl("http://www.xuanniu.com/");

		try {
			WebElement register = ConstantParam.chromeDriver.findElement(By
					.linkText("免费注册"));
			register.click();
			boolean info = ConstantParam.chromeDriver.getCurrentUrl().contains(
					"register");
			assertEquals(info, true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ConstantParam.driver.close();
			// System.exit(0);
		}
				
	}
	
	@Test
	public void testFirefox_regist() {
		bef.initFirefox();
		bef.launchFirefoxUrl("http://www.xuanniu.com/");
		try {
			WebElement register = ConstantParam.firefoxDriver.findElement(By
					.linkText("免费注册"));
			register.click();
			boolean info = ConstantParam.firefoxDriver.getCurrentUrl().contains(
					"register");
			assertEquals(info, true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ConstantParam.driver.close();
			// System.exit(0);
		}
	}
	
	@Test
	public void testIe_regist(){
		bef.initIe();
		bef.launchIeforUrl("http://www.xuanniu.com/");
		try {
			WebElement register = ConstantParam.ieDriver.findElement(By
					.linkText("免费注册"));
			register.click();
			boolean info = ConstantParam.ieDriver.getCurrentUrl().contains(
					"register");
			assertEquals(info, true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ConstantParam.driver.close();
			// System.exit(0);
		}
	}
}
