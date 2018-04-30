package com.jiangchao.test;

import com.jiangchao.po.Employee;
import com.jiangchao.po.Person;
import com.jiangchao.po.Student;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];
        people[0] = new Student("Mario Morris", "Computer Science");
        people[1] = new Employee("Harry Cracker", 50000, 1994, 4, 20);

        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDesciption());
    }
}
