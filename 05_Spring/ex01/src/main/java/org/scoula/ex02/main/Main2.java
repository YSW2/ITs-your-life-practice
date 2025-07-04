package org.scoula.ex02.main;

import org.scoula.ex02.beans.Person2;
import org.scoula.ex02.config.ProjectConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);
        Person2 p = context.getBean(Person2.class);
        System.out.println("Person's name: " + p.getName());
        System.out.println("Person's parrot: " + p.getParrot());
    }
}