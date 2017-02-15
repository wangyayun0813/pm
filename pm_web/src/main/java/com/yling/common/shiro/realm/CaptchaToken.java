package com.yling.common.shiro.realm;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 文件名：
 * 描述：加上验证码的token
 * 创建人： wangyayun
 * 创建时间： 2017/2/15.
 * 修改人：
 */
public class CaptchaToken extends UsernamePasswordToken
{
    private String captcha;
    public CaptchaToken(String username, String password, boolean rememberMe, String host,String captcha)
    {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }

    public String getCaptcha()
    {
        return captcha;
    }

    public void setCaptcha(String captcha)
    {
        this.captcha = captcha;
    }
}
