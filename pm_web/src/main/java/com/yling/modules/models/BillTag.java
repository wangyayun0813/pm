package com.yling.modules.models;

import com.yling.common.base.BaseModel;
import org.nutz.dao.entity.annotation.*;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/9.
 * 修改人：
 */
@Table("pm_tag")
@TableIndexes({@Index(name = "NAME",fields = {"name"}),
               @Index(name = "COLOR",fields = {"color"})})
public class BillTag extends BaseModel implements Serializable
{
    private static final long serialVersionUID = 8330418045420801112L;
    @Id
    private Long id;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    private String name;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    private String color;
    @Column("create_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private Timestamp createTime;
    @Column("update_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private Timestamp updateTime;

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

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
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
}
