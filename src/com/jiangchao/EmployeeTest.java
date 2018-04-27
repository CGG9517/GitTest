package com.jiangchao;

/**
 * @Auther: Jiang Chao
 * @Date: 2018/4/27 11:27
 * @Description:
 * @version: 1.0
 */
public class EmployeeTest {
    public static void main(String[] args) {
//        Employee a = new Employee(); // 类域（类属性）会默认初始化，而局域变量必须明确

//        Employee.main(null); // 真被调用了main
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Crack", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 65000, 1987, 12, 31);

        for (Employee e:staff){
            e.raiseSalary(5);

        }

        for (Employee e:staff){
            System.out.println(e);
        }

    }




}
