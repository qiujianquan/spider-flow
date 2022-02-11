package org.spiderflow.core.executor.function;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.spiderflow.annotation.Comment;
import org.spiderflow.annotation.Example;
import org.spiderflow.core.utils.MD5Util;
import org.spiderflow.executor.FunctionExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 参数覆盖
 */
@Component
public class ParamCoverExecutor implements FunctionExecutor {

    @Comment("根据字符串位置返回ASCII根据数组传输下标进行累加")
    @Example("${paramOne.number(str，str,int,int)}")
    public static Integer number(String v_key, String guid, Integer pageNum, Integer pageSize) {
        String str = v_key + guid + pageNum + "." + pageSize;
        String s = MD5Util.md5Lower(str);
        int i = s.charAt(5) + s.charAt(7) + s.charAt(9);
        System.out.println(i);
        return i;
    }



    @Comment("参数前增加一个变量后进行非空判断")
    @Example("${paramOne.isNotEmpty(str)}")
    public static Boolean isNotEmpty(String key) {
        key=key.substring(1);
       if( ObjectUtils.isNull(key)|| StringUtils.isEmpty(key)|| key.equals("null")){
            return false;
        }
       return true;
    }


    @Comment("参数前增加一个变量后进行非空判断 该方法判断当前变量是否为空")
    @Example("${paramOne.isEmpty(str)}")
    public static Boolean isEmpty(String key) {
        key=key.substring(1);
        if( ObjectUtils.isNull(key)|| StringUtils.isEmpty(key)|| key.equals("null")){
            return true;
        }
        return false;
    }




    @Override
    public String getFunctionPrefix() {
        return "paramOne";
    }
}
