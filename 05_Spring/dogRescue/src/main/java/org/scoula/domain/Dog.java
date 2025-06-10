package org.scoula.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Dog {
    String name;
    String breed;

    @Override
    public String toString() {
        return "[" + breed + "] " + name;
    }
}
