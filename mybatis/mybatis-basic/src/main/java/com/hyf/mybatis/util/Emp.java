package com.hyf.mybatis.util;

/**
 * oracle测试实体
 * eName属性特别注意，可能get set方法会调用失败
 * 方法名改为：getEName、setEName
 */
public class Emp {

    private Integer empNo;
    private String eName;
    private String job;

    public Emp() {}

    public Emp(Integer empNo, String eName, String job) {
        this.empNo = empNo;
        this.eName = eName;
        this.job = job;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
