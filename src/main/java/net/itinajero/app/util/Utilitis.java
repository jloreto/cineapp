package net.itinajero.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Utilitis {

	/**
	 * Method that returns a String List with the following dates, according to the
	 * count parameter
	 * 
	 * @param count
	 * @return
	 */
	public static List<String> getNexDays(Integer count) {
		List<String> list = new ArrayList<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();

		gcal.setTime(start);

		Date d = null;
		while (!gcal.getTime().after(endDate)) {
			d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			list.add(sdf.format(d));
		}

		return list;
	}

	public static String saveImage(String nameDirectory, MultipartFile multipart, HttpServletRequest request) {

		StringBuilder builder = new StringBuilder();
		builder.append(Utilitis.getRamdonAlphanumeric(7)).append("-");
		builder.append(multipart.getOriginalFilename().replaceAll(" +", "-"));
		String origName = builder.toString();

		String imagePath = request.getServletContext().getRealPath("/resources/images/");

		try {

			File imageFile = new File(imagePath + (nameDirectory.isEmpty()?"":nameDirectory+"/") + origName);
			multipart.transferTo(imageFile);
			return origName;

		} catch (IOException exception) {
			System.out.println("Error uploading image file");
			return null;
		}

	}

	public static String getRamdonAlphanumeric(int count) {

		String CHARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		int lenCHARA = CHARACTERES.length();
		int character;
		while (count-- > 0) {
			character = (int) (Math.random() * lenCHARA);
			builder.append(CHARACTERES.charAt(character));
		}

		return builder.toString();
	}

}
