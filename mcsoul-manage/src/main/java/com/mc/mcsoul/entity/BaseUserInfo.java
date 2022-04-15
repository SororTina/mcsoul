package com.mc.mcsoul.entity;

import lombok.Data;

@Data
public class BaseUserInfo {
    private Integer id;
    // 账号
    private String account;
    // 密码
    private String password;
    // 登陆code
    private String code;
    // openID
    private String openID;
    // 用户昵称
    private String nickName;
    // 用户头像
    private String avatarUrl;

    public BaseUserInfo(String openID) {
        this.openID = openID;
    }
    public BaseUserInfo() { }
}
