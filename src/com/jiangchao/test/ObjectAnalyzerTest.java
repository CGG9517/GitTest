package com.jiangchao.test;

import com.jiangchao.po.ObjectAnalyzer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @class: ObjectAnalyzerTest
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/1
 */
public class ObjectAnalyzerTest {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++) squares.add(i * i);
        squares.trimToSize();
        System.out.println(new ObjectAnalyzer().toString(squares));


    }
}
