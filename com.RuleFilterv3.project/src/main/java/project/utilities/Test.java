package project.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Test {

	public static void main(String[] args) {
		
		GenericUtils.SendEmail("CPT_ICD_Links", "CPTICDLinks_Test_Lab", "trinath.kumar@cotiviti.com");
		
//		Date date = new Date(); 
//		String today=formatDateToString(date, "dd/MM/yyy", "IST");
//        
//        System.out.println(today);
//        String today1=formatDateToString(date, "dd/MM/yyyy HH:mm:ss", "IST");
//        System.out.println("Time++++++ist"+today1);
		
	}


	public static String formatDateToString(Date date, String format,
			String timeZone) {
		// null check
		if (date == null) return null;
		// create SimpleDateFormat object with input format
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// default system timezone if passed null or empty
		if (timeZone == null || "".equalsIgnoreCase(timeZone.trim())) {
			timeZone = Calendar.getInstance().getTimeZone().getID();
		}
		// set timezone to SimpleDateFormat
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		// return Date in required format with timezone as String
		return sdf.format(date);
	}
}
