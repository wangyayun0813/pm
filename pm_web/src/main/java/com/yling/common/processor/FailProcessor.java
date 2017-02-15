package com.yling.common.processor;

import com.yling.common.base.BaseException;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.ViewProcessor;
import org.nutz.mvc.view.ForwardView;

/**
 * 文件名：
 * 描述：异常处理
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
public class FailProcessor extends ViewProcessor
{
    protected static final String SYS_ERROR_URI = "/sysError";
    protected static final String USE_ERROR_URI = "/userError";

    @Override
    public void process(ActionContext ac) throws Throwable
    {
        Throwable error = ac.getError();
        if(error!=null)
        {
            if(error instanceof BaseException)
            {
                BaseException be = (BaseException) error;
                ac.getRequest().setAttribute("errorMsg",be.getMessage());
                ac.getRequest().setAttribute("errorCode",be.getCode());
                new ForwardView(USE_ERROR_URI).render(ac.getRequest(), ac.getResponse(), null);
            }else {
                ac.getRequest().setAttribute("errorMsg",error.getMessage());
                new ForwardView(SYS_ERROR_URI).render(ac.getRequest(), ac.getResponse(), null);
            }
            return;
        }
        super.process(ac);
    }
}
