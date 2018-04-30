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
        Employee boss = new Manager("Carl Crack", 75000, 1987, 12, 15);
        ((Manager) boss).setBonus(5000);
        Employee[] staff = new Employee[3];
        staff[0] = boss;

        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 65000, 1987, 12, 31);

        for (Employee e : staff) {
            System.out.println(e);
        }
        // 强制类型转换，适用于超类转子类
        // 转换前，先检测能否成功转换
        if (staff[0] instanceof Manager){
            Manager manager = (Manager) staff[0];
            System.out.println(manager.getBonus());
        }

        Manager m1 = new Manager("m1", 1000, 1994, 12, 24);
        Employee m2 = new Employee("m1", 1000, 1994, 12, 24);
        // 超类的instanceOf Employee检验会导致两种结果不一致，这是因为子类Manager实现了自己的equals概念
        System.out.println(m1.equals(m2));
        System.out.println(m2.equals(m1));
    }

}
