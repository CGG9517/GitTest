package com.jiangchao.test;

import com.jiangchao.po.Size;

import java.util.Arrays;
import java.util.Scanner;

public class SizeTest {

    public static void main(String[] args) {
        Size[] sizes = Size.values();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Size: " + Arrays.toString(sizes));
        String input = scanner.next().toUpperCase();
        // valueOf静态方法返回一个枚举实例常量
        Size size = Enum.valueOf(Size.class, input);

        System.out.printf("size: %s, abbreviation: %s", size.toString(), size.getAbbriviation() );

    }
}
