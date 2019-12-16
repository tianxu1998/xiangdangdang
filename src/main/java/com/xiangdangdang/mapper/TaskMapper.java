package com.xiangdangdang.mapper;

import com.xiangdangdang.entity.Task;
import com.xiangdangdang.util.Result;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskMapper {

    List<Task> findTaskLimit(Integer limit);

    Task findById(Long id);

    Task findByTitle(String title);

    List<Task> findByTag(Long tag_id);

    List<Task> findByDate(LocalDate date);

    Integer countByDate(LocalDate date);

    Integer countEndByDate(LocalDate date);

    List<Task> search(String keyword);

    void readCountPlus(Long task_id, Integer read_count);

    Long createTask(Task task);

    void createTaskAndUser(Long task_id, Long publish_uid, LocalDateTime accept_time);

    void accept(LocalDateTime end_time, Long accept_uid, LocalDate end_date, Long task_id,Integer status);

    void end(LocalDate end_date, LocalDateTime end_time, Long task_id, Integer status);
}
