package org.scoula.ex01.app;

import org.scoula.ex01.config.ProjectConfig3;
import org.scoula.ex01.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p);
        System.out.println(p.getName());
    }
}