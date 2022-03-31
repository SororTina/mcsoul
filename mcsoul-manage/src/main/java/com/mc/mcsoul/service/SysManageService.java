package com.mc.mcsoul.service;

import com.mc.mcsoul.dao.SysManageMapper;
import com.mc.mcsoul.entity.BaseUserInfo;
import com.mc.mcsoul.entity.ReqWxLogin;
import com.mc.mcsoul.entity.RespWxLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class SysManageService {
    @Autowired
    private SysManageMapper sysManageMapper;
    @Autowired
    private RestTemplate restTemplate;
    public BaseUserInfo login(ReqWxLogin reqWxLogin) {

        return sysManageMapper.login(new BaseUserInfo());
    }

    public RespWxLogin getOpenID(ReqWxLogin reqWxLogin) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appID}&secret={secret}&js_code={jsCode}&grant_type={grantType}";
        Map<String, Object> params = new HashMap<>();
        params.put("appID", reqWxLogin.getAppid());
        params.put("secret", reqWxLogin.getSecret());
        params.put("jsCode", reqWxLogin.getJs_code());
        params.put("grantType", reqWxLogin.getGrant_type());
        RespWxLogin respWxLogin = restTemplate.getForObject(url, RespWxLogin.class, params);
        System.out.println(respWxLogin);
        return respWxLogin;
    }
    public BaseUserInfo getUserByOpenID(BaseUserInfo baseUserInfo) {
        return sysManageMapper.getUser(baseUserInfo);
    }
    public boolean update(BaseUserInfo baseUserInfo) {
        if(sysManageMapper.update(baseUserInfo) > 0) {
            BaseUserInfo user = null;
            System.out.println(user.getAccount());
            return true;
        } else {
            return false;
        }
    }

}
