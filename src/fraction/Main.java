package fraction;

import java.util.*;

import static fraction.SimpleFraction.*;

public class Main {
    private static SimpleFraction fractionOperations(SimpleFraction fraction) {
        var scanner = new Scanner(System.in);
        String guide = """
                Fraction operations
                g - see guide
                a - add to this Fraction
                s - subtract from this Fraction
                m - multiply this Fraction
                d - divide this Fraction
                """;
        String prompt = "Enter numerator and denominator for Fraction, " +
                "denominator must be != 0";
        System.out.println(guide);
        while (true) {
            String command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            switch (command) {
                case "g" -> System.out.println(guide);
                case "a" -> {
                    System.out.println(prompt);
                    try {
                        var fractionB = getMyFraction(scanner);
                        System.out.println("created fraction: " + fractionB);
                        return fraction.addFraction(fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return fractionOperations(fraction);
                    }
                }
                case "s" -> {
                    System.out.println(prompt);
                    try {
                        var fractionB = getMyFraction(scanner);
                        return fraction.subtractFraction(fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return fractionOperations(fraction);
                    }
                }
                case "m" -> {
                    System.out.println(prompt);
                    try {
                        var fractionB = getMyFraction(scanner);
                        return fraction.multiplyFraction(fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return fractionOperations(fraction);
                    }
                }
                case "d" -> {
                    System.out.println(prompt);
                    try {
                        var fractionB = getMyFraction(scanner);
                        return fraction.divideFraction(fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return fractionOperations(fraction);
                    }
                }
                default -> {
                    return fractionOperations(fraction);
                }
            }
        }
    }

    private static SimpleFraction staticMethodSelector() {
        var scanner = new Scanner(System.in);
        String guide = """
                Fraction Selector
                g - see guide
                a - add Fractions
                s - subtract Fractions
                m - multiply Fractions
                d - divide Fractions
                e - exit""";
        String prompt = "Enter numerator and denominator for Fraction, " +
                "denominator must be != 0";
        System.out.println(guide);

        while (true) {
            String command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            switch (command) {
                case "g" -> System.out.println(guide);
                case "a" -> {
                    try {
                        System.out.println(prompt);
                        var fractionA = getMyFraction(scanner);
                        System.out.println(prompt);
                        var fractionB = getMyFraction(scanner);
                        return addFractions(fractionA, fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return staticMethodSelector();
                    }
                }
                case "s" -> {
                    try {
                        System.out.println(prompt);
                        var fractionA = getMyFraction(scanner);
                        System.out.println(prompt);
                        var fractionB = getMyFraction(scanner);
                        return subtractFractions(fractionA, fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return staticMethodSelector();
                    }
                }
                case "m" -> {
                    try {
                        System.out.println(prompt);
                        var fractionA = getMyFraction(scanner);
                        System.out.println(prompt);
                        var fractionB = getMyFraction(scanner);
                        return multiplyFractions(fractionA, fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return staticMethodSelector();
                    }
                }
                case "d" -> {
                    try {
                        System.out.println(prompt);
                        var fractionA = getMyFraction(scanner);
                        System.out.println(prompt);
                        var fractionB = getMyFraction(scanner);
                        return divideFractions(fractionA, fractionB);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        return staticMethodSelector();
                    }
                }
                default -> {
                    return staticMethodSelector();
                }
            }
        }
    }

    private static void fractionSelector(List<SimpleFraction> fractionList) {
        var scanner = new Scanner(System.in);
        String guide = """
                Fraction Selector
                g - see guide
                l - see full list
                s - select Fraction from list to operate with
                m - select static method
                e - exit""";
        System.out.println(guide);
        while (true) {
            String command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            switch (command) {
                case "g":
                    System.out.println(guide);
                    break;
                case "l":
                    System.out.println("Actual list of Fractions:");
                    fractionList.forEach(x -> System.out.println(x.toString()));
                    break;
                case "s":
                    System.out.println("Enter number of fraction in list, "
                            + "number must be <= " + (fractionList.size()));
                    var fractionNumber = scanner.nextInt();
                    try {
                        var fraction = fractionList.get(fractionNumber - 1);
                        System.out.println("Your fraction is:\n" + fraction.toString());
                        var newFraction = fractionOperations(fraction);
                        System.out.println("Got:\n" + newFraction.toString());
                        fractionList.add(newFraction);
                        System.out.println(guide);
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
                        System.out.println("number must be <= " + (fractionList.size()));
                        System.out.println("Choose option again");
                    }
                    break;
                case "m":
                    var newFraction = staticMethodSelector();
                    System.out.println("Got:\n" + newFraction.toString());
                    fractionList.add(newFraction);
                    System.out.println(guide);
                    break;
                case "e":
                    return;
                default:
                    break;
            }
        }
    }

    private static void menuSelector(List<SimpleFraction> fractionList) {
        var scanner = new Scanner(System.in);
        String guide = """
                Main menu
                g - see guide
                d - create default SimpleFraction 1/1
                c - create your own SimpleFraction
                l - check all Fractions
                s - select operation with Fraction in list
                e - exit""";
        System.out.println(guide);
        while (true) {
            String command = scanner.nextLine().trim().toLowerCase(Locale.ROOT);
            switch (command) {
                case "g":
                    System.out.println(guide);
                    break;

                case "d":
                    fractionList.add(new SimpleFraction());
                    break;

                case "c":
                    System.out.println("Enter numerator and denominator for your Fraction, " +
                            "denominator must be != 0");
                    try {
                        var fraction = getMyFraction(scanner);
                        fractionList.add(fraction);
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Incorrect fraction, choose option again");
                        continue;
                    }
                    break;

                case "l":
                    System.out.println("Actual list of Fractions:");
                    fractionList.forEach(x -> System.out.println(x.toString()));
                    break;

                case "s":
                    System.out.println("Here we can use operations with our Fractions");
                    fractionSelector(fractionList);
                    System.out.println(guide);
                    break;

                case "e":
                    return;

                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        var fractionList = new ArrayList<SimpleFraction>();
        menuSelector(fractionList);
    }
}
