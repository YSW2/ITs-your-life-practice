package org.scoula.ex01.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Getter
@Setter

@Component
public class Parrot {
    String name;

    @PostConstruct
    public void init() {
        this.name = "Kiki";
    }
}
