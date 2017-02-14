package com.yling.common.annotation;

import java.lang.annotation.*;

/**
 * 文件名：
 * 描述：${DESCRIPTION}
 * 创建人： wangyayun
 * 创建时间： 2017/2/14.
 * 修改人：
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SLog
{
    String tag();

    String obj();
}
