package com.mc.mcsoul.entity;

import lombok.Data;

/**
 * @version 1.0
 * @author: yitong
 * @date: 2022/3/28 0:06
 * @desc:
 */
@Data
public class RespWxLogin {

	// 用户唯一标识
	private String openid;

	// 会话密钥
	private String session_key;

	// 用户在开放平台的唯一标识符
	private String unionid;

	// 错误码
	private Integer errcode;

	//错误信息
	private String errmsg;
}
