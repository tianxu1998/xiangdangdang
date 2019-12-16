package com.xiangdangdang.service.impl;

import com.xiangdangdang.entity.Task;
import com.xiangdangdang.mapper.TaskMapper;
import com.xiangdangdang.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public List<Task> findTaskLimit(Integer limit) {
        return taskMapper.findTaskLimit(limit);
    }

    @Override
    public Task findById(Long id) {
        return taskMapper.findById(id);
    }

    @Override
    public Task findByTitle(String title) {
        return taskMapper.findByTitle(title);
    }

    @Override
    public List<Task> findByTag(Long tag_id) {
        return taskMapper.findByTag(tag_id);
    }

    public List<Task> findByDate(LocalDate date) {
        return taskMapper.findByDate(date);
    }

    @Override
    public int findTodayTaskCount() {
        return taskMapper.countByDate(LocalDate.now());
    }

    @Override
    public int findTodayEndCount() {
        return taskMapper.countEndByDate(LocalDate.now());
    }

    @Override
    public List<Task> search(String keyword) {
        return taskMapper.search(keyword);
    }
}
