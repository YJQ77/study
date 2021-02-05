package com.example.basic.optional;

import io.netty.resolver.HostsFileEntries;

/**
 * Author: YinJiaqi
 * Date: 11/16/2020 5:14 PM
 * Content:
 */
public class Main {
    public static void main(String[] args) {
        StudentDTO student = new Student(1,"yinjiaqi");
//        String yinjiaqi = Optional.ofNullable(student).
//        System.out.println(yinjiaqi);


//        GenericClassTest test = new GenericClassTest(student);
//        System.out.println(test.isNow());
//        GenericClassTest test2 = new GenericClassTest(student2);
//        System.out.println(test2.isNow());
        Homework homework = new Homework(111,"kexue");
        StudentDTO stu = GenericMethodTest.method(student);
        stu.setName("shenyiding");
        Homework home = GenericMethodTest.method(homework);
        home.setHomeworkName("yuwen");
        System.out.println(stu);
        System.out.println(home);
    }
}
