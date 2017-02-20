package com.yling.modules.controllers;

import com.yling.common.base.BaseController;
import com.yling.common.base.Result;
import com.yling.common.page.Page;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
@IocBean
@At("/sys")
public class HomeController extends BaseController
{
    @At("/home")
    @Ok("beetl:sys/home.html")
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

    @At("/sysLog")
    @Ok("beetl:sys/sysLog.html")
    public void sysLog(HttpServletRequest request, @Param("pageNo")int pageNo,@Param("pageSize") int pageSize)
    {
        Page page = sysLogService.listPage(pageNo, pageSize, Cnd.NEW().desc("create_time"));
        request.setAttribute("p",page);
    }
}
