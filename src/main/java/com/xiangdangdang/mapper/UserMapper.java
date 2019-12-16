package com.xiangdangdang.mapper;


import com.xiangdangdang.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    void insertOne(User user);

    void deleteOne(Long uid);

    void update(User user);

    User findById(Long uid);

    User findByName(String name);

    List<User> findAll();

    List<Map<String, String>> top10();
}
