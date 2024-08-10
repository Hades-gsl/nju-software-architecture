package com.hades.processor.mapper;

import com.hades.processor.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Hades @Date: 2024/5/28 @Description:
 */
@Mapper
public interface UserMapper {
  @Insert("INSERT INTO user (userId) VALUES (#{userId})")
  void insertUser(User user);
}
