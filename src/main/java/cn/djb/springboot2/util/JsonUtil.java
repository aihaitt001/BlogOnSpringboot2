package cn.djb.springboot2.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private final static ObjectMapper objMapper = new ObjectMapper();

    static {
        objMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true); /* see: http://jira.codehaus.org/browse/JACKSON-208 */
    }

    public static String serialize(Object obj) {
        try {
            return objMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "serialize出错"+e.toString();
        }
    }

}
