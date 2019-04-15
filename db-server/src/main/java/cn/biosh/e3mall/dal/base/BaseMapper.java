package cn.biosh.e3mall.dal.base;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

/**
 * @description
 * @date 2019/4/12
 */
public interface BaseMapper<T extends BaseModel> {
  int deleteByPrimaryKey(Long id);

  int insert(T record);

  int insertSelective(T record);

  T selectByPrimaryKey(Long id);

  int updateByPrimaryKeySelective(T record);

  int updateByPrimaryKey(T record);

  List<T> getByConditions(@Param("map") Map<String, Object> map);

}
