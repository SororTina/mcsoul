package com.mc.mcsoul.controller;

import com.mc.mcsoul.entity.BaseUserInfo;
import com.mc.mcsoul.entity.ReqWxLogin;
import com.mc.mcsoul.entity.RespWxLogin;
import com.mc.mcsoul.service.SysManageService;
import com.mc.mcsoul.utils.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/sys/manage")
public class SysManageController {
    @Autowired
    private SysManageService sysManageService;

    @RequestMapping("login")
    public AjaxJson login(ReqWxLogin reqWxLogin) {
        AjaxJson results = AjaxJson.success();
        RespWxLogin respWxLogin = sysManageService.getOpenID(reqWxLogin);
        results.put("userInfo", sysManageService.getUserByOpenID(new BaseUserInfo(respWxLogin.getOpenid())));
        return results;
    }

    @RequestMapping("register")
    public AjaxJson register(ReqWxLogin reqWxLogin, BaseUserInfo baseUserInfo) {
        AjaxJson results = AjaxJson.success();
        RespWxLogin respWxLogin = sysManageService.getOpenID(reqWxLogin);
        baseUserInfo.setOpenID(respWxLogin.getOpenid());
        results.put("userInfo", sysManageService.register(baseUserInfo));
        return results;
    }

    @RequestMapping("update")
    public boolean update(BaseUserInfo baseUserInfo) {
        return sysManageService.update(baseUserInfo);
    }
}
