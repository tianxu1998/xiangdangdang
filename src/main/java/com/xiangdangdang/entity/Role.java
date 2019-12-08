package com.xiangdangdang.entity;

import java.io.Serializable;

public class Role implements Serializable {
    private Long rid;
    private String role;
    private String description;
    private Integer available;

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
}
