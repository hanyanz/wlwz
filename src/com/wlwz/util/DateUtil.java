package com.wlwz.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {

	/**
	 * @param args
	 */
	/**
	 * 
	 * @param dateStr
	 *            日期字符�?
	 * @return 分析成功返回Date 失败返回null
	 */
	public Date getDate(String dateStr) {
		if (dateStr == null)
			return null;
		String date = null;
		if (dateStr.contains("/")) {
			date = "yyyy/MM/dd";
		} else if (dateStr.contains("-")) {
			date = "yyyy-MM-dd";
		} else {
			date = "yyyy-MM-dd";
		}
		return new SimpleDateFormat(date).parse(dateStr, new ParsePosition(0));
	}

	public String getString(Date date) {
		if (null == date) {
			return null;
		}
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
