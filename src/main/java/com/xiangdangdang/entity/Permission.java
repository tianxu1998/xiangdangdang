package com.xiangdangdang.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private Long pid;
    private String permission;
    private String description;
    private String availavle;

    @Override
    public String toString() {
        return "Permission{" +
                "pid=" + pid +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", availavle='" + availavle + '\'' +
                '}';
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailavle() {
        return availavle;
    }

    public void setAvailavle(String availavle) {
        this.availavle = availavle;
    }
}

