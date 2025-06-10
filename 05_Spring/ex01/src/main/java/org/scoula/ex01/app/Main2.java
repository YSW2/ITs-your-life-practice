package org.scoula.ex01.app;

import org.scoula.ex01.config.ProjectConfig;
import org.scoula.ex01.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());
    }
}
