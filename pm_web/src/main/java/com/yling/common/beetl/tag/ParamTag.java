package com.yling.common.beetl.tag;

import com.yling.common.util.DateUtil;
import org.beetl.core.Tag;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/20.
 * 修改人：
 */
public class ParamTag extends Tag
{
    private String key;
    private String value;
    @Override
    public void render()
    {
        _init();
        HttpServletRequest request = (HttpServletRequest) ctx.getGlobal("request");
        TagContent tc = (TagContent) request.getAttribute("tagContent");
        if(tc!=null)
        {
            TagContent child = new TagContent();
            child.setTag(this);
            child.setParent(tc.getTag());
            tc.append(child);
        }
    }

    private void _init()
    {
        Map<String,Object> argsMap = (Map<String, Object>) args[1];
        this.key = (String) argsMap.get("name");
        Object val = argsMap.get("value");
        if(val instanceof Date)
        {
            this.value = DateUtil.formatDate((Date) val);
        }else this.value = (String) val;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
