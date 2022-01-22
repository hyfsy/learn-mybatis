package com.hyf.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hyf.mybatis.pojo.User;
import org.apache.ibatis.annotations.Delete;

/**
 * 继承 BaseMapper 接口即可
 */
public interface UserMapper extends BaseMapper<User> {

    @Delete("delete * from user")
    int deleteAll();
}
