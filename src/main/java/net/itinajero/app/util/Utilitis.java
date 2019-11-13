package net.itinajero.app.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Utilitis {
	
	/**
	 * Method that returns a String List with the following dates, according to the count parameter
	 * @param count
	 * @return
	 */
	public static List<String> getNexDays(Integer count) {
		List<String> list  = new ArrayList<>();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date start  = new Date();
		Calendar cal  = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();
		
		GregorianCalendar gcal  = new GregorianCalendar();
		
		gcal.setTime(start);
		
		Date d = null;
		while(!gcal.getTime().after(endDate)) {
			d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			list.add(sdf.format(d));
		}
		
		return list;
	}

}
