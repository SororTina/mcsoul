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
    @Autowired
    private ReqWxLogin wxLogin;


    public BaseUserInfo login(ReqWxLogin reqWxLogin) {

        return sysManageMapper.login(new BaseUserInfo());
    }

    public RespWxLogin getOpenID(ReqWxLogin reqWxLogin) {
        wxLogin.setJs_code(reqWxLogin.getJs_code());
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appID}&secret={secret}&js_code={jsCode}&grant_type={grantType}";
        Map<String, Object> params = new HashMap<>();
        params.put("appID", wxLogin.getAppid());
        params.put("secret", wxLogin.getSecret());
        params.put("jsCode", wxLogin.getJs_code());
        params.put("grantType", wxLogin.getGrant_type());
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
