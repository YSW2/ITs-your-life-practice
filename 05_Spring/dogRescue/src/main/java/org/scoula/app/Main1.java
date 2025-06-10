package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Dog dog1 = context.getBean("꼬미", Dog.class);
        Dog dog2 = context.getBean("밤비", Dog.class);
        Dog dog3 = context.getBean("해피", Dog.class);

        System.out.println("[1] 등록된 강아지 목록: ");
        System.out.printf("[Dog] 이름: %s, 견종: %s\n", dog1.getName(), dog1.getBreed());
        System.out.printf("[Dog] 이름: %s, 견종: %s\n", dog2.getName(), dog2.getBreed());
        System.out.printf("[Dog] 이름: %s, 견종: %s", dog3.getName(), dog3.getBreed());
    }
}
