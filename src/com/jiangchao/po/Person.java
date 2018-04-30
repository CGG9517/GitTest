package com.jiangchao.po;

// 方法为abstract的类必须为抽象的, 抽象类不能被实例化，但可以创建一个具体子类对象
public abstract class Person {
    protected String name;

    public abstract String getDesciption();
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
