package com.xiangdangdang.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task implements Serializable {
    private Long task_id;
    private Integer status;
    private Long tag_id;
    private LocalDateTime publish_time;
    private LocalDateTime end_time;
    private Double price;
    private Long accept_uid;
    private String title; // 标题
    private String context; // 内容
    private Integer read_count; // 阅读次数
    private LocalDate publish_date; // 发布日期
    private LocalDate end_date; // 完成日期


    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", status=" + status +
                ", tag_id=" + tag_id +
                ", publish_time=" + publish_time +
                ", end_time=" + end_time +
                ", price=" + price +
                ", accept_uid=" + accept_uid +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", read_count=" + read_count +
                ", publish_date=" + publish_date +
                ", end_date=" + end_date +
                '}';
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTag_id() {
        return tag_id;
    }

    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
    }

    public LocalDateTime getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(LocalDateTime publish_time) {
        this.publish_time = publish_time;
    }

    public LocalDateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(LocalDateTime end_time) {
        this.end_time = end_time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getAccept_uid() {
        return accept_uid;
    }

    public void setAccept_uid(Long accept_uid) {
        this.accept_uid = accept_uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getRead_count() {
        return read_count;
    }

    public void setRead_count(Integer read_count) {
        this.read_count = read_count;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

}
