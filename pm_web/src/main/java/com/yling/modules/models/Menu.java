package com.yling.modules.models;

import com.yling.common.base.Model;
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
@Table("pm_menu")
@TableIndexes({@Index(name = "CREATE_TIME",fields = {"createTime"},unique = false),
               @Index(name = "UPDATE_TIME",fields = {"updateTime"},unique = false),
               @Index(name = "PID_TYPE",fields = {"pid","type"},unique = false),
               @Index(name = "permission",fields = "permission")})
public class Menu extends Model implements Serializable
{
    private static final long serialVersionUID = -292696415871052369L;
    @Id
    private Long id;
    @Column
    private Long pid;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 50,notNull = true)
    private String name;
    @Column
    @ColDefine(notNull = true)
    private Short type;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 255)
    private String href;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String icon;
    @Column
    private Short disabled;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    private String permission;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private String target;
    @Column
    private Long creator;
    @Column("create_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private Timestamp createTime;
    @Column("update_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private Timestamp updateTime;
    @ManyMany(relation = "pm_role_menu", from = "menu_id", to = "role_id")
    private List<Role> roles;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getPid()
    {
        return pid;
    }

    public void setPid(Long pid)
    {
        this.pid = pid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Short getType()
    {
        return type;
    }

    public void setType(Short type)
    {
        this.type = type;
    }

    public String getHref()
    {
        return href;
    }

    public void setHref(String href)
    {
        this.href = href;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public Short getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Short disabled)
    {
        this.disabled = disabled;
    }

    public String getPermission()
    {
        return permission;
    }

    public void setPermission(String permission)
    {
        this.permission = permission;
    }

    public String getTarget()
    {
        return target;
    }

    public void setTarget(String target)
    {
        this.target = target;
    }

    public Long getCreator()
    {
        return creator;
    }

    public void setCreator(Long creator)
    {
        this.creator = creator;
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

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }
}
