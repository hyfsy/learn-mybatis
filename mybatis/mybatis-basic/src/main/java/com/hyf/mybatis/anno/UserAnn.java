package com.hyf.mybatis.anno;

import java.io.Serializable;

/**
 * 注解开发测试实体
 */
public class UserAnn implements Serializable {

    // 基本信息
    private int userId;
    private String userName;
    private int userAge;

    // 一个学生对应一个老师，一个老师对应多个学生
    private TeacherAnn teacher;


    public UserAnn() {
    }

    public UserAnn(int userId, String userName, int userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public TeacherAnn getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherAnn teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "UserAnn{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", teacher=" + teacher +
                '}';
    }
}
