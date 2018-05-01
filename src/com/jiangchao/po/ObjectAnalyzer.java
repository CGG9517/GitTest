package com.jiangchao.po;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * @class: ObjectAnalyzer
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/1
 */
public class ObjectAnalyzer {
    ArrayList<Object> visited = new ArrayList<>();

    /**
     * @Description: Converts an object to a string representation that lists all fields.
     * @Param: [obj] an object.
     * @return: java.lang.String
     * @Author: Jiang Chao
     * @Date: 2018/5/1
     * @Version: 1.0
     */
    public String toString(Object obj){

        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);

        Class clss = obj.getClass();
        if (clss == String.class) return (String) obj;
        if (clss.isArray()){
            String r = clss.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++)
            {
                if (i > 0) r += ", ";
                Object val = Array.get(obj, i);
                if (clss.getComponentType().isPrimitive()) r += val;  // 简单类型直接添加
                else r += toString(val);
            }
            return r + "}";
        }


        String r = clss.getName();
        // inspect the fields of class and superclass.
        do {
            r += "[";
            Field[] fields = clss.getDeclaredFields(); // 本类所有声明域
            AccessibleObject.setAccessible(fields, true);

            for (Field f : fields)
                if (!Modifier.isStatic(f.getModifiers()))
                {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";

                    Class t = f.getType();
                    try {
                        Object val = f.get(obj); // 返回obj对象中用Field对象表示的域值
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            r += "]";
            clss = clss.getSuperclass(); // 超类

        }
        while (clss != null);


        return r;

    }
}
