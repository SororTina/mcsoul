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
        BaseUserInfo userInfo = sysManageService.getUserByOpenID(new BaseUserInfo(respWxLogin.getOpenid()));
        results.put("userInfo", new BaseUserInfo());
        return results;
    }

    @RequestMapping("update")
    public boolean update(BaseUserInfo baseUserInfo) {
        return sysManageService.update(baseUserInfo);
    }
}
