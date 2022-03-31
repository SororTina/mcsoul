package com.mc.mcsoul.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * @version 1.0
 * @author: yitong
 * @date: 2022/3/28 0:06
 * @desc:
 */
@Data
public class ReqWxLogin {

	// 小程序 appId
	private String appid = "wxbd6c53423ff4397b";

	// 小程序 appSecret
	private String secret = "610f8c4be7339a56363c4dae8d2cc9e7";

	// 登录时获取的 code
	@NonNull
	private String js_code;

	// 授权类型
	private String grant_type = "authorization_code";
}
