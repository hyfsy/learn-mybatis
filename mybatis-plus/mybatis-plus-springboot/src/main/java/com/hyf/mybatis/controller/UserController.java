package com.hyf.mybatis.controller;


import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baB_hyf
 * @since 2020-02-05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("select/{id}")
    public User select(@PathVariable String id) {
        return userMapper.selectById(id);
    }
}
