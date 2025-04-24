package ch12.sec03.practice;

import java.util.Objects;

public class FemaleCelebrity implements Celebrity {
    private String name;

    public FemaleCelebrity (String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public boolean equals (Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FemaleCelebrity that = (FemaleCelebrity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(name);
    }

    @Override
    public String toString () {
        return "여자 연예인: [" + getName() + "]";
    }

}
