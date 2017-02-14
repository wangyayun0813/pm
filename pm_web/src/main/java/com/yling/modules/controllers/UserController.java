package com.yling.modules.controllers;

import com.yling.modules.models.User;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
@IocBean
@At("/user")
public class UserController
{
    @At("")
    @Ok("beetl:index.html")
    public void index(HttpServletRequest req)
    {
        User user = new User();
        user.setName("zhangSan");
        user.setNick("admin");
        req.setAttribute("user",user);
    }

    @At("/json")
    @Ok("json:{ignoreNull:true}")
    public Object json()
    {
        User user = new User();
        user.setName("张三");
        user.setNick("周四去");
        return user;
    }
}
