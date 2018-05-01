package com.jiangchao.test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @class: CopyOfTest
 * @Description: use of Reflection of arrays.
 * @Author: Jiang Chao
 * @Date: 2018/5/1
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));


        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate a exception: ");
        b = (String[]) badCopyOf(b, 10);
    }
    /**
     * @Description:
     * @Param: [a, i] a is the origin array to copy, i is the length of new array.
     * @return: java.lang.Object
     * @Author: Jiang Chao
     * @Date: 2018/5/1
     * @Version: 1.0
     */
    private static Object goodCopyOf(Object a, int newLength) {
        Class clss = a.getClass();
        if (!clss.isArray()) return null;

        Class componentType = clss.getComponentType();
        int originLength = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(originLength, newLength));
        return newArray;
    }
    /**
     * @Description: 生成的数字为Object[], 因此强制转换类型会报错
     * @Param: [a, newLength]
     * @return: java.lang.Object[]
     * @Author: Jiang Chao
     * @Date: 2018/5/1
     * @Version: 1.0
     */
    private static Object[] badCopyOf(Object a, int newLength) {
        int originLength = Array.getLength(a);
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(originLength, newLength));
        return newArray;
    }
}
