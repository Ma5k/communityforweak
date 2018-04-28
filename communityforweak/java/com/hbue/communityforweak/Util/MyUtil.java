package com.hbue.communityforweak.Util;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {
	
	public static Date StringToDate(String source) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		return sdf.parse(source);
	}
}
