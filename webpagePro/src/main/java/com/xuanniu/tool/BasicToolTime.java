package com.xuanniu.tool;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicToolTime {
	
	/**
	 * @author Mark
	 * @param mss
	 * @return
	 */
	public static String formatDuring(long mss) {  
	    long days = mss / (1000 * 60 * 60 * 24);  
	    long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);  
	    long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);  
	    long seconds = (mss % (1000 * 60)) / 1000;  
	    return days + " days " + hours + " hours " + minutes + " minutes "  
	            + seconds + " seconds ";  
	}  
	
	/**
	 * @author sunguoquan
	 * Get current time 
	 * @return
	 */
	public static String getCurrentTime() {
		  Date dt=new Date(System.currentTimeMillis());
		  SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMddHHmmss");
		  String setTime = matter1.format(dt);
		  System.out.println("currentTime : "+setTime);
		  return setTime;
	}
	/**
	 * @author sunguoquan
	 * format time
	 * @param args
	 * @throws InterruptedException
	 */
	public static String formatTimeStandard(long time){
		Date dt = new Date(time);
		SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String setTime = matter1.format(dt);
		
		System.out.println("currentTime : "+setTime);
		return setTime;
	}
	/**
	 * makr the time type ,begin or end
	 * @param timeType
	 * @return
	 * @throws ParseException
	 * @author sunguoquan
	 */
	public static long markTime(String timeType) throws ParseException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String markTime = sdf.format(new Date(System.currentTimeMillis()));
		Date mark = sdf.parse(markTime);
//		timeShow.trimleftprintln(timeType+":" +markTime, 0);
//		System.out.println(timeType+":" +markTime);
		long time = mark.getTime();
		return time;
		
	}
	
	/**
	 * @author sunguoquan
	 * ����ʱ��
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static String calculateTime(String strContent,long beginTime,long endTime) {
//		long between = (end.getTime()-begin.getTime());
		long between = endTime-beginTime;		
		long day=between/(24*60*60*1000);
		long hour=(between/(60*60*1000)-day*24);
		long min=((between/(60*1000))-day*24*60-hour*60);
		long s=(between/1000-day*24*60*60-hour*60*60-min*60);		
		String duringTime = " "+day+" "+" "+hour+" "+" "+min+" "+" "+s+" ";
//		timeShow.trimleftprintln("{ "+strContent+" }"+" Execution time is: "+duringTime, "calcuTime",0);
		System.out.println("{ "+strContent+" }"+" Execution time is: "+duringTime);
		return duringTime;
	}
	/**
	 * @author sunguoquan
	 * calculate date time
	 * @param args
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public static String calculateTime(long time) throws ParseException, InterruptedException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String beginTime = sdf.format(new Date(System.currentTimeMillis()));
		Date begin = sdf.parse(beginTime);
		System.out.println("begin time is: "+beginTime);
		
		Thread.sleep(time);
		
		String endTime = sdf.format(new Date(System.currentTimeMillis()));		
		Date end = sdf.parse(endTime);
		System.out.println("end time is: "+endTime);
		
		long between = (end.getTime()-begin.getTime());
		
		long day=between/(24*60*60*1000);
		long hour=(between/(60*60*1000)-day*24);
		long min=((between/(60*1000))-day*24*60-hour*60);
		long s=(between/1000-day*24*60*60-hour*60*60-min*60);
		
		String duringTime = " "+day+" "+" "+hour+" "+" "+min+" "+" "+s+" ";
		
		return duringTime;
	}
	/**
	 * @author sunguoquan
	 * @param args
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public static void main(String[] args) throws InterruptedException, ParseException {
		
//		System.out.println("during time: "+calculateTime(3000));
		long beginTime = markTime("beginTime");
		Thread.sleep(3004);
		long endTime = markTime("Endtime");
		calculateTime("Test",endTime,beginTime);
			
	}
}
