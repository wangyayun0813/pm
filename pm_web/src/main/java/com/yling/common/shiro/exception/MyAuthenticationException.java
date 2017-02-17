package com.yling.common.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/17.
 * 修改人：
 */
public class MyAuthenticationException extends AuthenticationException
{
    public MyAuthenticationException(String message)
    {
        super(message);
    }
}
