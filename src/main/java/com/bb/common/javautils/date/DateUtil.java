package com.bb.common.javautils.date;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author bb
 * @date 2020/7/11
 * @implNote 只处理日期，不处理时间
 * @implSpec
 */
public class DateUtil {

    /**
     * 在指定的日期上倒回XX年
     *
     * @param date            日期对象
     * @param yearsToSubtract 要倒回的年数
     * @return 时间倒回后的LocalDate对象
     */
    public static Date minusYears(Date date, int yearsToSubtract) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, -yearsToSubtract);
        return calendar.getTime();
    }

    public static LocalDate minusYears(Date date, long yearsToSubtract) {
        return DateConvertUtil.dateToLocalDate(date).minusYears(yearsToSubtract);
    }

    public static LocalDate plusYears(Date date, long yearsToAdd) {
        return DateConvertUtil.dateToLocalDate(date).plusYears(yearsToAdd);
    }

    /**
     * 在指定的日期上倒回XX年
     *
     * @param localDate       日期对象
     * @param yearsToSubtract 要倒回的年数
     * @return 时间倒回后的Date对象
     */
    public static Date minusYears(LocalDate localDate, long yearsToSubtract) {
        return DateConvertUtil.localDateToDate(localDate.minusYears(yearsToSubtract));
    }

    public static Date plusYears(LocalDate date, long yearsToAdd) {
        return DateConvertUtil.localDateToDate(date.plusYears(yearsToAdd));
    }

    /**
     * 在指定的日期上倒回XX月
     *
     * @param date             日期对象
     * @param monthsToSubtract 要倒回的月数
     * @return 时间倒回后的LocalDate对象
     */
    public static LocalDate minusMonths(Date date, long monthsToSubtract) {
        return DateConvertUtil.dateToLocalDate(date).minusMonths(monthsToSubtract);
    }

    /**
     * 在指定的日期上倒回XX月
     *
     * @param localDate        日期对象
     * @param monthsToSubtract 要倒回的月数
     * @return 时间倒回后的Date对象
     */
    public static Date minusMonths(LocalDate localDate, long monthsToSubtract) {
        return DateConvertUtil.localDateToDate(localDate.minusMonths(monthsToSubtract));
    }

    /**
     * 在指定的日期上倒回XX天
     *
     * @param date           日期对象
     * @param daysToSubtract 要倒回的天数
     * @return 时间倒回后的LocalDate对象
     */
    public static LocalDate minusDays(Date date, long daysToSubtract) {
        return DateConvertUtil.dateToLocalDate(date).minusDays(daysToSubtract);
    }

    /**
     * 在指定的日期上倒回XX天
     *
     * @param localDate      日期对象
     * @param daysToSubtract 要倒回的天数
     * @return 时间倒回后的Date对象
     */
    public static Date minusDays(LocalDate localDate, long daysToSubtract) {
        return DateConvertUtil.localDateToDate(localDate.minusDays(daysToSubtract));
    }
}
