package com.xiangdangdang.util;

public class LoginResult extends Result{
    private Long uid;
    private String username;
    private int reputation;

    public LoginResult(int code, String errMsg, Long uid, String username, int reputation) {
        super(code, errMsg);
        this.uid = uid;
        this.reputation = reputation;
        this.username = username;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}
