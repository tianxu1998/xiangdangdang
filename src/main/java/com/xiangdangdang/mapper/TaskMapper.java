package com.xiangdangdang.mapper;

import com.xiangdangdang.entity.Task;

import java.time.LocalDate;
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
}
