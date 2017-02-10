/**
 * Created by wangyayun on 2017/2/9.
 */
var ioc = {
    conf: {
        type: "org.nutz.ioc.impl.PropertiesProxy",
        fields: {
            paths: ["conf/custom/"]
        }
    },
    dataSource: {
        factory: "$conf#make",
        type: "com.alibaba.druid.pool.DruidDataSource",
        events: {
            create: "init",
            depose: 'close'
        },
        args: ["com.alibaba.druid.pool.DruidDataSource", "db."]
    },
    dao: {
        type: "org.nutz.dao.impl.NutDao",
        args: [{refer: "dataSource"}]
    }
};