package com.smbms.Service;

import com.smbms.entity.Role;
import com.smbms.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> getRole() {
        return roleMapper.getRole();
    }
}
