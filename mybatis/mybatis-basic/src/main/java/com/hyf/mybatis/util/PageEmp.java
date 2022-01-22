package com.hyf.mybatis.util;

import java.util.ArrayList;
import java.util.List;

public class PageEmp {
    private int startPage;
    private int endPage;
    private int totalPage;
    private List<Emp> empList = new ArrayList<>();

    public PageEmp(int startPage, int endPage) {
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Emp> getEmpLIst() {
        return empList;
    }

    public void setEmpLIst(List<Emp> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "PageEmp{" +
                "startPage=" + startPage +
                ", endPage=" + endPage +
                ", totalPage=" + totalPage +
                ", empList=" + empList +
                '}';
    }
}
