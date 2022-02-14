package fraction;

import java.util.Scanner;

public class SimpleFraction {
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

    public static SimpleFraction getMyFraction(Scanner scanner) {
        System.out.println("Enter numerator:");
        var numerator = scanner.nextDouble();
        System.out.println("Enter denominator:");
        var denominator = scanner.nextDouble();
        return new SimpleFraction(numerator, denominator);
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
