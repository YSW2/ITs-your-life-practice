package org.scoula.ex02.config;

import org.scoula.ex02.beans.Parrot;
import org.scoula.ex02.beans.Person;
import org.springframework.context.annotation.Bean;

public class ProjectConfig {
    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    Person person() {
        var p = new Person();
        p.setName("Ella");
        p.setParrot(parrot());
        return p;
    }
}
