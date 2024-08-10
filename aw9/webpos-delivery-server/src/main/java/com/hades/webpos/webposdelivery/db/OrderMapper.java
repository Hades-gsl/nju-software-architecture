package com.hades.webpos.webposdelivery.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: Hades @Date: 2024/6/24 @Description:
 */
@Mapper
public interface OrderMapper {
  @Select("SELECT * FROM order WHERE orderId = #{orderId}")
  Order getOrder(String orderId);

  @Update("UPDATE order SET status = #{status} WHERE orderId = #{orderId}")
  void updateOrderStatus(String orderId, String status);

  @Insert("INSERT INTO order (orderId, status) VALUES (#{orderId}, #{status})")
  void insertOrder(String orderId, String status);
}
