package com.yling.common.base;

/**
 * 文件名：
 * 描述：统一异常
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
public class BaseException extends Exception
{
    private int code;
    private String operatingMsg;

    public BaseException(String message, int code, String operatingMsg)
    {
        super(message);
        this.code = code;
        this.operatingMsg = operatingMsg;
    }

    public BaseException(int code,String message)
    {
        super(message);
        this.code = code;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getOperatingMsg()
    {
        return operatingMsg;
    }

    public void setOperatingMsg(String operatingMsg)
    {
        this.operatingMsg = operatingMsg;
    }
}
