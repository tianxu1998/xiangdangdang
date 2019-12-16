package com.xiangdangdang.service;

import com.xiangdangdang.entity.Task;
import com.xiangdangdang.util.Result;

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

    void readCountPlus(Long task_id, Integer read_count);

    void publish(String title, String context, Long publish_uid,Double price,Long tag_id);

    void accept(Long accept_uid, Long task_id);

    void end(Long task_id);
}
