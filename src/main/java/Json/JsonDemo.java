package Json;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wenzf
 * @Date 2021-8-10
 * @Description:
 */
public class JsonDemo {

    public static void main(String[] args) {
        /**
         * 将Map转成JSON
         */
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("k1", "one");
        map.put("k2", "two");
        String mapJson = JSON.toJSONString(map);
        System.out.println(mapJson);
        /**
         * List<map>转成JSON
         */
        ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("k1", "v1");
        map1.put("k2", "v2");
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("k3", "v3");
        map2.put("k4", "v4");
        list.add(map1);
        list.add(map2);
        String listJson = JSON.toJSONString(list);
        System.out.println(listJson);
    }
}
/**
 * 运行结果示例：
 * {"k1":"one","k2":"two"}
 * [{"k1":"v1","k2":"v2"},{"k3":"v3","k4":"v4"}]
 */
