package Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

/**
 * @Author: wenzf
 * @Date 2021-8-10
 * @Description:
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        String user = "{\"id\":2,\"name\":\"wzf\",\"age\":22}";

        //将json字符串转json对象，Feature.OrderedField防止乱序
        JSONObject jsonObject = JSON.parseObject(user, Feature.OrderedField);
        System.out.println(jsonObject);

        //toJSONString方法将json对象转json字符串
        String user1 = jsonObject.toJSONString();
        System.out.println(user1);
    }
}
/**
 * 运行结果示例：
 * {"id":2,"name":"wzf","age":22}
 * {"id":2,"name":"wzf","age":22}
 */
