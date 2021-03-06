package com.yling.modules.controllers;

import com.yling.common.base.BaseController;
import com.yling.common.base.SiteContants;
import com.yling.common.filter.ShiroAuthenticationFilter;
import com.yling.common.shiro.exception.MyAuthenticationException;
import com.yling.common.shiro.realm.CaptchaToken;
import com.yling.common.util.DateUtil;
import com.yling.common.util.StringUtil;
import com.yling.modules.models.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.*;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
@IocBean
@At("/login")
public class LoginController extends BaseController
{
    @At("")
    @Ok("re")
    public String index() throws Exception
    {

        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())
            return ">>:/sys/home";
        else return "beetl:login.html";
    }

    @At("/doLogin")
    @Ok("re")
    @Filters(@By(type = ShiroAuthenticationFilter.class))
    public String doLogin(@Attr("loginToken") CaptchaToken token)throws Exception
    {
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            getReq().getSession().setAttribute("user",user);
            sysLogService.save(user.getId(), user.getNick(), "登录", "LoginController#doLogin", "", SiteContants.FLAG_YES);
            org.nutz.dao.Chain chain = Chain.make("last_ip", StringUtil.getRemoteAddr())
                    .add("login_num", user.getLoginNum() != null ? user.getLoginNum() + 1 : 1)
                    .add("last_time", DateUtil.timestamp());
            userService.update(chain, Cnd.where("id","=",user.getId()));
            return ">>:/sys/home";
        }catch (MyAuthenticationException e){
            getReq().setAttribute("errorMsg",e.getMessage());
            getReq().setAttribute("username",token.getUsername());
            getReq().setAttribute("password",token.getPassword());
            return "->:/login";
        }catch (AuthenticationException e)
        {
            getReq().setAttribute("errorMsg","密码错误！");
            getReq().setAttribute("username",token.getUsername());
            getReq().setAttribute("password",token.getPassword());
            return "->:/login";
        }catch (Exception e)
        {
            throw e;
        }
    }

    @At
    @Ok("beetl:regist.html")
    public void regist()
    {
    }

    @At
    @Ok(">>:/login")
    @RequiresAuthentication
    public void logout()
    {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        getReq().getSession().removeAttribute("user");
        sysLogService.save(user.getId(), user.getNick(), "退出登录", "LoginController#logout", "", SiteContants.FLAG_YES);
        subject.logout();
    }
}
