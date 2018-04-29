package com.jiangchao;

// final修饰类阻止被继承
public final class Executive extends Manager {

    public Executive(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }
}

/*
    // 这一句编译器会报错，Executive不能被继承
class Subclass extends Executive {
    public Subclass(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }
}
*/
