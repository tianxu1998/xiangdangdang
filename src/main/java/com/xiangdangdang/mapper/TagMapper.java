package com.xiangdangdang.mapper;

import com.xiangdangdang.entity.Tag;

import java.util.List;

public interface TagMapper {
    List<Tag> findAllTag();

    Tag findTagById(Long tag_id);
}
