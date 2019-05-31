package com.cloud.pay.admin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.pay.admin.controller.TradeController;

/**
 * 这是一个日期 格式转换 的类
 */
public class DateUtil {
	private Logger log = LoggerFactory.getLogger(DateUtil.class);


	/**
	 * 获取YYYY格式
	 * 
	 * @return
	 */
	public static String getYear() {
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		return sdfYear.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		return sdfDay.format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 * 
	 * @return
	 */
	public static String getDays() {
		SimpleDateFormat sdfDays = new SimpleDateFormat("yyyyMMdd");
		return sdfDays.format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 * 
	 * @return
	 */
	public static String getTime() {
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdfTime.format(new Date());
	}

	/**
	 * @Title: compareDate
	 * @Description: (日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws @author
	 *             luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if (fomatDate(s) == null || fomatDate(e) == null) {
			return false;
		}
		return fomatDate(s).getTime() >= fomatDate(e).getTime();
	}

	/**
	 * 格式化日期
	 * 
	 * @return
	 */
	public static Date fomatDate(String date) {
		if(StringUtils.isBlank(date)) {
			return null;
		}
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 校验日期是否合法
	 * 
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// long aa=0;
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
					/ 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 * 
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");
		java.util.Date beginDate = null;
		java.util.Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 得到n天之后的日期
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 得到n天之后是周几
	 * 
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}

	/**
	 * 获取UTC时间
	 * 
	 * @return
	 */
	// public static String getUTCTime(){
	// //取得本地时间
	// final Calendar cal = Calendar.getInstance();
	// //获取偏移量
	// final int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
	// //取得夏令时差
	// final int dstOffset = cal.get(Calendar.DST_OFFSET);
	// cal.add(Calendar.MILLISECOND, -(zoneOffset+dstOffset));
	//
	// return sdfTime.format(cal.getTime());
	// }
	

	/**
	 * 字符转日期
	 */
	public static Date formatDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.parse(str);
	}

	/**
	 * 日期转字符
	 */
	public static String formatDate(Date date, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			return "" + format;
		}
	}

	/**
	 * 时间戳转时间
	 */
	public static String formatTimeStamp(Long timeStamp, String format) {
		try {
			Date date = new Date(timeStamp);
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			System.out.println("时间戳转换失败");
			return "";
		}
	}

	public static void main(String[] args) {
		System.out.println(getDays());
		System.out.println(getAfterDayWeek("3"));
		// System.out.println("==UTC时间:"+getUTCTime());
		// System.out.println("=东八区时间:"+getLocalTimeFromUTC(getUTCTime()));
		System.out.println(getTime());
	}

}
