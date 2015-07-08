package com.xuanniu.Web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasicExplorer {

	/**
	 * Mark init firefox
	 */
	public void initFirefox() {
		System.out.println("	init the driver firefox type...");
		System.setProperty("webdriver.firefox.bin", ConstantParam.firefoxBin);
		ConstantParam.firefoxDriver = new FirefoxDriver();
	}

	/**
	 * Mark init chrome
	 */
	public void initChrome() {
//		System.out.println("	init the driver chrome type...");
		System.setProperty("webdriver.chrome.driver", ConstantParam.chromeBin);
		ConstantParam.chromeDriver = new ChromeDriver();
	}

	/**
	 * Mark init ie
	 */
	public void initIe() {
		System.out.println("	init the driver IE type...");
		System.setProperty("webdriver.ie.driver", ConstantParam.ieBin);
		ConstantParam.ieDriver = new InternetExplorerDriver();
	}

	/**
	 * Launch Dest Url with chrome
	 */
	public void launchChromeUrl(String url) {
//		System.out.println("	launch with chrome driver");
		// ------------------------------------
		ConstantParam.chromeDriver.manage().window().maximize();
		ConstantParam.chromeDriver.navigate().to(url);
	}
	public void backChrome(){
		ConstantParam.chromeDriver.navigate().back();
	}
	
	/**
	 * Launch Dest Url with firefox
	 */
	public void launchFirefoxUrl(String url) {
		System.out.println("	launch with firefox driver");
		// ------------------------------------
		ConstantParam.firefoxDriver.manage().window().maximize();
		ConstantParam.firefoxDriver.navigate().to(url);
	}

	/**
	 * Launch Dest url with Ie
	 */
	public void launchIeforUrl(String url) {
		System.out.println("	launch with Ie driver");
		// ------------------------------------
		ConstantParam.ieDriver.manage().window().maximize();
		ConstantParam.ieDriver.navigate().to(url);
	}

	/**
	 * Login Url
	 * 
	 * @param url
	 * @param UserNameParam
	 * @param PasswordParam
	 * @param submitParam
	 * @param UserNameValue
	 * @param PasswordValue
	 */
	public void launchBacklLogin(String url,String UserNameValue, String PasswordValue) {
		System.out.println("...launch with login page");
		// logger.info("launch with login page");
		// --------------------------------
		ConstantParam.chromeDriver.manage().window().maximize();
		ConstantParam.chromeDriver.navigate().to(url);

		// ----userName----
		WebElement name = ConstantParam.chromeDriver.findElement(By.id("userName"));
		name.sendKeys(UserNameValue);
		//----password----
		WebElement password = ConstantParam.chromeDriver.findElement(By.id("password"));
		password.sendKeys(PasswordValue);
		//----clickButton	
		String loginButtonSelector = "body > div > div > div > div > div.panel-body > form > fieldset > a";
		WebElement loginButton = ConstantParam.chromeDriver.findElement(By.cssSelector(loginButtonSelector));
		loginButton.click();
	}

	/**
	 * 截图: 驱动名称、路径、文件名称
	 * @param drivername
	 * @param path
	 * @param filename
	 */
	public void snapshot(TakesScreenshot drivername, String path, String filename) {
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
//		System.out.println("...Take screeshot on path: " + path);
		try {
//			System.out.println("save snapshot path is:E:\\testSnapshot\\" + path + "\\snapshot" + filename);
			FileUtils.copyFile(scrFile, new File("E:\\testSnapshot\\" + path + "\\snapshot_" + filename));
		} catch (IOException e) {
			System.out.println("	{Fail}Can't save screenshot");
			e.printStackTrace();
		} 

	}
	public static void main(String[] args){
		Date date=new Date(); 
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd-hhmmss"); 
		String filename = df.format(date).toString();
		System.out.println("date is: "+filename); 
	}
	
}
