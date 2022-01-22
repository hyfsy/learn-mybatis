package com.hyf.mybatis.pojo;

import java.io.Serializable;

/**
 * 使用二级缓存需要实现序列化接口
 */
public class UserCache implements Serializable {

    private int id;
    private String name;
    private int age;

    public UserCache() {}

    public UserCache(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserCache{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
