package com.hyf.mybatis.pojo;

/**
 * oracle测试实体
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
