package com.jiangchao.po;

import com.jiangchao.po.Person;

public class Student extends Person {
    private String major;

    @Override
    public String getDesciption() {
        return "a student majoring in " + major;
    }

    public Student(String name, String major) {
        super(name);
        this.name = name;
        this.major = major;
    }

    public String getMajor() {
        return major;
    }
}
