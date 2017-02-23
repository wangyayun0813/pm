package com.yling.common.processor;

import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/23.
 * 修改人：
 */
public class XssFilterProcessor extends AbstractProcessor
{
    @Override
    public void process(ActionContext ac) throws Throwable
    {

        doNext(ac);
    }
}
class XssRequestWrapper extends HttpServletRequestWrapper
{

    public XssRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }

    @Override
    public String getParameter(String name)
    {
        String value = super.getParameter(name);
        return Xss.filter(value);
    }

    @Override
    public String[] getParameterValues(String name)
    {
        String[] values = super.getParameterValues(name);
        if(!Lang.isEmpty(values))
        {
            for(int i=0;i<values.length;i++)
            {
                values[i] = Xss.filter(values[i]);
            }
        }
        return values;
    }

    @Override
    public Map<String, String[]> getParameterMap()
    {
        Map<String, String[]> valueMap = super.getParameterMap();
        if(!Lang.isEmpty(valueMap))
        {
            for (String key : valueMap.keySet())
            {
                String[] values = valueMap.get(key);
                for(int i=0;i<values.length;i++)
                {
                    values[i] = Xss.filter(values[i]);
                }
            }
        }
        return valueMap;
    }

    @Override
    public String getHeader(String name)
    {
        String header = super.getHeader(name);
        return Xss.filter(header);
    }
}

class Xss{
    private static final Log logger = Logs.getLog(Xss.class);
    private static final String SQL_XSS = "";
    private static final String REGEX_SQL = "select|update|and|or|delete|insert|trancate|char|chr|into|substr|ascii|declare|exec|count|master|drop|execute";
    private static final String REGEX_XSS = "script|iframe";
    public static String filter(String value)
    {
        if(!checkValue(value))
        {
            //TODO ..
        }
        return "";
    }

    private static boolean checkValue(String value)
    {
//TODO ..
        return false;
    }
}