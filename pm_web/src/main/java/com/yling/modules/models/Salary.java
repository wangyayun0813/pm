package com.yling.modules.models;

import com.yling.common.base.Model;
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
@Table("pm_salary")
@TableIndexes({@Index(name = "USER_ID",fields = {"userId"}, unique = false),
               @Index(name = "UPDATE_TIME",fields = {"updateTime"}, unique = false)})
public class Salary extends Model implements Serializable
{
    private static final long serialVersionUID = -1014503222202974203L;
    @Id
    private Long id;
    @Column("user_id")
    @ColDefine(notNull = true)
    private Long userId;
    @Column
    @ColDefine(notNull = true)
    private Double num;
    @Column("salary_type")
    private Short salaryType;
    @Column
    private Short type;
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

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Double getNum()
    {
        return num;
    }

    public void setNum(Double num)
    {
        this.num = num;
    }

    public Short getSalaryType()
    {
        return salaryType;
    }

    public void setSalaryType(Short salaryType)
    {
        this.salaryType = salaryType;
    }

    public Short getType()
    {
        return type;
    }

    public void setType(Short type)
    {
        this.type = type;
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
