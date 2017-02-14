package com.yling.modules.controllers;

import com.yling.common.base.BaseException;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
@IocBean
@At("/login")
public class LoginController
{
    @At("")
    @Ok("beetl:login.html")
    public void index() throws Exception
    {
        throw new BaseException(1,"baseXXXX");
    }
}
