package com.yling.common.base;

import com.yling.common.page.Page;
import com.yling.common.page.SimplePage;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.service.EntityService;

import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/13.
 * 修改人：
 */
public class BaseService<T> extends EntityService<T>
{
    public BaseService()
    {
        super();
    }

    public BaseService(Dao dao)
    {
        super(dao);
    }

    public T fetch(long id)
    {
        return this.dao().fetch(getEntityClass(),id);
    }

    public int count(String tableName, Condition cnd)
    {
        return this.dao().count(tableName, cnd);
    }

    public Page listPage(int pageNo, int pageSize, Condition cnd)
    {
        if(pageSize<=0)
            pageSize = SimplePage.DEFAULT_PAGE_SIZE;
        if(pageNo<=0)
            pageNo = 1;
        int totalSize = count(cnd);
        Page page = new Page(pageNo, pageSize, totalSize);
        Pager pager = this.dao().createPager(page.getPageNo(), page.getPageSize());
        List<T> list = this.dao().query(getEntityClass(), cnd, pager);
        page.setList(list);
        return page;
    }

    public Page listPage(int pageNo,int pageSize)
    {
        return listPage(pageNo,pageSize, null);
    }

}
