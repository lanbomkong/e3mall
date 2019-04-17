package cn.biosh.e3mall.common.interfaces;

/**
 * @description
 * @date 2019/4/15
 */
public interface RedisOperator {

  <T> T get(String key, Class<T> clazz);

  void set(String key, Object value, Long expireTime);

  void set(String key, Object value);

  boolean expired(String key, Long expireTime);

  boolean del(String key);
}
