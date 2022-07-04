package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<Double> printPrice = p -> System.out.printf("%.2f%n", p);

        UnaryOperator<Double> addVat = price -> price * 1.20;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(printPrice);
    }
}
