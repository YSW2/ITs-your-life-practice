package org.scoula.ex02.main;

import org.scoula.ex02.beans.Parrot;
import org.scoula.ex02.beans.Person;
import org.scoula.ex02.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        System.out.println(parrot.getName());
        System.out.println(person.getName());
        System.out.println(person.getParrot());
    }
}
