package cn.djb.springboot2.util;


import cn.djb.springboot2.domain.BlogUser;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
*@Decription:利用jackson.core 进行json字符串和对象的相互转化
*@Classname:JsonUtil
*@Author: ovo
*@Date:2018/9/28 15:46
*/

public class JsonUtil {

    private final static ObjectMapper OBJMAPPER = new ObjectMapper();

    static {
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJMAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true); /* see: http://jira.codehaus.org/browse/JACKSON-208 */
    }

    public static String toString(Object obj) {
        try {
            return OBJMAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "serialize出错" + e.toString();
        }
    }

    public static Object toObject(String strJson, Class objClass) {
        try {
            return OBJMAPPER.readValue(strJson, objClass);
        } catch (Exception e) {
            e.printStackTrace();
            return "" + e.toString();
        }
    }

}
