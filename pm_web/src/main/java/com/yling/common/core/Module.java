package com.yling.common.core;

import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * 文件名：
 * 描述：主配置
 * 创建人： wangyayun
 * 创建时间： 2017/2/9.
 * 修改人：
 */
@Modules(scanPackage = true, packages = "com.yling.modules")
@IocBy(type=ComboIocProvider.class, args={
        "*js", "conf/ioc/",
        "*anno", "com.yling",
        "*tx",
        "*async"})
@SetupBy(Setup.class)
public class Module
{
}
