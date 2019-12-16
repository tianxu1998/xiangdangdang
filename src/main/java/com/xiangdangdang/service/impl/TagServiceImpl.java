package com.xiangdangdang.service.impl;

import com.xiangdangdang.entity.Tag;
import com.xiangdangdang.mapper.TagMapper;
import com.xiangdangdang.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAllTag() {
        return tagMapper.findAllTag();
    }

    @Override
    public Tag findTagById(Long tag_id) {
        return tagMapper.findTagById(tag_id);
    }
}
