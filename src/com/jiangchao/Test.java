package com.jiangchao;


import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;

public class Test {
    static String name="";
    public Test() {

    }

    /**
     * 静态方法不能对对象实施操作，this参数会报错
     */
    public void newFunction(){
        String fuctionName = Test.name;
        double a = Math.PI;
        System.out.println();
        LocalDate.now(); // 静态工厂方法
        try {

            new PrintStream("myFile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

