package com.yling.common.processor;

import com.yling.common.base.BaseException;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.ViewProcessor;
import org.nutz.mvc.view.ServerRedirectView;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件名：
 * 描述：异常处理
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
public class FailProcessor extends ViewProcessor
{
    protected static final String SYS_ERROR_URI = "sysError";
    protected static final String USE_ERROR_URI = "userError";

    @Override
    public void process(ActionContext ac) throws Throwable
    {
        Throwable error = ac.getError();
        if(error!=null)
        {
            HttpServletResponse res = ac.getResponse();
            if(error instanceof BaseException)
            {
                new ServerRedirectView(USE_ERROR_URI).render(ac.getRequest(), ac.getResponse(), null);
            }else {
                new ServerRedirectView(SYS_ERROR_URI).render(ac.getRequest(), ac.getResponse(), null);
            }
            return;
        }
        super.process(ac);
    }
}
