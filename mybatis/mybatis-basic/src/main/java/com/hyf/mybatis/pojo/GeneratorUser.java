package com.hyf.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

public class GeneratorUser implements Serializable {
    private Integer userId;

    private Date userBirthday;

    private Double userSalary;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Double userSalary) {
        this.userSalary = userSalary;
    }
}