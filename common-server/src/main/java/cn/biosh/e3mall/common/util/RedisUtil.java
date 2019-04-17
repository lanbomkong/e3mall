package cn.biosh.e3mall.common.util;

import cn.biosh.e3mall.common.interfaces.RedisOperator;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @description
 * @date 2019/4/15
 */
@Component("redisUtil")
public class RedisUtil implements RedisOperator {

  @Autowired
  private StringRedisTemplate redisTemplate;

  @Override
  public boolean del(String key) {
    return redisTemplate.delete(key);
  }

  @Override
  public boolean expired(String key, Long expireTime) {
    return redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
  }

  @Override
  public <T> T get(String key, Class<T> clazz) {
    return JsonUtil.jsonStringToObject(redisTemplate.opsForValue().get(key), clazz);
  }

  @Override
  public void set(String key, Object value, Long expireTime) {
    redisTemplate.opsForValue().set(key ,JsonUtil.objectToJsonString(value) ,expireTime, TimeUnit.SECONDS);
  }

  @Override
  public void set(String key, Object value) {
    redisTemplate.opsForValue().set(key ,JsonUtil.objectToJsonString(value));
//    redisTemplate.opsForValue().set(key, value);
  }
}
