package com.jsyunsi.algorithm;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 日期类型转换
 * 1.String类型转换Date类型
 * 2.Date类型转换String类型
 */

public class DateTransform {

    /*将String类型时间转换为Date类型*/
    public static Date StringToDate(String string1, String string2) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string2);
        Date date = simpleDateFormat.parse(string1);
        return date;
    }

    /*将Date类型时间转换为String类型*/
    public static String DateToString(Date date, String string) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string);
        String stringDate = simpleDateFormat.format(date);
        return stringDate;
    }
}
