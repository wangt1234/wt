package com.smbms.mapper;

import com.smbms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getAllUser();
    User getUser(@Param("userCode") String userCode,@Param("userPassword") String userPassword);
    int updateByid(@Param("id") Integer id,@Param("userPassword") String userPassword);
    List<User> getUserByPage(@Param("userName") String userName,@Param("userRole") Integer userRole,
                             @Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);
    int getUserCount(@Param("userName") String userName,@Param("userRole") Integer userRole);
    int add(User user);
    User checkUserCode(@Param("userCode") String userCode);
    User getUserById(@Param("id") Integer id);
}
