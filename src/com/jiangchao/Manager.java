package com.jiangchao;

public class Manager extends Employee{
    private double bonus;

    public void setBonus(double bonus) {
        this.bonus = bonus;
//        setSalary(getSalary() + this.bonus);
    }
   /*
   // 不能覆盖final修饰得方法
   public String getName(){

    }*/
    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public Manager(String name, double salary, int year, int month, int day) {

        // 显式调用超类的构造器方法，如果超类不带无参构造器，这里没有显示配置超类构造器，会报错
        // 且调用构造器的语句只能在本构造器的第一句出现
        super(name, salary, year, month, day);
        bonus = 0;
    }

    @Override

    // 重写了超类得getBuddy方法，运行时实现动态绑定
    public Manager getBuddy(){
        return null;
    }



}
