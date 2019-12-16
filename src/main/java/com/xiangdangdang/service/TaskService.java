package com.xiangdangdang.service;

import com.xiangdangdang.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    List<Task> findTaskLimit(Integer limit);

    Task findById(Long id);

    Task findByTitle(String title);

    List<Task> findByTag(Long tag_id);

    List<Task> findByDate(LocalDate date);

    int findTodayTaskCount();

    int findTodayEndCount();

    List<Task> search(String keyword);
}
