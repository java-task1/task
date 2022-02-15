package fraction;

import java.util.*;

import static fraction.SimpleFraction.*;

public class Main {
    public static void main(String[] args) {
        SimpleFraction a = new SimpleFraction(1,5);
        SimpleFraction b = new SimpleFraction(10, 40);
        SimpleFraction c = new SimpleFraction(30, 3);
        SimpleFraction d = new SimpleFraction(1, 2);
        SimpleFraction e = new SimpleFraction(2, 1);

        SimpleFraction example1 = addFractions(a, b);
        System.out.println(example1);

        SimpleFraction example2 = subtractFractions(c, a);
        System.out.println(example2);

        SimpleFraction example3 = multiplyFractions(a, c);
        System.out.println(example3);

        SimpleFraction example4 = divideFractions(d, e);
        System.out.println(example4);

        System.out.println();

        SimpleFraction example5 = a.addFraction(b);
        System.out.println(example5);

        SimpleFraction example6 = c.subtractFraction(a);
        System.out.println(example6);

        SimpleFraction example7 = a.multiplyFraction(c);
        System.out.println(example7);

        SimpleFraction example8 = d.divideFraction(e);
        System.out.println(example8);
    }
}
