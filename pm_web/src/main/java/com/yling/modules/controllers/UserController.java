package com.yling.modules.controllers;

import com.yling.common.annotation.SLog;
import com.yling.common.base.BaseController;
import com.yling.common.base.Result;
import com.yling.common.page.Page;
import com.yling.modules.models.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.util.cri.SqlExpressionGroup;
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
    public void index(HttpServletRequest req, @Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("name") String name)
    {
        Condition cnd = Cnd.NEW();
        if(!StringUtils.isEmpty(name))
        {
            SqlExpressionGroup g1 = Cnd.exps("name", "like", "%" + name + "%");
            SqlExpressionGroup g2 = Cnd.exps("nick", "like", "%" + name + "%");
            SqlExpressionGroup g3 = Cnd.exps("login_name", "like", "%" + name + "%");
            cnd = Cnd.where(g1).or(g2).or(g3).desc("create_time");
        }
        Page page = userService.listPage(pageNo, pageSize, cnd);
        getReq().setAttribute("p", page);
        getReq().setAttribute("name", name);
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

    @At("/delete")
    @RequiresPermissions("user.delete")
    @SLog(tag = "删除用户")
    public Result delete(@Param("userId") Long userId)
    {
        Result result = new Result();
        result.append("删除成功！");
        result.setDate(userId);
        return result;
    }
}
