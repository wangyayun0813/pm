package com.yling.common.base;

import com.yling.common.util.DateUtil;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 文件名：
 * 描述：
 * 创建人： wangyayun
 * 创建时间： 2017/2/9.
 * 修改人：
 */
public class BaseModel implements Serializable
{
    private static final long serialVersionUID = -2056424678433135268L;

    public String toString() {
        return String.format("/*%s*/%s", super.toString(), Json.toJson(this, JsonFormat.compact()));
    }

    public Timestamp now()
    {
        return DateUtil.timestamp();
    }
}
