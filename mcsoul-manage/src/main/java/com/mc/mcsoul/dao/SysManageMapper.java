package com.mc.mcsoul.dao;

import com.mc.mcsoul.entity.BaseUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysManageMapper {
    BaseUserInfo login(BaseUserInfo baseUserInfo);
}
