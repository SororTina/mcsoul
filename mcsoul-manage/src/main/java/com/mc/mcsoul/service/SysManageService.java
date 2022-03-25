package com.mc.mcsoul.service;

import com.mc.mcsoul.dao.SysManageMapper;
import com.mc.mcsoul.entity.BaseUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysManageService {
    @Autowired
    private SysManageMapper sysManageMapper;

    public BaseUserInfo login(BaseUserInfo baseUserInfo) {
        return sysManageMapper.login(baseUserInfo);
    }

    @Transactional(readOnly = false)
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
