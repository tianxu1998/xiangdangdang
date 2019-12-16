package com.xiangdangdang.service;

import com.xiangdangdang.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> findAllTag();

    Tag findTagById(Long tag_id);
}
