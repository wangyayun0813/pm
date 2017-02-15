package com.yling.common.base;

import java.util.List;

/**
 * 文件名：
 * 描述：统一返回
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
public class Result<T>
{
    private boolean success;
    private StringBuffer msg;
    private T date;
    private List<T> dates;

    public Result()
    {
        this.msg = new StringBuffer();
        this.success = true;
    }

    public Result(String error)
    {
        this.msg = new StringBuffer(error);
        this.success = false;
    }

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public StringBuffer getMsg()
    {
        return msg;
    }

    public void setMsg(StringBuffer msg)
    {
        this.msg = msg;
    }

    public T getDate()
    {
        return date;
    }

    public void setDate(T date)
    {
        this.date = date;
    }

    public List<T> getDates()
    {
        return dates;
    }

    public void setDates(List<T> dates)
    {
        this.dates = dates;
    }

    public void append(String msg)
    {
        if(null == this.msg)
            this.msg = new StringBuffer();
        this.msg.append(msg).append("<br/>");
    }

    public static Result error(String error)
    {
        return new Result(error);
    }

}
