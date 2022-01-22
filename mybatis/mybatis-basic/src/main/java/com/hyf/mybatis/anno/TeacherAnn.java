package com.hyf.mybatis.anno;

import java.io.Serializable;
import java.util.List;

public class TeacherAnn implements Serializable {

    private int id;
    private String name;
    private List<UserAnn> userList;

    public TeacherAnn() {
    }

    public TeacherAnn(int id, String name, List<UserAnn> userList) {
        this.id = id;
        this.name = name;
        this.userList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserAnn> getUserList() {
        return userList;
    }

    public void setUserList(List<UserAnn> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "TeacherAnn{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userList=" + userList +
                '}';
    }
}
