package com.yling.modules.service;

import com.yling.common.base.BaseService;
import com.yling.modules.models.Role;
import com.yling.modules.models.User;
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
public class UserService extends BaseService<User>
{
    public UserService(Dao dao)
    {
        super(dao);
    }

    public List<String> getRoleNames(User user)
    {
        dao().fetchLinks(user,"roles");
        List<Role> roles = user.getRoles();
        List<String> rl = new ArrayList<>();
        for (Role r:roles)
        {
            rl.add(r.getName());
        }
        return rl;
    }
}
