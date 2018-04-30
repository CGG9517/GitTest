package com.jiangchao;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    // 这种方法不能修改值，因为java是值传递a
    public static void triple(int x){
        x = 3 * x;
    }
    public static void triple(Integer x){

    }
    public static void main(String[] args) {
        List<Employee> staff = new ArrayList<>(10);
        staff.add(new Employee("Harry Hacker", 50000, 1937, 7, 30));
        // 确定不会扩充之后，trimToSize调整至合理大小，回收空间
        ((ArrayList<Employee>) staff).trimToSize();

        Employee[] staffArray = new Employee[staff.size()];
        staff.toArray(staffArray);

        Integer a = 1000;
        triple(a);

        System.out.println(a);
        Integer n = 1;
        Double x = 2.0;
        // 条件表达式混用了Integer和Double型，因此Integer会转为Double型
        System.out.println(true ? n : x);


        // 字符串转换成数字

        String b = "2";
        int c = Integer.parseInt(b);

        System.out.println(c);

    }

}
