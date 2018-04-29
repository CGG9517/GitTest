package com.jiangchao;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Auther: Jiang Chao
 * @Date: 2018/4/27 11:20
 * @Description:
 * @version: 1.0
 */
public class Employee {
    private static int nextId;

    private int id;

    private String name;  // final参数设置之后，初始化必须设置，之后不能修改
    private double salary;
    private LocalDate hireDay;
    private Date hDay;
    static int count = 0;
    static int staticCount;
    // 初始化块
    {
        id = nextId;
        nextId++;
        System.out.println(String.format("非静态块执行了%d次", ++count));
    }

    // 静态块
    static {
        Random random = new Random();
        nextId = random.nextInt(10000);
        System.out.println(String.format("静态块执行了%d次", ++staticCount));
    }


   /* // 无参构造器, 需要在设置所有域适当的默认值
    public Employee() {
        this.name = "";
        this.salary = 0.0;
        this.hireDay = LocalDate.now();
    }*/

    public Employee(double salary){
        this("Employee #"+nextId, salary);
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        // this调用其他构造器
    }

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public int getId() {
        return id;
    }

    // final关键字声明得方法，不能被覆盖
    public final String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // 不要编写直接返回可变对象的引用
    public LocalDate getHireDay() {
        return hireDay;
    }

    public Date getHDay() {
        return (Date) hDay.clone(); // 返回克隆对象，防止原对象被修改
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + getSalary() +
                ", hireDay=" + hireDay +
                ", hDay=" + hDay +
                '}';
    }

    public Employee getBuddy(){
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Employee的main方法");
    }
}
