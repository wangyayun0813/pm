package com.yling.modules.models;

import com.yling.common.base.Model;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/9.
 * 修改人：
 */
@Table("pm_sys_log")
public class SysLog extends Model implements Serializable
{
    private static final long serialVersionUID = -2807184700002187277L;
    @Id
    private	Long id;
    @Column("user_id")
    private	Long userId;
    @Column
    private	String nick;
    @Column
    private	String tag;
    @Column("op_obj")
    private	String opObj;
    @Column("op_info")
    private	String opInfo;
    @Column("op_result")
    private	Short opResult;
    @Column("create_time")
    private Timestamp createTime;

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

    public String getNick()
    {
        return nick;
    }

    public void setNick(String nick)
    {
        this.nick = nick;
    }

    public String getTag()
    {
        return tag;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public String getOpObj()
    {
        return opObj;
    }

    public void setOpObj(String opObj)
    {
        this.opObj = opObj;
    }

    public String getOpInfo()
    {
        return opInfo;
    }

    public void setOpInfo(String opInfo)
    {
        this.opInfo = opInfo;
    }

    public Short getOpResult()
    {
        return opResult;
    }

    public void setOpResult(Short opResult)
    {
        this.opResult = opResult;
    }

    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime)
    {
        this.createTime = createTime;
    }
}
