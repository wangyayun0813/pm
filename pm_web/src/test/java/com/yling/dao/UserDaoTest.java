package com.yling.dao;

import com.yling.common.util.DateUtil;
import com.yling.modules.models.BillTag;
import com.yling.modules.models.Menu;
import com.yling.modules.models.Role;
import com.yling.modules.service.MenuService;
import com.yling.runner.NutzTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/10.
 * 修改人：
 */
@RunWith(NutzTestRunner.class)
@IocBean
public class UserDaoTest
{
    @Inject("refer:$ioc")
    protected Ioc ioc;
    @Inject
    protected Dao dao;
    @Inject
    protected MenuService menuService;

    @Test
    public void doSave2()
    {
        BillTag tag = new BillTag();
        tag.setColor("#DWE");
        tag.setName("入账3");
        tag.setCreateTime(DateUtil.timestamp());
        tag.setUpdateTime(DateUtil.timestamp());
        dao.insert(tag);
        System.out.println(tag.getId());
    }

    @Test
    public void testClear()
    {
        List<BillTag> query = dao.query(BillTag.class, Cnd.where("color", "like", "%DW%"));
        System.out.println(query);
    }

    @Test
    public void testSaveRoleAndMenu()
    {
        Menu m1 = new Menu();
        m1.setName("m1");
        m1.setType((short) 1);
        m1.setCreator((long) 1);
        m1.setPermission("xxx1");
        m1.setCreateTime(Timestamp.valueOf("2016-02-14 11:11:11"));

        Menu m2 = new Menu();
        m2.setName("m2");
        m2.setType((short) 1);
        m2.setCreator((long) 1);
        m2.setPermission("xxx2");
        m2.setCreateTime(Timestamp.valueOf("2016-02-14 11:11:11"));

        Menu m3 = new Menu();
        m3.setName("m3");
        m3.setType((short) 1);
        m3.setCreator((long) 1);
        m3.setPermission("xxx3");
        m3.setCreateTime(Timestamp.valueOf("2016-02-14 11:11:11"));

        Role role = new Role();
        role.setName("项目经理");
        role.setCreateBy(1l);
        role.setOpBy(1l);

        List<Menu> menuList = new ArrayList<>();
        menuList.add(m1);
        menuList.add(m2);
        menuList.add(m3);
        role.setMenus(menuList);

        dao.insertWith(role,"menus");
    }

    @Test
    public void testQueryMenu()
    {
        Role role = dao.fetch(Role.class, 13l);
        dao.fetchLinks(role, "menus");
        System.out.println(role.getMenus());
        dao.deleteWith(role, "menus");
    }


    @Test
    public void testCreateTables()
    {
        Daos.createTablesInPackage(dao, "com.yling.modules.models", false);
    }

    @Test
    public void testQuery()
    {
        // Page page = service.listPage(0, 0);
        // System.out.println(page);
        System.out.println(menuService.listPage(3,10,Cnd.where("type","=",1)));
    }

    @Test
    public void testUI()
    {
        // Dao dao = Mvcs.getIoc().get(Dao.class);
        Sql sql = Sqls.create("select concat('PME_',lpad(max(id)+1,5,0)) from pm_user order by id desc limit 1");
        sql.setCallback(new SqlCallback()
        {
            @Override
            public Object invoke(Connection conn, ResultSet rs, Sql sql) throws SQLException
            {
                if(rs!=null && rs.next())
                {
                    return rs.getString(1);
                }
                return "PME_00001";
            }
        });
        dao.execute(sql);
        System.out.println(sql.getString());
    }
}
