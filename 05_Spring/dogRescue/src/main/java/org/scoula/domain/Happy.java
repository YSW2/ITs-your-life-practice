package org.scoula.domain;

import org.springframework.stereotype.Component;

@Component("해피")
public class Happy extends Dog {
    public Happy() {
        name = "해피";
        breed = "진돗개";
    }
}
