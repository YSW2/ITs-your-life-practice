package ch12.sec03.practice;

public class MaleCelebrity implements Celebrity {
    private String name;

    public MaleCelebrity (String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return this.name;
    }

    @Override
    public boolean equals (Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MaleCelebrity that = (MaleCelebrity) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode () {
        return name.hashCode();
    }

    @Override
    public String toString () {
        return "남자 연예인: [" + getName() + "]";
    }
}
