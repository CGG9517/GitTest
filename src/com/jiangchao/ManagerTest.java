package com.jiangchao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Auther: Jiang Chao
 * @Date: 2018/4/27 11:27
 * @Description:
 * @version: 1.0
 */
public class ManagerTest {

    public static void main(String[] args) {
//        Employee.main(null); // 真被调用了main
        Manager boss = new Manager("Carl Crack", 75000, 1987, 12, 15);
        boss.setBonus(5000);
        Employee[] staff = new Employee[3];
        staff[0] = boss;

        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 65000, 1987, 12, 31);

        for (Employee e : staff) {
            System.out.println(e);
        }



    }

}
