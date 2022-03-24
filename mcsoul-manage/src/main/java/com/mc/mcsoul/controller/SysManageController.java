package com.mc.mcsoul.controller;

import com.mc.mcsoul.entity.BaseUserInfo;
import com.mc.mcsoul.service.SysManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sys/manage")
public class SysManageController {
    @Autowired
    private SysManageService sysManageService;

    @RequestMapping("login")
    public BaseUserInfo login(BaseUserInfo baseUserInfo) {
        return sysManageService.login(baseUserInfo);
    }
}
