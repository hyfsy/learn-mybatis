package com.hyf.mybatis.anno;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

public interface TeacherAnnMapper {

    /**
     * 一对一查询老师时使用
     */
    @Select("select * from teacher_ann where t_id = #{asdf}")
    @Results(id = "teacherMap", value = {
            @Result(id = true, column = "t_id", property = "id"),
            @Result(column = "t_name", property = "name")
    })
    TeacherAnn selectTeacherById(Integer tid);

    /**
     * 一对多查询老师的同时，查询出所有对应的学生
     * <p>
     * 一对多时使用懒加载，只有当真正使用到该字段时，才去查询数据库
     */
    @Select("select * from teacher_ann where t_id = #{asdf}")
    @Results(id = "teacherWithUserMap", value = {
            @Result(id = true, column = "t_id", property = "id"),
            @Result(column = "t_name", property = "name"),
            @Result(column = "t_id", property = "userList",
                    many = @Many(select = "com.hyf.mybatis.anno.UserAnnMapper.selectUserAnnByTeacherId", fetchType = FetchType.LAZY))
    })
    TeacherAnn selectTeacherWithManyUser(Integer tid);
}
