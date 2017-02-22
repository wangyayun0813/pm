package com.yling.common.aop.interceptor;

import com.yling.common.annotation.SLog;
import com.yling.common.base.Result;
import com.yling.common.base.SiteContants;
import com.yling.modules.models.User;
import com.yling.modules.service.SysLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.Ioc;
import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.lang.reflect.Method;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
public class SLogInterceptor implements MethodInterceptor
{
    protected static final Log logger = Logs.getLog(SLogInterceptor.class);
    private Ioc ioc;
    private SLog sLog;
    private String tag;
    private String obj;
    private String info;
    private SysLogService sysLogService;
    public SLogInterceptor(Ioc ioc, SLog sLog, Method method, SysLogService sysLogService)
    {
        this.ioc = ioc;
        this.sLog = sLog;
        this.tag = sLog.tag();
        this.obj = sLog.obj();
        this.info = sLog.info();
        this.sysLogService = sysLogService;
        if(Strings.isEmpty(obj))
        {
            this.obj = method.getDeclaringClass().getName() + "#" + method.getName();
        }
    }

    @Override
    public void filter(InterceptorChain chain) throws Throwable
    {
        chain.doChain();
        doLog(chain);
    }

    private void doLog(InterceptorChain chain)
    {
        Object ret = chain.getReturn();
        short opResult = SiteContants.FLAG_YES;
        if(ret instanceof Result)
        {
            Result result = (Result) ret;
            this.info = result.getMsg().toString();
            opResult = result.isSuccess()? SiteContants.FLAG_YES:SiteContants.FLAG_NO;
        }
        try
        {
            Subject subject = SecurityUtils.getSubject();
            User user = (User) subject.getPrincipal();
            Long userId = user.getId();
            String nick = user.getNick();
            sysLogService.save(userId, nick, tag, obj, this.info, opResult);
        } catch (Exception e)
        {
            logger.error(e.getMessage() ,e);
        }
    }
}
