/**
 * Created by wangyayun on 2017/2/14.
 */
var chain = {
    "default": {
        "ps": [
            "com.yling.common.processor.XssFilterProcessor",
            "org.nutz.mvc.impl.processor.UpdateRequestAttributesProcessor",
            "org.nutz.mvc.impl.processor.EncodingProcessor",
            "org.nutz.mvc.impl.processor.ModuleProcessor",
            "org.nutz.mvc.impl.processor.ActionFiltersProcessor",
            "com.yling.common.processor.NutShiroProcessor",
            "com.yling.common.processor.LogTimeProcessor",
            "org.nutz.mvc.impl.processor.AdaptorProcessor",
            "org.nutz.mvc.impl.processor.MethodInvokeProcessor",
            "org.nutz.mvc.impl.processor.ViewProcessor"
        ],
        "error": 'com.yling.common.processor.FailProcessor'
    }
};