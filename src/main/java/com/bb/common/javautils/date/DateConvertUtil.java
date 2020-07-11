package com.bb.common.javautils.date;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换工具
 *
 * @author bb
 * @date 2020/7/11
 * @implNode java.util.Date 与 java.time.LocalDate 之间互转
 * @implSpec
 */
public class DateConvertUtil {

    /**
     * @param date
     * @return
     */
    public static LocalDate convertToLocalDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
    }

    /**
     * @param localDate
     * @return
     */
    public static Date convertToDate(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(localDate.getYear(), localDate.getMonth().getValue(), localDate.getDayOfMonth());
        return calendar.getTime();
    }
}
