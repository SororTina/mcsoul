package com.mc.mcsoul.controller;

import com.mc.mcsoul.config.WxMappingJackson2HttpMessageConverter;
import com.mc.mcsoul.entity.BaseUserInfo;
import com.mc.mcsoul.entity.ReqWxLogin;
import com.mc.mcsoul.entity.RespWxLogin;
import com.mc.mcsoul.service.SysManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/sys/manage")
public class SysManageController {
    @Autowired
    private SysManageService sysManageService;
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("login")
    public BaseUserInfo login(ReqWxLogin reqWxLogin) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appID}&secret={secret}&js_code={jsCode}&grant_type={grantType}";
        Map<String, Object> params = new HashMap<>();
        params.put("appID", reqWxLogin.getAppid());
        params.put("secret", reqWxLogin.getSecret());
        params.put("jsCode", reqWxLogin.getJs_code());
        params.put("grantType", reqWxLogin.getGrant_type());
        RespWxLogin respWxLogin = restTemplate.getForObject(url, RespWxLogin.class, params);
        System.out.println(respWxLogin);
        return sysManageService.login(new BaseUserInfo());
    }

    @RequestMapping("update")
    public boolean update(BaseUserInfo baseUserInfo) {
        return sysManageService.update(baseUserInfo);
    }
}
