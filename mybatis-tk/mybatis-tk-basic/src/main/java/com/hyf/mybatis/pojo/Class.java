package com.hyf.mybatis.pojo;

import javax.persistence.*;

@Table(name = "class")
public class Class {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class.c_id
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    private Integer cId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class.c_name
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    private String cName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column class.teacher_id
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    private Integer teacherId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class.c_id
     *
     * @return the value of class.c_id
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    public Integer getcId() {
        return cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class.c_id
     *
     * @param cId the value for class.c_id
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    public void setcId(Integer cId) {
        this.cId = cId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class.c_name
     *
     * @return the value of class.c_name
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    public String getcName() {
        return cName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class.c_name
     *
     * @param cName the value for class.c_name
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column class.teacher_id
     *
     * @return the value of class.teacher_id
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column class.teacher_id
     *
     * @param teacherId the value for class.teacher_id
     *
     * @mbg.generated Tue Feb 04 21:53:42 CST 2020
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}