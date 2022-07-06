package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Double>> shopProductPrice = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] data = input.split(", ");
            String shop = data[0];
            String product = data[1];
            double productPrice = Double.parseDouble(data[2]);
            if (shopProductPrice.containsKey(shop)) {
                if (shopProductPrice.get(shop).containsKey(product)) {
                    input = scanner.nextLine();
                    continue;
                } else {
                    shopProductPrice.get(shop).put(product, productPrice);
                }
            } else {
                shopProductPrice.put(shop, new LinkedHashMap<>());
                shopProductPrice.get(shop).put(product, productPrice);
            }

            input = scanner.nextLine();
        }
        for (var entry : shopProductPrice.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (var value : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", value.getKey(), value.getValue());
            }
        }
    }
}
