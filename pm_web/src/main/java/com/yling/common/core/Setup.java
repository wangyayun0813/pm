package com.yling.common.core;

import com.yling.common.base.SiteContants;
import com.yling.common.util.StringUtil;
import com.yling.modules.models.Menu;
import com.yling.modules.models.User;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;

import java.util.ArrayList;
import java.util.List;

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
        if(dao.count(User.class)<=0)
        {
            User user = new User();
            user.setName("administrator");
            user.setNick("admin");
            user.setLoginName("admin");
            user.setLoginPassword(StringUtil.getPassword("123456"));
            dao.insert(user);
            List<Menu> menus = new ArrayList<>();
            Menu m1 = new Menu();
            m1.setName("首页");
            m1.setPermission("sys.home");
            m1.setType(SiteContants.MENU_TYPE_PAGE);
            m1.setDisabled(SiteContants.FLAG_YES);
            m1.setHref("/sys/home");

            Menu m2 = new Menu();
            m2.setName("用户管理");
            m2.setPermission("user");
            m2.setType(SiteContants.MENU_TYPE_PAGE);
            m2.setDisabled(SiteContants.FLAG_YES);
            m2.setHref("/user");

            Menu m3 = new Menu();
            m3.setName("工资管理");
            m3.setPermission("salary");
            m3.setType(SiteContants.MENU_TYPE_PAGE);
            m3.setDisabled(SiteContants.FLAG_YES);
            m3.setHref("/salary");

            Menu m4 = new Menu();
            m4.setName("账单管理");
            m4.setPermission("bill");
            m4.setType(SiteContants.MENU_TYPE_PAGE);
            m4.setDisabled(SiteContants.FLAG_YES);
            m4.setHref("/bill");

            dao.insert(m1);
            dao.insert(m2);
            dao.insert(m3);
            dao.insert(m4);

            Menu m21 = new Menu();
            m21.setName("用户创建");
            m21.setHref("/user/add");
            m21.setPermission("user.add");
            m21.setType(SiteContants.MENU_TYPE_OPERATION);
            m21.setDisabled(SiteContants.FLAG_YES);
            m21.setPid(m2.getId());

            Menu m22 = new Menu();
            m22.setName("用户删除");
            m22.setHref("/user/delete");
            m22.setPermission("user.delete");
            m22.setType(SiteContants.MENU_TYPE_OPERATION);
            m22.setDisabled(SiteContants.FLAG_YES);
            m22.setPid(m2.getId());

            Menu m23 = new Menu();
            m23.setName("用户修改");
            m23.setHref("/user/edit");
            m23.setPermission("user.edit");
            m23.setType(SiteContants.MENU_TYPE_OPERATION);
            m23.setDisabled(SiteContants.FLAG_YES);
            m23.setPid(m2.getId());

            Menu m24 = new Menu();
            m24.setName("角色修改");
            m24.setHref("/user/role/edit");
            m24.setPermission("user.role.edit");
            m24.setType(SiteContants.MENU_TYPE_OPERATION);
            m24.setDisabled(SiteContants.FLAG_YES);
            m24.setPid(m2.getId());

            Menu m25 = new Menu();
            m25.setName("角色管理");
            m25.setHref("/role");
            m25.setPermission("role");
            m25.setType(SiteContants.MENU_TYPE_PAGE);
            m25.setDisabled(SiteContants.FLAG_YES);
            m25.setPid(m2.getId());

            Menu m26 = new Menu();
            m26.setName("部门管理");
            m26.setHref("/dept");
            m26.setPermission("dept");
            m26.setType(SiteContants.MENU_TYPE_PAGE);
            m26.setDisabled(SiteContants.FLAG_YES);
            m26.setPid(m2.getId());

            dao.insert(m21);
            dao.insert(m22);
            dao.insert(m23);
            dao.insert(m24);
            dao.insert(m25);
            dao.insert(m26);

            Menu m31 = new Menu();
            m31.setName("工资设置");
            m31.setHref("/salary/edit");
            m31.setPermission("salary.edit");
            m31.setType(SiteContants.MENU_TYPE_OPERATION);
            m31.setDisabled(SiteContants.FLAG_YES);
            m31.setPid(m3.getId());

            Menu m32 = new Menu();
            m32.setName("工资详情");
            m32.setHref("/salary/info");
            m32.setPermission("salary.info");
            m32.setType(SiteContants.MENU_TYPE_OPERATION);
            m32.setDisabled(SiteContants.FLAG_YES);
            m32.setPid(m3.getId());

            Menu m33 = new Menu();
            m33.setName("工时管理");
            m33.setHref("/wh");
            m33.setPermission("wh");
            m33.setType(SiteContants.MENU_TYPE_PAGE);
            m33.setDisabled(SiteContants.FLAG_YES);
            m33.setPid(m3.getId());
            dao.insert(m31);
            dao.insert(m32);
            dao.insert(m33);

            Menu m41 = new Menu();
            m41.setName("标签管理");
            m41.setHref("/tag");
            m41.setPermission("tag");
            m41.setType(SiteContants.MENU_TYPE_PAGE);
            m41.setDisabled(SiteContants.FLAG_YES);
            m41.setPid(m4.getId());

            Menu m42 = new Menu();
            m42.setName("账单创建");
            m42.setHref("/bill/add");
            m42.setPermission("bill.add");
            m42.setType(SiteContants.MENU_TYPE_OPERATION);
            m42.setDisabled(SiteContants.FLAG_YES);
            m42.setPid(m4.getId());

            Menu m43 = new Menu();
            m43.setName("账单删除");
            m43.setHref("/bill/delete");
            m43.setPermission("bill.delete");
            m43.setType(SiteContants.MENU_TYPE_OPERATION);
            m43.setDisabled(SiteContants.FLAG_YES);
            m43.setPid(m4.getId());

            Menu m44 = new Menu();
            m44.setName("账单修改");
            m44.setHref("/bill/edit");
            m44.setPermission("bill.edit");
            m44.setType(SiteContants.MENU_TYPE_OPERATION);
            m44.setDisabled(SiteContants.FLAG_YES);
            m44.setPid(m4.getId());

            Menu m45 = new Menu();
            m45.setName("出账");
            m45.setHref("/bill/sum");
            m45.setPermission("bill.sum");
            m45.setType(SiteContants.MENU_TYPE_OPERATION);
            m45.setDisabled(SiteContants.FLAG_YES);
            m45.setPid(m4.getId());

            dao.insert(m41);
            dao.insert(m42);
            dao.insert(m43);
            dao.insert(m44);
            dao.insert(m45);

            Menu m251 = new Menu();
            m251.setName("角色创建");
            m251.setHref("/role/add");
            m251.setPermission("role.add");
            m251.setType(SiteContants.MENU_TYPE_OPERATION);
            m251.setDisabled(SiteContants.FLAG_YES);
            m251.setPid(m25.getId());

            Menu m252 = new Menu();
            m252.setName("角色删除");
            m252.setHref("/role/delete");
            m252.setPermission("role.delete");
            m252.setType(SiteContants.MENU_TYPE_OPERATION);
            m252.setDisabled(SiteContants.FLAG_YES);
            m252.setPid(m25.getId());

            Menu m253 = new Menu();
            m253.setName("角色修改");
            m253.setHref("/role/edit");
            m253.setPermission("role.edit");
            m253.setType(SiteContants.MENU_TYPE_OPERATION);
            m253.setDisabled(SiteContants.FLAG_YES);
            m253.setPid(m25.getId());

            Menu m254 = new Menu();
            m254.setName("权限修改");
            m254.setHref("/role/permission/edit");
            m254.setPermission("role.permission.edit");
            m254.setType(SiteContants.MENU_TYPE_OPERATION);
            m254.setDisabled(SiteContants.FLAG_YES);
            m254.setPid(m25.getId());

            dao.insert(m251);
            dao.insert(m252);
            dao.insert(m253);
            dao.insert(m254);

            Menu m261 = new Menu();
            m261.setName("部门创建");
            m261.setHref("/dept/add");
            m261.setPermission("dept.add");
            m261.setType(SiteContants.MENU_TYPE_OPERATION);
            m261.setDisabled(SiteContants.FLAG_YES);
            m261.setPid(m26.getId());

            Menu m262 = new Menu();
            m262.setName("部门删除");
            m262.setHref("/dept/delete");
            m262.setPermission("dept.delete");
            m262.setType(SiteContants.MENU_TYPE_OPERATION);
            m262.setDisabled(SiteContants.FLAG_YES);
            m262.setPid(m26.getId());

            Menu m263 = new Menu();
            m263.setName("部门修改");
            m263.setHref("/dept/edit");
            m263.setPermission("dept.edit");
            m263.setType(SiteContants.MENU_TYPE_OPERATION);
            m263.setDisabled(SiteContants.FLAG_YES);
            m263.setPid(m26.getId());

            dao.insert(m261);
            dao.insert(m262);
            dao.insert(m263);

            Menu m331 = new Menu();
            m331.setName("工时新增");
            m331.setHref("/wh/add");
            m331.setPermission("wh.add");
            m331.setType(SiteContants.MENU_TYPE_OPERATION);
            m331.setDisabled(SiteContants.FLAG_YES);
            m331.setPid(m33.getId());

            Menu m332 = new Menu();
            m332.setName("工时删除");
            m332.setHref("/wh/delete");
            m332.setPermission("wh.delete");
            m332.setType(SiteContants.MENU_TYPE_OPERATION);
            m332.setDisabled(SiteContants.FLAG_YES);
            m332.setPid(m33.getId());

            Menu m333 = new Menu();
            m333.setName("工时详情");
            m333.setHref("/wh/info");
            m333.setPermission("wh.info");
            m333.setType(SiteContants.MENU_TYPE_OPERATION);
            m333.setDisabled(SiteContants.FLAG_YES);
            m333.setPid(m33.getId());
            dao.insert(m331);
            dao.insert(m332);
            dao.insert(m333);

            Menu m411 = new Menu();
            m411.setName("标签创建");
            m411.setHref("/tag/add");
            m411.setPermission("tag.add");
            m411.setType(SiteContants.MENU_TYPE_OPERATION);
            m251.setDisabled(SiteContants.FLAG_YES);
            m251.setPid(m41.getId());

            Menu m412 = new Menu();
            m412.setName("标签删除");
            m412.setHref("/tag/delete");
            m412.setPermission("tag.delete");
            m412.setType(SiteContants.MENU_TYPE_OPERATION);
            m412.setDisabled(SiteContants.FLAG_YES);
            m412.setPid(m41.getId());

            Menu m413 = new Menu();
            m413.setName("标签修改");
            m413.setHref("/tag/edit");
            m413.setPermission("tag.edit");
            m413.setDisabled(SiteContants.FLAG_YES);
            m413.setPid(m41.getId());
            m413.setType(SiteContants.MENU_TYPE_OPERATION);

            dao.insert(m411);
            dao.insert(m412);
            dao.insert(m413);
        }
    }

    @Override
    public void destroy(NutConfig nutConfig)
    {
        //TODO destroy
    }
}
