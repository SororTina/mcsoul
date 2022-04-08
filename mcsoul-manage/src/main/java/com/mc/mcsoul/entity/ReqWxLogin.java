package com.mc.mcsoul.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @version 1.0
 * @author: yitong
 * @date: 2022/3/28 0:06
 * @desc:
 */
@Data
@Component
public class ReqWxLogin {

	// 小程序 appId
	@Value("${wx.appID}")
	private String appid;

	// 小程序 appSecret
	@Value("${wx.appSecret}")
	private String secret;

	// 登录时获取的 code
	private String js_code;

	// 授权类型
	@Value("${wx.grantType}")
	private String grant_type;

}
