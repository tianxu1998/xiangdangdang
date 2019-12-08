package com.xiangdangdang.service;

import com.xiangdangdang.entity.Permission;
import com.xiangdangdang.entity.Role;
import com.xiangdangdang.entity.User;

import java.util.List;

public interface UserService {
    void insertOne(User user);

    void deleteOne(Long uid);

    void update(User user);

    User findById(Long uid);

    User findByName(String name);

    List<Role> findRoles(User user);

    List<Permission> findPermissions(User user);

    List<Role> findRoles(String username);

    List<Permission> findPermissions(String username);

    List<User> findAll();
}
