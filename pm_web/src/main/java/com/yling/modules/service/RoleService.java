package com.yling.modules.service;

import com.yling.common.base.BaseService;
import com.yling.modules.models.Menu;
import com.yling.modules.models.Role;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/13.
 * 修改人：
 */
@IocBean(args = {"refer:dao"})
public class RoleService extends BaseService<Role>
{
    public RoleService(Dao dao)
    {
        super(dao);
    }

    public List<String> getPermissionNameList(Role role)
    {
        dao().fetchLinks(role,"menus");
        List<String> pl = new ArrayList<>();
        for (Menu m:role.getMenus())
        {
            pl.add(m.getPermission());
        }
        return pl;
    }
}
