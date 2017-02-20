package com.yling.modules.controllers;

import com.yling.common.annotation.SLog;
import com.yling.common.base.BaseController;
import com.yling.common.base.Result;
import com.yling.common.page.Page;
import com.yling.modules.models.User;
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
@At("/user")
public class UserController extends BaseController
{
    @At("")
    @Ok("beetl:user/list.html")
    public void index(HttpServletRequest req, @Param("pageNo")int pageNo,@Param("pageSize")int pageSize)
    {
        Page page = userService.listPage(pageNo, pageSize, Cnd.NEW().desc("create_time"));
        getReq().setAttribute("p", page);
    }

    @At("/json")
    @Ok("json:{ignoreNull:true}")
    @SLog(tag = "xxxxxx",obj = "qqqqqq")
    public Object json()
    {
        Result<User> result = new Result<User>();
        User user = new User();
        user.setName("张三");
        user.setNick("周四去");
        result.setDate(user);
        result.append("[成功]操作1");
        result.append("[成功]操作2");
        result.append("[成功]操作3");
        result.append("[成功]操作4");
        return result;
    }
}
