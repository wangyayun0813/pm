package com.yling.common.processor;

import org.apache.commons.lang3.StringUtils;
import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.impl.processor.AbstractProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        ac.setRequest(new XssRequestWrapper(ac.getRequest()));
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

    private static final Pattern SQL_XSS = Pattern.compile("(select|update|and|or|delete|insert|trancate|char|chr|into|substr|ascii|declare|exec|count|master|drop|execute)+",Pattern.CASE_INSENSITIVE |Pattern.MULTILINE | Pattern.DOTALL);

    private static List<Pattern> getXssPatternList() {
        List<Pattern> ret = new ArrayList<Pattern>();
        ret.add(Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE));
        ret.add(Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        ret.add(Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        ret.add(Pattern.compile("(javascript:|vbscript:|view-source:)*", Pattern.CASE_INSENSITIVE));
        ret.add(Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        ret.add(Pattern.compile("(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        ret.add(Pattern.compile("<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        return ret;
    }

    public static String filter(String value)
    {
        value = stripXss(value);
        value = stripSql(value);
        return value;
    }

    private static String stripXss(String value) {
        if(StringUtils.isNotBlank(value)) {
            Matcher matcher = null;
            for(Pattern pattern : getXssPatternList()) {
                matcher = pattern.matcher(value);
                // 匹配
                if(matcher.find()) {
                    logger.debug("XSS过滤："+value +"， 规则："+ pattern.toString());
                    // 删除相关字符串
                    value = matcher.replaceAll("");
                }
            }
            value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        }
        return value;
    }

    private static String stripSql(String value)
    {
        if(StringUtils.isNotBlank(value))
        {
            Matcher matcher = SQL_XSS.matcher(value);
            if(matcher.find())
            {
                value = value.replaceAll("\\'","\\\\'").replaceAll("\\\"","\\\\\"");
                if(!value.contains("\\\\'") || !value.contains("\\\\\""))
                    value = "\\\'" + value + "\\\'";
                logger.debug("SQL过滤:"+value);
            }
        }
        return value;
    }

    public static void main(String[] args)
    {
        System.out.println(filter("select * from cpc_user"));
    }

}