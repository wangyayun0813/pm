package com.yling.common.beetl.format;

import org.beetl.core.Format;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/17.
 * 修改人：
 */
public class TimestampFormat implements Format
{
    @Override
    public Object format(Object data, String format)
    {
        if(null == data)
            return null;
        if(data instanceof  Timestamp)
        {
            Timestamp timestamp = (Timestamp) data;
            long time = timestamp.getTime();
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.format(d);
        }else throw new RuntimeException("类型错误");
    }
}
