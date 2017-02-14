package com.yling.modules.controllers;

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
@At("/")
public class HomeController
{
    @At(top = true,value = "/sysError")
    @Ok("beetl:error/sysError.html")
    public void sysError()
    {
    }

    @At(top = true,value = "/userError")
    @Ok("beetl:error/userError.html")
    public void userError()
    {
    }
}
