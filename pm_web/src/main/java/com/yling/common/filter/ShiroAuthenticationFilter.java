package com.yling.common.filter;

import com.yling.common.shiro.realm.CaptchaToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;

import javax.servlet.http.HttpServletRequest;

/**
 * 文件名：
 * 描述：过滤器 给参数赋值loginToken
 * 创建人： wangyayun
 * 创建时间： 2017/2/15.
 * 修改人：
 */
public class ShiroAuthenticationFilter extends FormAuthenticationFilter implements ActionFilter
{
    @Override
    public View match(ActionContext actionContext)
    {
        HttpServletRequest request = actionContext.getRequest();
        CaptchaToken token = createToken(request);
        request.setAttribute("loginToken",token);
        return null;
    }

    private CaptchaToken createToken(HttpServletRequest request)
    {
        String username = getUsername(request);
        String password = getPassword(request);
        String host = getHost(request);
        boolean rememberMe = isRememberMe(request);
        String captcha = WebUtils.getCleanParam(request,"captcha");
        return new CaptchaToken(username,password,rememberMe,host,captcha);
    }
}
