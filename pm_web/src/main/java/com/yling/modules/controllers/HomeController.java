package com.yling.modules.controllers;

import com.yling.common.base.BaseController;
import com.yling.common.base.Result;
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
@At("/home")
public class HomeController extends BaseController
{
    @At("")
    public Object home()
    {
        return new Result<>("xxxx");
    }

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

    @At(top = true,value = "/noPermission")
    @Ok("beetl:error/noPermission.html")
    public void noPermission()
    {
    }
}
