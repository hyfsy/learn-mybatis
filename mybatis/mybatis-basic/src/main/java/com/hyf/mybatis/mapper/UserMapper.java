package com.hyf.mybatis.mapper;

import com.hyf.mybatis.pojo.User;
import com.hyf.mybatis.pojo.UserTo;
import com.hyf.mybatis.test.UserAndEnum;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 映射sql的mapper接口
 */
public interface UserMapper {

    User selectUserById(Integer id);

    List<User> selectAllUser();

    int insertUser(User user);

    long updateUser(User user);

    boolean deleteUserById(Integer id);


    // 测试传参方法
    User selectUserWithManyParam1(Integer id, Integer age);

    User selectUserWithManyParam2(@Param("id") Integer id, @Param("age") Integer age);

    User selectUserWithManyParam3(Map<String, Object> paramsMap);

    User selectUserWithManyParam4(UserTo userTo);


    // 测试返回值类型
    List<User> selectUserReturnList(String name);

    Map<String, Object> selectUserReturnMap(Integer id);

    @MapKey("id")
    Map<String, User> selectUserReturnAssignMap(String name);


    // 测试 resultMap
    List<User> selectUserUseResultMap(Integer id);

    User selectUserUseResultMapByPointSymbol(Integer id);

    User selectUserUseResultMapAssociation(Integer id);

    // 测试一对多使用
    List<User> selectUserListByTeacherId(Integer tid);

    // 测试鉴别器
    User testResultMapDiscriminator(Integer id);


    // 测试动态sql
    User selectUserTestWhere_If(User user);

    User selectUserTestTrim(User user);

    User selectUserTestChoose_When_Otherwise(User user);

    boolean updateUserTestSet(User user);

    List<User> selectUserListTestForEach(@Param("idList") List<Integer> idList);

    // foreach 批量操作
    int insertBatchTestMysql(List<User> userList);

    int insertBatchTestMysqlTwo(List<User> userList);


    // 内置参数
    User testInnerParams(Integer id);

    // bind 标签
    // 只能传入对象，并且绑定的属性要有get set
    List<User> testLikeBind(User user);

    List<User> testRefSql();

    //测试自定义类型处理器
    int testInsertEnumTypeHandler(UserAndEnum user);

}
