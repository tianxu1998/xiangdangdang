package com.xiangdangdang.service.impl;

import com.xiangdangdang.entity.Permission;
import com.xiangdangdang.entity.Role;
import com.xiangdangdang.entity.User;
import com.xiangdangdang.mapper.UserMapper;
import com.xiangdangdang.service.UserService;
import com.xiangdangdang.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public void insertOne(User user) {
        passwordHelper.encryptPassword(user);
        userMapper.insertOne(user);
    }

    @Override
    public void deleteOne(Long uid) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(Long uid) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<Role> findRoles(User user) {
        return null;
    }

    @Override
    public List<Permission> findPermissions(User user) {
        return null;
    }

    @Override
    public List<Role> findRoles(String username) {
        return null;
    }

    @Override
    public List<Permission> findPermissions(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
