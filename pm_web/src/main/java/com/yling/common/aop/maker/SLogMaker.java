package com.yling.common.aop.maker;

import com.yling.common.annotation.SLog;
import com.yling.common.aop.interceptor.SLogInterceptor;
import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.aop.SimpleAopMaker;
import org.nutz.ioc.loader.annotation.IocBean;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
@IocBean(name="$aop_syslog")
public class SLogMaker extends SimpleAopMaker<SLog>
{
    @Override
    public List<? extends MethodInterceptor> makeIt(SLog sLog, Method method, Ioc ioc)
    {
        return Arrays.asList(new SLogInterceptor(ioc,sLog,method));
    }
}
