package com.goebuy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
 
/**
 *  日期处理万能工具类
 */
public class DateUtils {
 
	private static Logger logger = Logger.getLogger(DateUtils.class);
	
	/** "yyyy-MM-dd HH:mm:ss"格式类型 */
	public final static String LONG_PATTERN = "yyyy-MM-dd HH:mm:ss";
 
	/** "yyyy-MM-dd HH:mm"格式类型 */
	public final static String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
 
	/** "yyyyMMddHHmmss"格式类型 */
	public final static String SHORT_PATTERN = "yyyyMMddHHmmss";
 
	/** "yyyy-MM-dd"格式类型 */
	public final static String PATTERN_THREE = "yyyy-MM-dd";
 
	/** "yyyyMM"格式类型 */
	public final static String PATTERN_FOUR = "yyyyMM";
	
	/** "HH:mm:ss"格式类型 */
	public final static String SHORTTIME_PATTERN = "HH:mm:ss";
 
	/** 常见日期类型数组 */
	public final static String[] normalDateFormatArray = new String[]{"yyyy-MM-dd","yyyy/MM/dd","yyyyMMdd"};
	
	/** 分钟类型 */
	public static final int MINITE_TYPE = 0;
	
	/** 小时类型 */
	public static final int HOUR_TYPE = 1;
	
	/** 日类型 */
	public static final int DAY_TYPE = 2;
	
	/** 月类型 */
	public static final int MONTH_TYPE = 3;
	
	/** 年类型 */
	public static final int YEAR_TYPE = 4;
	
	
	public static String formatTime(Date date) {
		if (null == date) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(LONG_PATTERN);
		return sdf.format(date);
	}
	
	public static String formatShortTime(Date date) {
		if (null == date) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(SHORTTIME_PATTERN);
		return sdf.format(date);
	}
	
	public static Date parseDate(String source) {
		return parseDate(source, PATTERN_THREE);
	}
	
	public static Date parseDate(String source, String pattern) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(pattern);
		return fmt.parseLocalDateTime(source).toDate();
	}
 
	public static Date parseTime(String source) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern(LONG_PATTERN);
		return fmt.parseLocalDateTime(source).toDate();
	}
	
	/**
	 * 日期类型字符串转换成日期
	 * 
	 * @param strDate 日期的字符串
	 * @param pattern 日期的格式，如：yyyy/MM/dd yyyy-MM-dd yyyy-MM-dd HH:mm:ss.
	 */
	public static Date stringToDate(String strDate, String pattern) {
		if (strDate == null || strDate.trim().length() <= 0)
			return null;
 
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			logger.warn("Parse date error! strDate [" + strDate + "], pattern [" + pattern + "].", e);
			return null;
		}
 
	}
 
	/**
	 * 字符串，不指定格式的转换成日期.
	 * 
	 * @param strDate 日期的字符串
	 * @return the date 日期类，如：yyyy/MM/dd yyyy-MM-dd yyyy-MM-dd HH:mm:ss.
	 */
	public static Date stringToDate(String strDate) {
		if (strDate == null || strDate.trim().length() <= 0)
			return null;
		for(String df:normalDateFormatArray){
			SimpleDateFormat sdf = new SimpleDateFormat(df);
			try {
				return sdf.parse(strDate);
			} catch (ParseException e) {
				continue;
			}
		}
		logger.warn("Parse date error! strDate [" + strDate + "], pattern [yyyy-MM-dd][yyyy/MM/dd][yyyyMMdd].");
		return null;
	}
 
	/**
	 * 检验日期字符串，是否为"yyyy-MM-dd"格式
	 * 
	 * @param strDate 日期字符串
	 * @return true 是 
	 */
	public static boolean checkDate(String strDate) {
		if (strDate == null || strDate.length() == 0)
			return true;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.parse(strDate);
		} catch (ParseException e) {
			logger.info("Wrong strDate [" + strDate + "], pattern [yyyy-MM-dd].");
			return false;
		}
		return true;
	}
 
	/**
	 * 日期类转换成指定日期格式的字符串
	 * 
	 * @param date 日期
	 * @param pattern 日期格式
	 * @return the string 日期字符串
	 */
	public static String dateToString(Date date, String pattern) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * 对日期的【秒】进行加
	 * 
	 * @param date 日期 —— new Date()
	 * @param addSeconds 需要对【秒】进行加减的天数
	 * @return the date 增/减几秒后的日期
	 */
	public static Date dateAddSeconds(Date date, int addSeconds) {
		DateTime dateTime = new DateTime(date);
		return dateTime.plusSeconds(addSeconds).toDate();
	}
	
	/**
	 * 对日期的【分】进行加
	 * 
	 * @param date 日期 —— new Date()
	 * @param addMinutes 需要对【分】进行加减的天数
	 * @return the date 增/减几分后的日期
	 */
	public static Date dateAddMinutes(Date date, int addMinutes) {
		DateTime dateTime = new DateTime(date);
		return dateTime.plusMinutes(addMinutes).toDate();
	}
	
	/**
	 * 对日期的【小时】进行加
	 * 
	 * @param date 日期 —— new Date()
	 * @param addMinutes 需要对【小时】进行加减的天数
	 * @return the date 增/减几小时后的日期
	 */
	public static Date dateAddHours(Date date, int addHours) {
		DateTime dateTime = new DateTime(date);
		return dateTime.plusHours(addHours).toDate();
	}
 
	/**
	 * 对日期的【日】进行加
	 * 
	 * @param date 日期 —— new Date()
	 * @param addDays 需要对【日】进行加减的天数
	 * @return the date 增/减几天后的日期
	 */
	public static Date dateAddDays(Date date, int addDays) {
		DateTime dateTime = new DateTime(date);
		return dateTime.plusDays(addDays).toDate();
	}
	
	
	/**
	 * 对日期的【月】进行加
	 * 
	 * @param date 日期 —— new Date()
	 * @param addMonths 需要对【月】进行加减的天数。
	 * @return the date 增/减几【月】后的日期
	 */
	public static Date dateAddMonths(Date date, int addMonths) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, addMonths);
		return cal.getTime();
	}
	
	/**
	 * 对日期的【周】进行加
	 * 
	 * @param date 日期 —— new Date()
	 * @param addWeeks 需要对【周】进行加减的天数。
	 * @return the date 增/减几【周】后的日期
	 */
	public static Date dateAddWeeks(Date date, int addWeeks) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_YEAR, addWeeks);
		return cal.getTime();
	}
 
	/**
	 * 对日期的【年】进行加
	 * 
	 * @param date —— new Date()
	 * @param addYears 需要对【年】进行加减的天数。
	 * @return the date 增/减几【年】后的日期
	 */
	public static Date dateAddYears(Date date, int addYears) {
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, addYears);
		return cal.getTime();
	}
 
	/**
	 * 计算两个日期之间的间隔时间
	 * 
	 * @param beginDate 起始日期
	 * @param endDate 结束日期
	 * @return the date length 间隔时间
	 */
	public static int getDateLength(Date beginDate, Date endDate) {
		int length = 0;
		if (beginDate == null || endDate == null)
			return length;
 
		length = (int) ((endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24));
		length++;
		return length;
	}
 
	/**
	 * 获取某天的起始时间
	 * 
	 * @param strDateSegment 字符串类型的日期
	 * @return the date begin 字符串类型的日期 + " 00:00:00"
	 */
	public static String getDateBegin(String strDateSegment) {
		if (strDateSegment == null || strDateSegment.length() <= 0)
			return null;
		return strDateSegment + " 00:00:00";
	}
 
	/**
	 * 获取某天的结束时间
	 * 
	 * @param strDateSegment 字符串类型的日期
	 * @return the date end 字符串类型的日期 + " 23:59:59"
	 */
	public static String getDateEnd(String strDateSegment) {
		if (strDateSegment == null || strDateSegment.length() <= 0)
			return null;
		return strDateSegment + " 23:59:59";
	}
 
	/**
	 * 检查录入的日期格式（yyyyMMdd-yyyyMMdd或yyyyMMdd）.
	 * 
	 * @param strDate 待检验的日期字符串
	 * @return true, if successful
	 */
	public static boolean checkLongDatePattern(String strDate) {
		String ps = "^\\d{4}\\d{1,2}\\d{1,2}-\\d{4}\\d{1,2}\\d{1,2}$|^\\d{4}\\d{1,2}\\d{1,2}$";
		Pattern p = Pattern.compile(ps);
		Matcher m = p.matcher(strDate);
		if (!m.matches()) {
			return false;
		}
		return true;
	}
 
	/**
	 * 检查录入的日期格式（yyyy-MM-dd）.
	 * 
	 * @param strDate 待检验的日期字符串
	 * @return true, if successful
	 */
	public static boolean checkDatePattern(String strDate) {
		String ps = "^\\d{4}-\\d{1,2}-\\d{1,2}$";
		Pattern p = Pattern.compile(ps);
		Matcher m = p.matcher(strDate);
		if (!m.matches()) {
			return false;
		}
		return true;
	}
 
	/**
	 * 检查和格式化日期 param:strDate 
	 * 如:2007-06-01--2007-12-01,
	 * 2007-06-18,20070601--20071201,20070718. 
	 * return:HashMap 格式化以后的date对象：beginDate和endDate 
	 * throws  ParseException 输入的日期格式错误
	 * 
	 * @param strDate the str date
	 * @return the list
	 * @throws ParseException 输入的日期格式错误
	 */
	public static List<Date> transformStrDateToListDate(String strDate) throws ParseException {
		List<Date> dateList = new ArrayList<Date>();
		String[] tempStrDate = strDate.split(",");
		for (int i = 0; i < tempStrDate.length; i++) {
			// 将字符串格式化为“yyyy-MM-dd--yyyy-MM-dd”
			Date tempDate = stringToDate(tempStrDate[i], "yyyy-MM-dd");
			dateList.add(tempDate);
		}
 
		return dateList;
	}
 
	/**
	 * 检查和格式化日期 param:strDate 如:2007-06-01--2007-12-01,2007-06-18,20070601--20071201,20070718 return:HashMap 格式化以后String型的日期：beginDate和endDate throws
	 * ParseException 输入的日期格式错误
	 * 
	 * @param strDate the str date
	 * @return the hash map
	 * @throws ParseException he parse exception
	 */
	public static HashMap<String, String> formatStrDateToDateMap(String strDate) throws ParseException {
		HashMap<String, String> dateMap = new HashMap<String, String>();
 
		Date beginDate = null;
		Date endDate = null;
		if (strDate == null || strDate.trim().length() == 0)
			return null;
 
		if (strDate.indexOf("--") > 0) {
			String[] tempDate = strDate.split("--");
			if (tempDate.length == 2) {
				if (tempDate[0].indexOf("-") > 0) {
					beginDate = stringToDateThrowsExe(tempDate[0], "yyyy-MM-dd");
				} else {
					beginDate = stringToDateThrowsExe(tempDate[0], "yyyyMMdd");
				}
				if (tempDate[1].indexOf("-") > 0) {
					endDate = stringToDateThrowsExe(tempDate[1], "yyyy-MM-dd");
				} else {
					endDate = stringToDateThrowsExe(tempDate[1], "yyyyMMdd");
				}
			} else if (tempDate.length == 1) {
				if (tempDate[0].indexOf("-") > 0) {
					beginDate = stringToDateThrowsExe(tempDate[0], "yyyy-MM-dd");
					endDate = stringToDateThrowsExe(tempDate[0], "yyyy-MM-dd");
				} else {
					beginDate = stringToDateThrowsExe(tempDate[0], "yyyyMMdd");
					endDate = stringToDateThrowsExe(tempDate[0], "yyyyMMdd");
				}
			}
		} else {
			if (strDate.indexOf("-") > 0) {
				beginDate = stringToDateThrowsExe(strDate, "yyyy-MM-dd");
				endDate = stringToDateThrowsExe(strDate, "yyyy-MM-dd");
			} else {
				beginDate = stringToDateThrowsExe(strDate, "yyyyMMdd");
				endDate = stringToDateThrowsExe(strDate, "yyyyMMdd");
			}
		}
		dateMap.put("beginDate", dateToString(beginDate, "yyyy-MM-dd"));
		dateMap.put("endDate", dateToString(endDate, "yyyy-MM-dd"));
		return dateMap;
	}
 
	/**
	 * String to date throws exe.
	 * 
	 * @param strDate the str date
	 * @param pattern the pattern
	 * @return the java.util. date
	 * @throws ParseException the parse exception
	 */
	public static Date stringToDateThrowsExe(String strDate, String pattern) throws ParseException {
		if (strDate == null || strDate.trim().length() <= 0)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(strDate);
	}
 
	/**
	 * 检查日期的先后顺序 param:beginDate endDate return:boolean boolean beginDate<=endDate 返回true；beginDate>endDate返回false
	 * 
	 * @param beginDate the begin date
	 * @param endDate the end date
	 * @return true, if successful
	 */
	public static boolean compareDate(String beginDate, String endDate) {
		if (endDate == null || endDate.trim().length() == 0)
			endDate = beginDate;
 
		Date bDate = stringToDate(beginDate, "yyyy-MM-dd");
		Date eDate = stringToDate(endDate, "yyyy-MM-dd");
 
		if (bDate == null || eDate == null)
			return true;
		if (!bDate.after(eDate))
			return true;
		return false;
	}
 
	/**
	 * 检查输入的日期字符串中的重复日期 param:strDate 格式如：2007-06-01--2007-12-01,2007-06-18,20070601--20071201,20070618 return:list 字符串日期列表
	 * 
	 * @param strDate the str date
	 * @return the list
	 * @throws ParseException the parse exception
	 */
	public static List<String> checkRepeatDate(String strDate) throws ParseException {
		List<String> repeatDateList = new ArrayList<String>();
		Map<Date, String> mediaPlanDateMap = new HashMap<Date, String>();
 
		String[] tempStrDate = strDate.split(",");
 
		for (int k = 0; k < tempStrDate.length; k++) {
			HashMap<String, String> dateMap = new HashMap<String, String>();
			dateMap = DateUtils.formatStrDateToDateMap(tempStrDate[k]);
			if (dateMap == null)
				continue;
 
			String strBeginDate = (String) dateMap.get("beginDate");
			String strEndDate = (String) dateMap.get("endDate");
 
			if (strEndDate == null || strEndDate.length() == 0) {
				strEndDate = strBeginDate;
			}
			// 检查同一个媒介计划有没有重复日期
			Date tmpBeginDate = null;
			Date tmpEndDate = null;
			if (strBeginDate.indexOf("-") > 0) {
				tmpBeginDate = DateUtils.stringToDate(strBeginDate, "yyyy-MM-dd");
				tmpEndDate = DateUtils.stringToDate(strEndDate, "yyyy-MM-dd");
			} else {
				tmpBeginDate = DateUtils.stringToDate(strBeginDate, "yyyyMMdd");
				tmpEndDate = DateUtils.stringToDate(strEndDate, "yyyyMMdd");
			}
 
			int len = DateUtils.getDateLength(tmpBeginDate, tmpEndDate);
			Date tmpDate = null;
			for (int j = 0; j < len; j++) {
				tmpDate = DateUtils.dateAddDays(tmpBeginDate, j);
				if (mediaPlanDateMap.size() > 0) {
					if ("1".equals(mediaPlanDateMap.get(tmpDate))) {
						repeatDateList.add(DateUtils.dateToString(tmpDate, "yyyy-MM-dd"));
					} else {
						mediaPlanDateMap.put(tmpDate, "1");
					}
				} else {
					mediaPlanDateMap.put(tmpDate, "1");
				}
			}
		}
		return repeatDateList;
	}
 
	/**
	 * 获得给定日期中的【年】.
	 * 
	 * @param date 日期
	 * @return 日期中的 年
	 */
	public static String parseYear(Date date) {
		return new SimpleDateFormat(SHORT_PATTERN, java.util.Locale.CHINA).format(date).substring(0, 4);
	}
 
	/**
	 * 获得当前日期中的【年】.
	 * 
	 * @return 日期中的 年
	 */
	public static String parseYear() {
		Date date = Calendar.getInstance().getTime();
		return new SimpleDateFormat(SHORT_PATTERN, java.util.Locale.CHINA).format(date).substring(0, 4);
	}
 
	/**
	 * 获取"yyyy-MM-dd"格式的日期字符串
	 * 
	 * @param date 需要转换成"yyyy-MM-dd"的日期类
	 * @return the string 转换后的字符串
	 */
	public static String dateToSimpleString(java.util.Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
 
	/**
	 * 获取"yyyy-MM-dd"格式的日期
	 * 
	 * @param String the date 需要转换成"yyyy-MM-dd"的日期字符串
	 * @return the java.util. date 转换后的日期类
	 */
	public static java.util.Date stringSimpleToDate(String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			return (java.util.Date) format.parseObject(date);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
 
	/**
	 * 获取月份所属季度
	 * 
	 * @param month 月份
	 * @return the quarter by month 所属季度
	 */
	public static int getQuarterByMonth(int month) {
		if (month >= 1 && month <= 12) {
			return ((month + 2) / 3);
		} else {
			return -1;
		}
	}
 
	/**
	 * 得到date所在周的周日（第一天）.
	 * 
	 * @param date the date
	 * @return the sunday
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date getSunday(Date date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			int intWeek = c.get(c.DAY_OF_WEEK);
			c.add(c.DATE, -(intWeek - 1));
			date = (c.getTime());
		} catch (Exception e) {
			System.err.println("ReportGatekeeper.java--getSunday:" + e);
		}
 
		return date;
	}
 
	/**
	 * * 得到date所在周，周六（最后一天）.
	 * 
	 * @param date the date
	 * @return the saturday
	 * @return
	 */
	@SuppressWarnings("static-access")
	public static Date getSaturday(Date date) {
		try {
			Calendar c = Calendar.getInstance();
			c.setTime(getSunday(date));
			c.add(c.DATE, 6);
			date = (c.getTime());
		} catch (Exception e) {
			System.err.println("ReportGatekeeper.java--getSunday:" + e);
		}
 
		return date;
	}
 
	/**
	 * 得到某月的第一天
	 * 
	 * @param date the date
	 * @return the first day in month
	 */
	public static Date getFirstDayInMonth(Date date) {
		String dateString = DateUtils.dateToSimpleString(date);
		dateString = dateString.substring(0, 8);
		dateString = dateString.concat("01");
		date = DateUtils.stringToDate(dateString);
		return date;
	}
 
	/**
	 * 得到某个季度的第一天
	 * 
	 * @param date the date
	 * @return the first day in quarter
	 */
	public static Date getFirstDayInQuarter(Date date) {
		String dateString = DateUtils.dateToSimpleString(date);
		String t = dateString.substring(5, 7);
		dateString = dateString.substring(0, 5);
		int i = new Integer(t).intValue();
		int q = getQuarterByMonth(i);
		int month = (q - 1) * 3 + 1;
		if (month < 10)
			dateString = dateString.concat("0" + month);
		else
			dateString = dateString.concat("" + month);
		dateString = dateString.concat("-01");
		date = DateUtils.stringToDate(dateString);
		return date;
	}
 
	/**
	 * 得到某年的第一天
	 * 
	 * @param date the date
	 * @return the first day in year
	 */
	public static Date getFirstDayInYear(Date date) {
		String dateString = DateUtils.dateToSimpleString(date);
		String t = dateString.substring(0, 4);
		dateString = t.concat("-01-01");
		date = DateUtils.stringToDate(dateString);
		return date;
	}
 
	/**
	 * 得到某年的最后一天
	 * 
	 * @param date the date
	 * @return the last day in year
	 */
	public static Date getLastDayInYear(Date date) {
		Date tmp = DateUtils.getFirstDayInYear(date);
		tmp = DateUtils.dateAddYears(tmp, 1);
		tmp = DateUtils.dateAddDays(tmp, -1);
		return tmp;
	}
 
	/**
	 * 得到某月的最后一天
	 * 
	 * @param firstDayInMonth the first day in month
	 * @return the last day in month
	 */
	public static Date getLastDayInMonth(Date firstDayInMonth) {
		Date tmp = DateUtils.dateAddMonths(firstDayInMonth, 1);
		tmp = DateUtils.getFirstDayInMonth(tmp);
		tmp = DateUtils.dateAddDays(tmp, -1);
		return tmp;
	}
 
	/**
	 * 得到某个季度的最后一天
	 * 
	 * @param value the value
	 * @return the last day in quarter
	 */
	public static Date getLastDayInQuarter(Date value) {
		Date tmp = DateUtils.getFirstDayInQuarter(value);
		tmp = DateUtils.dateAddMonths(tmp, 3);
		tmp = DateUtils.dateAddDays(tmp, -1);
		return tmp;
	}
 
//	/**
//	 * 获取一周的第一天 周一为第一天
//	 * 
//	 * @param date
//	 * @return Date
//	 */
//	public static Date getFirstDayOfWeek(Date date) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//		if (dayOfWeek == 0) {
//			dayOfWeek = 7;
//		}
//		return org.apache.commons.lang.time.DateUtils.addDays(date, 1 - dayOfWeek);
//	}
 
//	/**
//	 * 获取一周最后一天 周一为第一天
//	 * 
//	 * @param date
//	 * @return Date
//	 */
//	public static Date getLastDayOfWeek(Date date) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//		if (dayOfWeek == 0) {
//			dayOfWeek = 7;
//		}
//		return org.apache.commons.lang.time.DateUtils.addDays(date, 7 - dayOfWeek);
//	}
// 
	
	
	public static String formatDate(Date date) {
		if (null == date) {
			return "";
		}
		String dateStr = new SimpleDateFormat(PATTERN_THREE, java.util.Locale.CHINA).format(date);
		return dateStr;
	}
	
	/**
	 * 返回当前日期的格式化字符串.
	 * 
	 * @param tag 0:yyyy-MM-dd HH:mm:ss;1:yyyyMMddHHmmss;2:yyyy-MM-dd;3:yyyyMM
	 * @return 格式化成字符串的日期
	 */
	public static String formatDate(int tag) {
		Date date = Calendar.getInstance().getTime();
		String dateStr = null;
		switch (tag) {
		case 0:
			dateStr = new SimpleDateFormat(LONG_PATTERN, java.util.Locale.CHINA).format(date);
			break;
		case 1:
			dateStr = new SimpleDateFormat(SHORT_PATTERN, java.util.Locale.CHINA).format(date);
			break;
		case 2:
			dateStr = new SimpleDateFormat(PATTERN_THREE, java.util.Locale.CHINA).format(date);
			break;
		case 3:
			dateStr = new SimpleDateFormat(PATTERN_FOUR, java.util.Locale.CHINA).format(date);
			break;
		default:
			dateStr = new SimpleDateFormat(LONG_PATTERN, java.util.Locale.CHINA).format(date);
			break;
		}
		return dateStr;
	}
 
	public static boolean dateCompare(Date date1, Date date2) {
		if (date1.getTime() < date2.getTime()) {
			return true;
		}
		return false;
	}
	
	/**
	 * 计算两个日期间的差值，返回指定单位类型
	 * 
	 * @param startdate 起始日期
	 * @param enddate 急速日期
	 * @param iType 0-分钟；1-小时；2-天；3-月；4-年。
	 */
	public static int dateCal(Date startdate, Date enddate, int iType) {
		Calendar calBegin = parseDateTime(startdate);
		Calendar calEnd = parseDateTime(enddate);
		long lBegin = calBegin.getTimeInMillis();
		long lEnd = calEnd.getTimeInMillis();
		int ss = (int) ((lEnd - lBegin) / 1000L);
		int min = ss / 60;
		int hour = min / 60;
		int day = hour / 24;
		if (iType == MINITE_TYPE)
			return min;
		if (iType == HOUR_TYPE)
			return hour;
		if (iType == DAY_TYPE)
			return day;
		else
			return -1;
	}
	
	public static Calendar parseDateTime(Date d) {
 
		Calendar cal = Calendar.getInstance();
		int yy = 0, mm = 0, dd = 0, hh = 0, mi = 0, ss = 0;
		cal.setTime(d);
 
		yy = cal.get(Calendar.YEAR);
		mm = cal.get(Calendar.MONTH);
		dd = cal.get(Calendar.DAY_OF_MONTH);
		hh = cal.get(Calendar.HOUR_OF_DAY);
		mi = cal.get(Calendar.MINUTE);
		ss = cal.get(Calendar.SECOND);
 
		cal.set(yy, mm, dd, hh, mi, ss);
		return cal;
	}
 
	/**
	 * 测试main函数
	 * 
	 * @param args the arguments
	 * @throws ParseException 
	 */
	public static void main(String args[]) throws ParseException {
		//测试获取当前时间，分位+1
		Date dateAddMinutes = DateUtils.dateAddMinutes(new Date(),1);
		String dateToString = DateUtils.dateToString(dateAddMinutes, LONG_PATTERN);
		System.out.println(dateToString);
		
	}
	
	
}