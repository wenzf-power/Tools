package Json;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author: wenzf
 * @Date 2021-10-29
 * @Description:
 */
public class JsonUtils {
   private  static  final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    //json 转 POJO
    public static <T> T getObject(String pojo, Class<T> tClass) {
        try {
            return JSONObject.parseObject(pojo, tClass);
        } catch (Exception e) {
            logger.error(tClass+"转换json失败");
        }
        return null;
    }

    //POJO
    public static <T> String getJson(T tResponse) {

        String pojo = JSONObject.toJSONString(tResponse);
        return  pojo;

    }

}
