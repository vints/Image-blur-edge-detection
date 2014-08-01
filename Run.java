import java.util.Arrays;

public class Run {

    protected int r;
    protected int g;
    protected int b;
    protected int len;

    public Run(int length, int red, int green, int blue) {
        len = length;
        r = red;
        g = green;
        b = blue;
    }

    public String toString() {
        int[] display = {len, r, g, b};
        return "l,r,g,b: " + Arrays.toString(display);
    }
}