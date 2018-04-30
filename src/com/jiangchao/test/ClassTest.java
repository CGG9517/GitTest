package com.jiangchao.test;

import com.jiangchao.po.Employee;

import java.lang.reflect.Constructor;


public class ClassTest {

    public static void main(String[] args) {
        try {
            // forName静态方法返回命名对应的Class对象， Class<T>
            Class _class = Class.forName("com.jiangchao.po.Employee");
            Employee e = new Employee(50000);
            // object.class返回类
            Class cl1 = Object[].class;
            Class cl2 = int.class;

            // 生成新实例, 无参构造新实例
            cl1.newInstance();


            // getClass返回类
            System.out.println(e.getClass().getName());

            System.out.println(_class.getName()+" "+e.getName());
            System.out.println(cl1.getName());
        } catch (ClassNotFoundException | IllegalAccessException|InstantiationException e){
            e.printStackTrace();

        }

    }
}
