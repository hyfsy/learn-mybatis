package com.hyf.mybatis.pojo;

/**
 * To (Transfer Object)
 * 数据传输对象
 */
public class UserTo {

    private Integer id;
    private Integer age;

    public UserTo(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public UserTo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
