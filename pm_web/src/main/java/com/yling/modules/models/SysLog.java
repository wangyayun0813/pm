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
@Table("pm_sys_log")
public class SysLog extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -2807184700002187277L;
    @Id
    private	Long id;
    @Column("user_id")
    @ColDefine(notNull = true)
    private	Long userId;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private	String nick;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    private	String tag;
    @Column("op_obj")
    @ColDefine(type = ColType.VARCHAR,width = 255,notNull = true)
    private	String opObj;
    @Column("op_info")
    @ColDefine(type = ColType.TEXT,notNull = true)
    private	String opInfo;
    @Column("op_result")
    private	Short opResult;
    @Column("create_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
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
