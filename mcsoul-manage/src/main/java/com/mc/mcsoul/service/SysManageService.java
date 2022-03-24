package com.mc.mcsoul.service;

import com.mc.mcsoul.dao.SysManageMapper;
import com.mc.mcsoul.entity.BaseUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysManageService {
    @Autowired
    private SysManageMapper sysManageMapper;

    public BaseUserInfo login(BaseUserInfo baseUserInfo) {
        return sysManageMapper.login(baseUserInfo);
    }
}
