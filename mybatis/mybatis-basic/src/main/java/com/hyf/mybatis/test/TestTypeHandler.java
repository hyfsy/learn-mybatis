package com.hyf.mybatis.test;

import com.hyf.mybatis.mapper.UserMapper;
import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.typehandler.UserStatusEnum;
import com.hyf.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestTypeHandler {

    /**
     * 测试自定义枚举类型转换
     */
    @Test
    public void testEnumTypeHandler() {
        UserAndEnum user = new UserAndEnum(null, "测试枚举类型转换", 49);
        user.setActivity(UserStatusEnum.PLAY);
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 可以看到 枚举类型的Activity 被转换为其中的 code 了
            mapper.testInsertEnumTypeHandler(user);
            List<User> users = mapper.selectAllUser();
            // 打印 user对象可以看到，从数据库中取出的 code 已经被转换为 UserStatusEnum对象了
            // 其他为 null的对象也转换为了默认的状态
            users.forEach(System.out::println);
        }
    }
}
