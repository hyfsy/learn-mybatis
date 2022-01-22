package com.hyf.mybatis.test;

import org.apache.ibatis.jdbc.SQL;
import org.junit.jupiter.api.Test;

/**
 * sql语句构建器
 */
public class TestCreateSql {

    public static void main(String[] args) {
        // {}（构造函数） + {}（代码块） = {{}}（实例初始化器）
        String s = new TestCreateSql(){{
            test1();
            test2();
        }}.toString();
        System.out.println(s);
    }

    @Test
    public void test1() {
        String id = "1";
        String firstName = "张";
        String lastName = "三";
        String sql = new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
            FROM("PERSON P");
            if (id != null) {
                WHERE("P.ID like #{id}");
            }
            if (firstName != null) {
                WHERE("P.FIRST_NAME like #{firstName}");
            }
            if (lastName != null) {
                WHERE("P.LAST_NAME like #{lastName}");
            }
            ORDER_BY("P.LAST_NAME");
        }}.toString();
        System.out.println(sql);
    }

    @Test
    public void test2() {
        String sql = new SQL()
                .SELECT("P.ID", "A.USERNAME", "A.PASSWORD", "P.FULL_NAME", "D.DEPARTMENT_NAME", "C.COMPANY_NAME")
                .FROM("PERSON P", "ACCOUNT A")
                .INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID", "COMPANY C on D.COMPANY_ID = C.ID")
                .WHERE("P.ID = A.ID", "P.FULL_NAME like #{name}")
                .ORDER_BY("P.ID", "P.FULL_NAME")
                .toString();
        System.out.println(sql);
    }
}
