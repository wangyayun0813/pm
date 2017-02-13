package com.yling.modules.models;

import com.yling.common.base.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/9.
 * 修改人：
 */
@Table("pm_role")
public class Role extends BaseModel implements Serializable
{
    private static final long serialVersionUID = 7480962304794481629L;
    @Id
    private Long id;
    @Column
    @ColDefine(width = 50,notNull = true)
    private String name;
    @Column
    private Short disabled;
    @Column("create_by")
    private Long createBy;
    @Column("op_by")
    private Long opBy;
    @Column("create_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private Timestamp createTime;
    @Column("update_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private Timestamp updateTime;
    @ManyMany(relation = "pm_role_menu",from = "role_id",to = "menu_id")
    private List<Menu> menus;
    @ManyMany(relation = "pm_user_role",from = "role_id", to = "user_id")
    private List<User> users;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Short getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Short disabled)
    {
        this.disabled = disabled;
    }

    public Long getCreateBy()
    {
        return createBy;
    }

    public void setCreateBy(Long createBy)
    {
        this.createBy = createBy;
    }

    public Long getOpBy()
    {
        return opBy;
    }

    public void setOpBy(Long opBy)
    {
        this.opBy = opBy;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime)
    {
        this.updateTime = updateTime;
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(List<Menu> menus)
    {
        this.menus = menus;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}
