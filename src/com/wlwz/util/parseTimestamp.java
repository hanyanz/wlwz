package com.wlwz.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class parseTimestamp {
	public static Timestamp parseTimestamp(String strDate)
			throws ParseException {
		Date armFormateDate = null;

		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		DateFormat format = new SimpleDateFormat("yyyyMMdd");

		armFormateDate = format.parse(strDate);

		strDate = df1.format(armFormateDate);

		Timestamp ts1 = Timestamp.valueOf(strDate);

		return ts1;

	}

}
