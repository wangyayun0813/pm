package com.yling.modules.service;

import com.yling.common.base.BaseService;
import com.yling.modules.models.SysLog;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
@IocBean(args = {"refer:dao"})
public class SysLogService extends BaseService<SysLog>
{
    public SysLogService(Dao dao)
    {
        super(dao);
    }

    public void save(Long userId,String nick,String tag,String obj,String info,Short opResult)
    {
        SysLog sysLog = SysLog.c(userId,nick,tag,obj,info,opResult);
        insert(sysLog);
    }
}
