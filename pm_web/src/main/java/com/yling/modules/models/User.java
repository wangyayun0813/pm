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
@Table("pm_user")
@TableIndexes({
        @Index(name = "E_ID",fields = {"eId"}, unique = false),
        @Index(name = "LOGIN_NAME",fields = {"loginName"}),
        @Index(name = "UPDATE_TIME",fields = {"updateTime"}, unique = false),
        @Index(name = "NICK",fields = {"nick"})
})
public class User extends Model implements Serializable
{
    private static final long serialVersionUID = -1821847457410405720L;
    @Id
    private	Long id;
    @Column("e_id")
    @Comment("员工工号")
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
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
    @ColDefine(type = ColType.VARCHAR,width = 32,notNull = true)
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
}
