package com.hyf.mybatis.test;

import com.hyf.mybatis.pojo.Teacher;
import com.hyf.mybatis.typehandler.UserStatusEnum;

public class UserAndEnum {
    private Integer id;
    private String name;
    private Integer age;
    private Teacher teacher;
    private UserStatusEnum activity;

    public UserAndEnum() {}

    public UserAndEnum(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public UserStatusEnum getActivity() {
        return activity;
    }

    public void setActivity(UserStatusEnum activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                ", activity=" + activity +
                '}';
    }
}
