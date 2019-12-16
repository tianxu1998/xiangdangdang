package com.xiangdangdang.service.impl;

import com.xiangdangdang.entity.Task;
import com.xiangdangdang.mapper.TaskMapper;
import com.xiangdangdang.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Override
    public void readCountPlus(Long task_id, Integer read_count) {
        read_count = read_count + 1;
        taskMapper.readCountPlus(task_id, read_count);
    }

    @Override
    public void publish(String title, String context, Long publish_uid, Double price, Long tag_id) {
        int status = 1; // 待领取状态
        LocalDateTime publish_time = LocalDateTime.now();
        LocalDate publish_date = LocalDate.now();
        Task newTask = new Task();
        newTask.setContext(context);
        newTask.setPrice(price);
        newTask.setPublish_date(publish_date);
        newTask.setPublish_time(publish_time);
        newTask.setTitle(title);
        newTask.setStatus(status);
        newTask.setTag_id(tag_id);
        newTask.setRead_count(0);

        Long task_id = taskMapper.createTask(newTask);
        taskMapper.createTaskAndUser(task_id, publish_uid, LocalDateTime.now());

    }

    @Override
    public void accept(Long accept_uid, Long task_id) {
        LocalDateTime accept_time = LocalDateTime.now();
        LocalDate end_date = LocalDate.now();
        int status = 2;
        taskMapper.accept(accept_time, accept_uid, end_date, task_id,status);
    }

    @Override
    public void end(Long task_id) {
        LocalDateTime end_time = LocalDateTime.now();
        LocalDate end_date = LocalDate.now();
        int status = 3;
        taskMapper.end(end_date, end_time, task_id, 3);
    }
}
