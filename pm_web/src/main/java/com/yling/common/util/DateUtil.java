package com.yling.common.util;

import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名：
 * 描述：Date处理工具类
 * 创建人： wangyayun
 * 创建时间： 2017/2/10.
 * 修改人：
 */
public class DateUtil
{
    public static final Logger logger = Logger.getLogger(DateUtil.class);
    public static final String SIMPLE_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 获取当前日期timestamp
     *
     * @return
     */
    public static Timestamp timestamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp timestamp(Date date)
    {
        return new Timestamp(date.getTime());
    }

    public static String formatDate(Date date, String format)
    {
        if(null == date)
            return "";
        String str = "";
        try
        {
            DateFormat df = new SimpleDateFormat(format);
            str = df.format(date);
        } catch (Exception e)
        {
            logger.error(e.getMessage(), e);
        }
        return str;
    }

    public static String formatDate(Date date)
    {
        return formatDate(date, SIMPLE_DATE_FORMAT);
    }

    public static int dateInt(Date date)
    {
        String str = formatDate(date, "yyyyMMdd");
        if(str!=null && str.trim().length()>0)
        {
            return Integer.valueOf(str);
        }
        return 0;
    }

    public static int dateInt()
    {
        return dateInt(new Date());
    }

    public static void main(String[] args)
    {
        System.out.println(DateUtil.dateInt());
    }
}
