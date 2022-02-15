package fraction;

import static fraction.SimpleFraction.*;

class SimpleFraction {
    private double numerator = 1;
    private double denominator = 1;

    public SimpleFraction() {

    }

    public SimpleFraction(double numerator, double denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Fraction needs denominator != 0");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public static SimpleFraction addFractions(SimpleFraction a, SimpleFraction b) {
        return new SimpleFraction(a.numerator * b.denominator + b.numerator * a.denominator,
                a.denominator * b.denominator);
    }

    public static SimpleFraction multiplyFractions(SimpleFraction a, SimpleFraction b) {
        return new SimpleFraction(a.numerator * b.numerator, a.denominator * b.denominator);
    }

    public static SimpleFraction divideFractions(SimpleFraction a, SimpleFraction b) {
        return new SimpleFraction(a.numerator * b.denominator, a.denominator * b.numerator);
    }

    public static SimpleFraction subtractFractions(SimpleFraction a, SimpleFraction b) {
        return new SimpleFraction(a.numerator * b.denominator - b.numerator * a.denominator,
                a.denominator * b.denominator);
    }

    public SimpleFraction addFraction(SimpleFraction b) {
        return new SimpleFraction(this.numerator * b.denominator + b.numerator * this.denominator,
                this.denominator * b.denominator);
    }

    public SimpleFraction multiplyFraction(SimpleFraction b) {
        return new SimpleFraction(this.numerator * b.numerator, this.denominator * b.denominator);
    }

    public SimpleFraction divideFraction(SimpleFraction b) {
        return new SimpleFraction(this.numerator * b.denominator, this.denominator * b.numerator);
    }

    public SimpleFraction subtractFraction(SimpleFraction b) {
        return new SimpleFraction(this.numerator * b.denominator - b.numerator * this.denominator,
                this.denominator * b.denominator);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}


public class Main {
    public static void main(String[] args) {
        SimpleFraction a = new SimpleFraction(1,5);
        SimpleFraction b = new SimpleFraction(10, 40);
        SimpleFraction c = new SimpleFraction(30, 3);
        SimpleFraction d = new SimpleFraction(1, 2);
        SimpleFraction e = new SimpleFraction(2, 1);
        SimpleFraction f = new SimpleFraction();

        SimpleFraction example0 = addFractions(f, f);
        System.out.println(example0);

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
