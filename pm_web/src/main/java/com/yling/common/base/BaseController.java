package com.yling.common.base;

import com.yling.modules.service.MenuService;
import com.yling.modules.service.SysLogService;
import com.yling.modules.service.UserService;
import org.nutz.ioc.loader.annotation.Inject;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/16.
 * 修改人：
 */
public class BaseController
{
    @Inject
    protected UserService userService;
    @Inject
    protected SysLogService sysLogService;
    @Inject
    protected MenuService menuService;
}
