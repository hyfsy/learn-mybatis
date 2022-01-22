package com.hyf.mybatis.anno;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * 开启二级缓存
 */
@CacheNamespace
public interface UserAnnMapper {

    /**
     * # 模糊查询也可以使用此种方式，其中的参数必须为<code>value</code>
     * <p>
     * # @Results注解用来指定返回值映射的类型，相当于配置文件中的 ResultMap标签
     *      id 相当于配置 ResultMap 的 id 值
     * # @Result注解用来指定每一个字段的映射
     *      id 判断是否为主键字段
     *      column 指定数据库中的列
     *      property 指定映射的实体字段
     *      javaType 指定实体字段的类型
     *      jdbcType 指定数据库中的数据类型
     *      typeHandler 指定该类型对应的类型处理器
     * #            @One 指定该实体字段为一对一，相当于配置文件中的 Association标签
     * #            @Many 指定该实体字段为一对多，相当于配置文件中的 Collection标签
     *                  select 指定值的 namespace + methodName
     *                  fetchType 指定子查询是否为懒加载 (LAZY | EAGER | DEFAULT)
     */
    @Select("select * from user_ann where name like '%${value}%'")
    @Results(
            id = "userAnnMap",
            value = {
                    @Result(id = true, column = "id", property = "userId", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
                    @Result(column = "name", property = "userName"),
                    @Result(column = "age", property = "userAge")
            })
    List<UserAnn> selectUserAnnByName(String name);

    /**
     * # @ResultMap 通过上面的 @Results 注解中的 id属性，指定使用的映射类型
     */
    @Select("select * from user_ann")
    @ResultMap("userAnnMap")
    List<UserAnn> selectAllUser();

    /**
     * 一对一子查询
     *
     * # @One 通过One注解实现一对一查询，相当于 配置文件中的Association标签
     *          select指定对应查询的 命名空间 + 方法名
     *          fetchType指定是否使用懒加载，一般一对一使用立即加载，一对多时才使用懒加载
     */
    @Select("select * from user_ann where id = #{userId}")
    @Results(
            value = {
                    @Result(id = true, column = "id", property = "userId", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
                    @Result(column = "name", property = "userName"),
                    @Result(column = "age", property = "userAge"),
                    @Result(column = "t_id", property = "teacher",
                            one = @One(select = "com.hyf.mybatis.anno.TeacherAnnMapper.selectTeacherById", fetchType = FetchType.EAGER))
            })
    UserAnn selectUserWithOneTeacher(Integer userId);

    /**
     * 通过老师，一对多查询时使用
     */
    @Select("select * from user_ann where t_id = #{tid}")
    @ResultMap("userAnnMap")
    UserAnn selectUserAnnByTeacherId(Integer tid);

}
