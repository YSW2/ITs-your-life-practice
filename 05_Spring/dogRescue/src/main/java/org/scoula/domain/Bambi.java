package org.scoula.domain;

import org.springframework.stereotype.Component;

@Component("밤비")
public class Bambi extends Dog {
    public Bambi() {
        name = "밤비";
        breed = "시바견";
    }
}
