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
     * Date转换为LocalDate
     *
     * @param date Date对象
     * @return LocalDate对象
     */
    public static LocalDate dateToLocalDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
    }

    /**
     * LocalDate转换为Date
     *
     * @param localDate LocalDate对象
     * @return Date对象
     */
    public static Date localDateToDate(LocalDate localDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(localDate.getYear(), localDate.getMonthValue() - 1, localDate.getDayOfMonth());
        return calendar.getTime();
    }
}
