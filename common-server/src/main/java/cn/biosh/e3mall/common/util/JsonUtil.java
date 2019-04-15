package cn.biosh.e3mall.common.util;

import com.alibaba.fastjson.JSON;

/**
 * @description
 * @date 2019/4/15
 */
public class JsonUtil {

  public static String objectToJsonString(Object object) {
    return JSON.toJSONString(object);
  }

  public static <T> T jsonStringToObject(String jsonString, Class<T> clazz) {
    return JSON.parseObject(jsonString, clazz);
  }

}
