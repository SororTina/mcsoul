package com.mc.mcsoul.dao;

import com.mc.mcsoul.entity.BaseUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysManageMapper {
    BaseUserInfo login(BaseUserInfo baseUserInfo);
    int update(BaseUserInfo baseUserInfo);
}
