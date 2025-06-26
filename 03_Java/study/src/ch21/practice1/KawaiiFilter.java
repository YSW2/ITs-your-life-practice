package ch21.practice1;

public class KawaiiFilter implements FilterStrategy {
    @Override
    public String apply (String input) {
        StringBuffer str = new StringBuffer(input);
        return str.reverse().toString() + "🌸";
    }
}
