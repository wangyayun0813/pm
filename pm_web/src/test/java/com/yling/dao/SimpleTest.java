package com.yling.dao;

import org.junit.Test;
import org.nutz.dao.Cnd;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/13.
 * 修改人：
 */
public class SimpleTest
{
    private static final Log log = Logs.getLog(SimpleTest.class);
    @Test
    public void testCnd()
    {
        log.debug("xxxxx");
        log.error("this is a error!");
    }

    @Test
    public void testSimplePage()
    {
        Cnd aNew = Cnd.NEW();
        System.out.println(aNew.toString());
    }
}
