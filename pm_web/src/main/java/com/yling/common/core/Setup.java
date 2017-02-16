package com.yling.common.core;

import com.yling.common.util.StringUtil;
import com.yling.modules.models.User;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/9.
 * 修改人：
 */
public class Setup implements org.nutz.mvc.Setup
{
    @Override
    public void init(NutConfig conf)
    {
        Ioc ioc = conf.getIoc();
        Dao dao = ioc.get(Dao.class);
        initData(dao);
    }

    private void initData(Dao dao)
    {
        Daos.createTablesInPackage(dao, "com.yling.modules.models", false);
        if(dao.count(User.class)<=1)
        {
            User user = new User();
            user.setName("administrator");
            user.setNick("admin");
            user.setLoginName("admin");
            user.setLoginPassword(StringUtil.getPassword("123456"));
            dao.insert(user);
        }
    }

    @Override
    public void destroy(NutConfig nutConfig)
    {
        //TODO destroy
    }
}
