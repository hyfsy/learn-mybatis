package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * mapper注解接口
 */
public interface UserMapperAnnotation {

    @Select("select * from users where id = #{id}")
    User selectUserById(Integer id);

}
