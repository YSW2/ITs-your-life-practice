package org.scoula.service;

import org.scoula.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;

@Component
public class RescueCenter {
    @Autowired
    List<Dog> dogList;


    @PostConstruct
    void init() {
        dogList.sort(Comparator.comparing(dog -> dog.getBreed()));
        for (Dog dog : dogList) {
            System.out.println("안아줌 완료: " + dog.toString());
        }
    }
}
