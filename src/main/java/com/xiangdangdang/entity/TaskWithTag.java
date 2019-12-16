package com.xiangdangdang.entity;

public class TaskWithTag extends Task {
    private Tag tag; // 多对一

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "TaskWithTag{" +
                "tag=" + tag +
                '}';
    }
}
