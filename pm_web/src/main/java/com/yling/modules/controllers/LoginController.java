package com.yling.modules.controllers;

import com.yling.common.base.BaseException;
import com.yling.common.filter.ShiroAuthenticationFilter;
import com.yling.common.shiro.realm.CaptchaToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
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
public class LoginController
{
    @At("")
    @Ok("re")
    public String index() throws Exception
    {

        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())
            return ">>:/home";
        else return "beetl:login.html";
    }

    @At("/doLogin")
    @Ok(">>:/home")
    @Filters(@By(type = ShiroAuthenticationFilter.class))
    public void doLogin(@Attr("loginToken") CaptchaToken token)throws Exception
    {
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
        } catch (AuthenticationException e)
        {
            throw new BaseException(11,e.getMessage());
        }catch (Exception e)
        {
            throw e;
        }
    }
}
