package com.yling.runner;

import com.yling.common.core.Module;
import org.junit.runners.model.InitializationError;
import org.nutz.mock.NutTestRunner;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/10.
 * 修改人：
 */
public class NutzTestRunner extends NutTestRunner
{
    public NutzTestRunner(Class<?> klass) throws InitializationError
    {
        super(klass);
    }

    @Override
    protected Class<?> getMainModule()
    {
        return Module.class;
    }
}
