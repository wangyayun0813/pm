package com.yling.modules.service;

import com.yling.common.base.BaseService;
import com.yling.modules.models.Menu;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/13.
 * 修改人：
 */
@IocBean(args = {"refer:dao"})
public class MenuService extends BaseService<Menu>
{
    public MenuService(Dao dao)
    {
        super(dao);
    }
}
