package com.hyf.mybatis.pojo;

import java.util.ArrayList;
import java.util.List;

public class PageEmp {
    private int start;
    private int end;
    private int count;
    private List<Emp> emps = new ArrayList<>();

    public PageEmp(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "PageEmp{" +
                "start=" + start +
                ", end=" + end +
                ", count=" + count +
                ", emps=" + emps +
                '}';
    }
}
