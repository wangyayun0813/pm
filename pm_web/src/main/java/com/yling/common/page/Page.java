package com.yling.common.page;

import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/13.
 * 修改人：
 */
public class Page extends SimplePage
{
    private List<?> list;
    public Page(int pageNo, int pageSize, int totalSize,List<?> list)
    {
        super(pageNo, pageSize, totalSize);
        this.list = list;
    }

    public Page(int pageNo, int pageSize, int totalSize)
    {
        super(pageNo, pageSize, totalSize);
    }

    public Page(int pageNo, int totalSize,List<?> list)
    {
        super(pageNo, SimplePage.DEFAULT_PAGE_SIZE, totalSize);
        this.list = list;
    }

    public List<?> getList()
    {
        return list;
    }

    public void setList(List<?> list)
    {
        this.list = list;
    }
}
