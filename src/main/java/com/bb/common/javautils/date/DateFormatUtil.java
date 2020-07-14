package com.bb.common.javautils.date;


import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 日期格式化工具
 *
 * @author bb
 * @date 2020/7/11
 * @implNode
 * @implSpec
 */
public class DateFormatUtil {

    public static final String YYYY_MM_DD_NOTHING = "yyyyMMdd";
    public static final String YYYY_MM_DD_HH_MM_SS_NOTHING = "yyyyMMddHHmmss";
    public static final String YYYY_MM_DD_WITH_MIDDLE_LINE = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS_WITH_MIDDLE_LINE = "yyyy-MM-dd HH:mm:ss";

    /**
     * simpleDateFormat对象的缓存
     */
    private static Map<String, SimpleDateFormat> formatMap = new ConcurrentHashMap<>(8);

    static {
        formatMap.put(YYYY_MM_DD_NOTHING, new SimpleDateFormat(YYYY_MM_DD_NOTHING));
        formatMap.put(YYYY_MM_DD_HH_MM_SS_NOTHING, new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_NOTHING));
        formatMap.put(YYYY_MM_DD_WITH_MIDDLE_LINE, new SimpleDateFormat(YYYY_MM_DD_WITH_MIDDLE_LINE));
        formatMap.put(YYYY_MM_DD_HH_MM_SS_WITH_MIDDLE_LINE, new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS_WITH_MIDDLE_LINE));
    }

    /**
     * 按 yyyyMMdd 格式化
     *
     * @param date 日期对象
     * @return yyyyMMdd格式化后的字符串
     */
    public static String formatToYyyyMmDd(@NotNull LocalDate date) {
        return format(date, YYYY_MM_DD_NOTHING);
    }

    public static String formatToYyyyMmDd(@NotNull Date date) {
        return format(date, YYYY_MM_DD_NOTHING);
    }

    /**
     * 按 yyyyMMddHHmmss 格式化
     *
     * @param date 日期对象
     * @return yyyyMMddHHmmss格式化后的字符串
     */
    public static String formatToYyyyMmDdHhMmSs(@NotNull LocalDate date) {
        return format(date, YYYY_MM_DD_HH_MM_SS_NOTHING);
    }

    public static String formatToYyyyMmDdHhMmSs(@NotNull Date date) {
        return format(date, YYYY_MM_DD_HH_MM_SS_NOTHING);
    }

    /**
     * 按 yyyy-MM-dd 格式化
     *
     * @param date 日期对象
     * @return yyyy-MM-dd 格式化后的字符串
     */
    public static String formatToYyyyMmDdWithMiddleLine(@NotNull LocalDate date) {
        return format(date, YYYY_MM_DD_WITH_MIDDLE_LINE);
    }

    public static String formatToYyyyMmDdWithMiddleLine(@NotNull Date date) {
        return format(date, YYYY_MM_DD_WITH_MIDDLE_LINE);
    }

    /**
     * 按 yyyy-MM-dd HH:mm:ss 格式化
     *
     * @param date 日期对象
     * @return yyyy-MM-dd HH:mm:ss 格式化后的字符串
     */
    public static String formatToYyyyMmDdHhMmSsWithMiddleLine(@NotNull LocalDate date) {
        return format(date, YYYY_MM_DD_HH_MM_SS_WITH_MIDDLE_LINE);
    }

    public static String formatToYyyyMmDdHhMmSsWithMiddleLine(@NotNull Date date) {
        return format(date, YYYY_MM_DD_HH_MM_SS_WITH_MIDDLE_LINE);
    }

    /**
     * 按用户指定的pattern来格式化
     *
     * @param date    日期
     * @param pattern 模式，比如：yyyy-MM-dd
     * @return 格式化后的日期字符串
     */
    public static String format(@NotNull LocalDate date, @NotNull String pattern) {
        Objects.requireNonNull(date);
        Objects.requireNonNull(pattern);
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 按用户指定的pattern来格式化
     *
     * @param date    日期
     * @param pattern 模式, 比如: yyyy-MM-dd
     * @return 格式化后的日期字符串
     */
    public static String format(@NotNull Date date, @NotNull String pattern) {
        Objects.requireNonNull(date);
        Objects.requireNonNull(pattern);
        SimpleDateFormat sf;
        if (formatMap.containsKey(pattern)) {
            sf = formatMap.get(pattern);
        } else {
            sf = new SimpleDateFormat(pattern);
            formatMap.put(pattern, sf);
        }
        return sf.format(date);
    }
}
