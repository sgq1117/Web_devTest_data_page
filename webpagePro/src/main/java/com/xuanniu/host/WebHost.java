package com.xuanniu.host;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;


public class WebHost {
	static String fileName = "C://WINDOWS//system32//drivers//etc//hosts";
	
	/**
	 * 在线登录passport.jd.com设定 这是预发布的
	 * @return
	 */
	public static Map<String,String> onlineFormatPassword() {
		Map<String,String> map = new HashMap<String,String>();
		map.clear();
		map.put("172.17.14.87", "passport.360buy.com passport.jd.com");
		return map;
	}
	
	/**
	 * return file content
	 * @return
	 */
	public String readFile(){
		String fileContent = null;
		try {
			fileContent = FileUtils.readFileToString(new File(fileName), "GBK");
			return fileContent;
		}catch (Exception e){
			System.out.println("Error for file oprate msg: "+e.getMessage());
		}
		return fileContent;
	}
	/**
	 * 
	 * @param Ip
	 * @param domain
	 * @return
	 */
	//-----------谢host的ip 和域�?----------------------------------------------
	public Map<String,String> setHost(String Ip, String domain) {
		Map<String,String> map = new HashMap<String,String>();
		map.clear();
		//-------Begin: set host ip and config--------
		map.put(Ip, domain);
		//-------End:   set host ip and config-------
		return map;
	}
	
	/**
	 * Edit host ip and domain----
	 * @param Ip
	 * @param domain
	 * @return
	 */
	//----------edithost-------------------------------------------------------
	public boolean EditHost(String Ip, String domain) {
		boolean result = true;
		
		try {
			String lineContent = " ";
			FileUtils.write(new File(fileName),lineContent,false);
			//----------------------host文件的ip内容-----------------------
			Map<String,String> hostMap = setHost(Ip, domain);
			java.security.Security.setProperty("networkaddress.cache.ttl" , "0");  
	        java.security.Security.setProperty("networkaddress.cache.negative.ttl" , "0"); 
			if ( hostMap == null ||hostMap.size() == 0) {
				System.out.println("Host 配置文件出错");
				result = false;
			}
			
			//-----------------------将ip写入host文件---------------------------
			Set<String> key = hostMap.keySet();
			for (Iterator<String> it = key.iterator(); it.hasNext();)  {
				String ipkey = it.next();
				try{
					EditBasicHost(ipkey,hostMap.get(ipkey));
					 Thread.sleep(1000);
				}catch(Exception e){
					System.out.println(e.getMessage());
					System.out.println("修改hsot文件错误、终止测试");
					result = false;
				}
			}
		}catch(Exception e) {
			System.out.println("Error set host: "+e.getMessage());
		}
			
		return result;
	}
   
	//---------------------------------------------------------------------------------
	/**
	 * 修改配置文件--------Basic method--------------
	 * @param ip
	 * @param hosts
	 * @throws IOException
	 */
	public  void EditBasicHost(String ip, String hosts) throws IOException {
		new FileUtils();
    	List<String> lines=new ArrayList<String>();    
    	lines.add(ip + " " + hosts);
    	//boolean variable where is appended
    	FileUtils.write(new File(fileName)," ",true);
    	
    	FileUtils.writeLines(new File(fileName), lines, true);  	
	}
	//----------------------------------------------------------------
	/**
	 * 格式�?ip格式
	 * @param businessType
	 * @return
	 * @author sunguoquan
	 */
	public  Map<String,String> EditOfflineIpType(String businessType){
		Map<String,String> map = new HashMap<String,String>();
		map.clear();
		map.put("10.10.224.138", "ac.jd.com");
		map.put("10.10.225.199 ", "passport.360buy.com passport.jd.com");
		map.put("192.168.200.208", "soacoupon.360buy.com");
		
		if(businessType.equals("checkCoupon")) {
			map.put("192.168.208.120", "quan.jd.com");	
		} else if(businessType.equals("getCoupon1")) {
			map.put("192.168.198.104", "active.coupon.jd.com");
		} else {
			System.out.println("None correct ip bisuness type as inputed");
			map.clear();			
		}
		return map;
	}

	/**
	 * 动�?修改host配置文件ip和域�?
	 * @param businessType
	 * @return
	 * @throws IOException 
	 */
	public Boolean EditOnlineHost(String businessType) throws IOException {
		boolean result = true;
		
		String lineContent = " ";
		FileUtils.write(new File(fileName),lineContent,false);
		//----------------------host文件的ip内容-----------------------
		Map<String,String> hostMap = EditOfflineIpType(businessType);
		java.security.Security.setProperty("networkaddress.cache.ttl" , "0");  
        java.security.Security.setProperty("networkaddress.cache.negative.ttl" , "0"); 
		if ( hostMap == null ||hostMap.size() == 0) {
			System.out.println("Host 配置文件出错");
			result = false;
		}
		//-----------------------将ip写入host文件---------------------------
		Set<String> key = hostMap.keySet();
		for (Iterator<String> it = key.iterator(); it.hasNext();)  {
			String ipkey = it.next();
			try{
				EditBasicHost(ipkey,hostMap.get(ipkey));
				 Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e.getMessage());
				System.out.println("修改hsot文件错误、终止测试");
				result = false;
			}
		}
//		System.out.println(FileUtils.readFileToString(new File(fileName),"UTF-8"));
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		WebHost whost = new WebHost();
		String fileContent = whost.readFile();
		System.out.println("file contetent is: "+fileContent);
	}
}
