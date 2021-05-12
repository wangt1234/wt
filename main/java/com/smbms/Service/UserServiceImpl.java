package com.smbms.Service;

import com.smbms.entity.User;
import com.smbms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser(String userCode, String userPassword) {
        return userMapper.getUser(userCode,userPassword);
    }

    @Override
    public int updateByid(Integer id, String userPassword) {
        return userMapper.updateByid(id,userPassword);
    }

    @Override
    public List<User> getUserByPage(String userName, Integer userRole, Integer startIndex, Integer pageSize) {
        return userMapper.getUserByPage(userName,userRole,startIndex,pageSize);
    }

    @Override
    public int getUserCount(String userName, Integer userRole) {
        return userMapper.getUserCount(userName,userRole);
    }

    @Override
    public boolean add(User user) {
        return userMapper.add(user)>0?true:false;
    }

    @Override
    public boolean checkUserCode(String userCode) {
        return userMapper.checkUserCode(userCode)!=null?true:false;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
}
