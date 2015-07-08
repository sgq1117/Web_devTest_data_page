package com.xuanniu.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Mark
 *
 */
public class BasicToolDate {
	
	public static String TimeStamp2Date(String timestampString) {
		Long timestamp = Long.parseLong(timestampString);
		String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
				.format(new java.util.Date(timestamp));
		return date;
	}

	public static String TimeStamp2Date(Long timestampString) {
		Date date = new Date();
		date.setTime(timestampString);

		SimpleDateFormat fomate = new java.text.SimpleDateFormat(
				"yyyy年MM月dd日 HH时mm分ss秒");
		return fomate.format(date);

	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(TimeStamp2Date(142172418769L));
		System.out.println(new java.util.Date(1421724187694L));
//		System.out.println(TimeStamp2Date(new Date().getTime()));
//		System.out.println(new Date().getTime());
	}

	

}
