package com.yling.common.beetl.tag;

import org.beetl.core.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/20.
 * 修改人：
 */
public class TagContent
{
    private Tag tag;
    private Tag parent;
    private List<TagContent> childs;

    public Tag getTag()
    {
        return tag;
    }

    public void setTag(Tag tag)
    {
        this.tag = tag;
    }

    public Tag getParent()
    {
        return parent;
    }

    public void setParent(Tag parent)
    {
        this.parent = parent;
    }

    public List<TagContent> getChilds()
    {
        return childs;
    }

    public void setChilds(List<TagContent> childs)
    {
        this.childs = childs;
    }

    public void append(TagContent child)
    {
        if(null == childs)
            childs = new ArrayList<>();
        childs.add(child);
    }
}
