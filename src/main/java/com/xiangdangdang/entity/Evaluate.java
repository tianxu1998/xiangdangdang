package com.xiangdangdang.entity;

import java.io.Serializable;

public class Evaluate implements Serializable {
    private Long id;
    private Long fromid;
    private Long toid;
    private String context;

    @Override
    public String toString() {
        return "Evaluate{" +
                "id=" + id +
                ", fromid=" + fromid +
                ", toid=" + toid +
                ", context='" + context + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFromid() {
        return fromid;
    }

    public void setFromid(Long fromid) {
        this.fromid = fromid;
    }

    public Long getToid() {
        return toid;
    }

    public void setToid(Long toid) {
        this.toid = toid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
