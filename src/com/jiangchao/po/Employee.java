package com.jiangchao.po;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;


/**
 * @Auther: Jiang Chao
 * @Date: 2018/4/27 11:20
 * @Description:
 * @version: 1.0
 */
public class Employee extends Person {
    static int count = 0;
    static int staticCount;
    private static int nextId;

    // 静态块
    static {
        Random random = new Random();
        nextId = random.nextInt(10000);
        System.out.println(String.format("静态块执行了%d次", ++staticCount));
    }

    private int id;
  // final参数设置之后，初始化必须设置，之后不能修改
    private double salary;
    private LocalDate hireDay;
//    private Date hDay;

    // 初始化块
    {
        id = nextId;
        nextId++;
        System.out.println(String.format("非静态块执行了%d次", ++count));
    }


   /* // 无参构造器, 需要在设置所有域适当的默认值
    public Employee() {
        this.name = "";
        this.salary = 0.0;
        this.hireDay = LocalDate.now();
    }*/

    public Employee(double salary){
        // this调用其他构造器
        this("Employee #"+nextId, salary);
    }

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
        
    }

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public static void main(String[] args) {
        System.out.println("Employee的main方法");
    }

    public int getId() {
        return id;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    // final关键字声明得方法，不能被覆盖
    public final String getName() {
        return super.getName();
    }

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

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

//    public Date getHDay() {
//        return (Date) hDay.clone(); // 返回克隆对象，防止原对象被修改
//    }

    public void raiseSalary(double byPercent) {
        double raise = this.salary * byPercent / 100;
        this.salary += raise;
    }

    public Employee getBuddy(){
        return null;
    }

    @Override
    public String getDesciption() {
        return String.format("a employee with salary of $%.2f", salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (!(o instanceof Employee)) return false;  // instanceof检验，无法解决子类的检验，对称性原则无法解决
        if (o == null) return false;
        if (getClass() != o.getClass()) return false; // getClass()返回对象所属类，这样适用于子类
        Employee employee = (Employee) o;
        return
                Objects.equals(name, employee.name) &&  // Objects.equals处理null有优势
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(hireDay, employee.hireDay);
    }

    @Override
    public int hashCode() {
        // null安全
        return 7 * Objects.hashCode(name) +
                11 * Double.hashCode(salary) +
                13 * Objects.hashCode(hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                '{' +
                "hireDay=" + hireDay +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
