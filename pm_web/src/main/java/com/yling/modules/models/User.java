package com.yling.modules.models;

import com.yling.common.base.BaseModel;
import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.nutz.mvc.Mvcs;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/9.
 * 修改人：
 */
@Table("pm_user")
@TableIndexes({
        @Index(name = "E_ID",fields = {"eId"}, unique = false),
        @Index(name = "LOGIN_NAME",fields = {"loginName"}),
        @Index(name = "UPDATE_TIME",fields = {"updateTime"}, unique = false),
        @Index(name = "NICK",fields = {"nick"})
})
public class User extends BaseModel implements Serializable
{
    private static final long serialVersionUID = -1821847457410405720L;
    @Id
    private	Long id;
    @Column("e_id")
    @Comment("员工工号")
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    @Prev(els = @EL("$me.genEID()"))
    private	String eId;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    private	String name;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    private	String nick;
    @Column
    private	Integer age;
    @Column
    private	Integer sex;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 12)
    private	String birthday;
    @Column("login_name")
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
    private	String loginName;
    @Column("login_password")
    @ColDefine(type = ColType.VARCHAR,width = 100,notNull = true)
    private	String loginPassword;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private	String email;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 12)
    private	String qq;
    @Column("phone_num")
    @ColDefine(type = ColType.VARCHAR,width = 12)
    private	String phoneNum;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 200)
    private	String addr;
    @Column
    @ColDefine(type = ColType.VARCHAR,width = 200)
    private	String description;
    @Column("login_num")
    private	Integer loginNum;
    @Column("last_ip")
    @ColDefine(type = ColType.VARCHAR,width = 32)
    private	String lastIp;
    @Column("last_time")
    private Timestamp lastTime;
    @Column("create_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private	Timestamp createTime;
    @Column("update_time")
    @Prev(els = @EL("$me.now()"))
    @ColDefine(type = ColType.DATETIME,notNull = true)
    private	Timestamp updateTime;
    @ManyMany(relation = "pm_user_role", from = "user_id", to = "role_id")
    private List<Role> roles;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String geteId()
    {
        return eId;
    }

    public void seteId(String eId)
    {
        this.eId = eId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNick()
    {
        return nick;
    }

    public void setNick(String nick)
    {
        this.nick = nick;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Integer getSex()
    {
        return sex;
    }

    public void setSex(Integer sex)
    {
        this.sex = sex;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getLoginName()
    {
        return loginName;
    }

    public void setLoginName(String loginName)
    {
        this.loginName = loginName;
    }

    public String getLoginPassword()
    {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword)
    {
        this.loginPassword = loginPassword;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getQq()
    {
        return qq;
    }

    public void setQq(String qq)
    {
        this.qq = qq;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }

    public String getAddr()
    {
        return addr;
    }

    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getLoginNum()
    {
        return loginNum;
    }

    public void setLoginNum(Integer loginNum)
    {
        this.loginNum = loginNum;
    }

    public String getLastIp()
    {
        return lastIp;
    }

    public void setLastIp(String lastIp)
    {
        this.lastIp = lastIp;
    }

    public Timestamp getLastTime()
    {
        return lastTime;
    }

    public void setLastTime(Timestamp lastTime)
    {
        this.lastTime = lastTime;
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

    public String genEID()
    {
        Dao dao = Mvcs.getIoc().get(Dao.class);
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
                return "";
            }
        });
        dao.execute(sql);
        String id = sql.getString();
        return StringUtils.isEmpty(id)?"PME_00001":id;
    }
}
