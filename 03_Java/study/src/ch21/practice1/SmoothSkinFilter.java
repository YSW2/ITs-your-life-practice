package ch21.practice1;

public class SmoothSkinFilter implements FilterStrategy {

    @Override
    public String apply (String input) {
        return input.toLowerCase() + "✨";
    }
}
