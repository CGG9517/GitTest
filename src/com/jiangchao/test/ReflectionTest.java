package com.jiangchao.test;

import java.lang.reflect.*;
import java.util.Date;
import java.util.Scanner;

/**
 * @class: ReflectionTest
 * @Description: Reflection Test.
 * @Author: Jiang Chao
 * @Date: 2018/4/30
 */
public class ReflectionTest {
    public static void main(String[] args) {
        // read class name from command line or input
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Enter a class name (e.g. %s)\n", Date.class.getName());
            name = scanner.next();
        }

        try {
            // print class name and superclass name (if != Object)
            Class clss = Class.forName(name);
            Class superclss = clss.getSuperclass(); // 超类
            String modifiers = Modifier.toString(clss.getModifiers()); // 修饰器

            // 打印类，带修饰器
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + clss.getName());

            // 如果有超类，打印超类
            if (!superclss.equals("Object")) System.out.println(" extends " + superclss.getName());

            System.out.print("\n{\n");
            printConstructors(clss);
            System.out.println();
            printMethods(clss);
            System.out.println();
            printFields(clss);
            System.out.println("}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printMethods(Class clss) {
        Method[] methods = clss.getDeclaredMethods();
        for (Method method : methods){
            System.out.print("  ");
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers));
            System.out.print(" " + method.getReturnType().getName());;
            String name = method.getName();
            System.out.print(" " + name + "(");
            Parameter[] parameters = method.getParameters();
            for (int j = 0; j < parameters.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(parameters[j]);
            }
            System.out.println(");");

        }

    }

    /**
     * @Description:
     * @Param: [clss] Class object
     * @return: void
     * @Author: Jiang Chao
     * @Date: 2018/4/30
     * @Version: 1.0
     */
    public static void printConstructors(Class clss){

        Constructor[] declaredConstructors = clss.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors){
            System.out.print("  ");
            int modifiers = constructor.getModifiers();
//            if (modifiers > 0) // 也可以不判断
                System.out.print(Modifier.toString(modifiers));
            String name = constructor.getName();
            System.out.print(" " + name + "(");
            Parameter[] parameters = constructor.getParameters();
            for (int j = 0; j < parameters.length; j++) {
                if (j > 0) System.out.print(", ");
                System.out.print(parameters[j]);
            }
            System.out.println(");");
        }

    }

    /**
     * @Description: print the field
     * @Param: [clss]
     * @return: void
     * @Author: Jiang Chao
     * @Date: 2018/4/30
     * @Version: 1.0
     */

    public static void printFields(Class clss){

        Field[] fields = clss.getDeclaredFields();
        for (Field field : fields){
            System.out.print("  ");
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers));
            String type = field.getType().getName();
            String name = field.getName();
            System.out.print(" " + type + " " + name);
            System.out.println(";");
        }
    }


}
