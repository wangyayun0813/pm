package com.yling.common.core;

import org.beetl.ext.nutz.BeetlViewMaker;
import org.nutz.integration.shiro.ShiroSessionProvider;
import org.nutz.mvc.annotation.*;
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
@ChainBy(args = {"conf/custom/chain.js"})
@SetupBy(Setup.class)
@Views(BeetlViewMaker.class)
@Ok("json:full")
@Fail("http:500")
@Encoding(input = "UTF-8", output = "UTF-8")
@SessionBy(ShiroSessionProvider.class)
public class Module
{
}
