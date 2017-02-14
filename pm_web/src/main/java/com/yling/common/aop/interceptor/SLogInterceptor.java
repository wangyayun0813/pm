package com.yling.common.aop.interceptor;

import com.yling.common.annotation.SLog;
import com.yling.common.base.Result;
import com.yling.common.util.StringUtil;
import com.yling.modules.models.SysLog;
import com.yling.modules.service.SysLogService;
import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.Ioc;
import org.nutz.lang.Strings;

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
    private Ioc ioc;
    private SLog sLog;
    private String tag;
    private String obj;
    private SysLogService sysLogService;
    public SLogInterceptor(Ioc ioc, SLog sLog, Method method)
    {
        this.ioc = ioc;
        this.sLog = sLog;
        this.tag = sLog.tag();
        this.obj = sLog.obj();
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
        if(ret instanceof Result)
        {
            Result result = (Result) ret;
            String ip = StringUtil.getRemoteAddr();
            Long userId = 1l;
            String nick = "zhangSan";
            SysLog sysLog = SysLog.c(userId,nick,tag,obj,result.getMsg().toString(),(result.isSuccess()?(short) 1:(short)2));
            if(sysLogService == null)
                sysLogService = ioc.get(SysLogService.class);
            sysLogService.dao().insert(sysLog);
        }
    }
}
