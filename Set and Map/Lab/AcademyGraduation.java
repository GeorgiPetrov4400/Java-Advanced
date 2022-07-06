package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> studentInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] inputGrade = scanner.nextLine().split("\\s+");
            Double[] grade = new Double[inputGrade.length];

            for (int j = 0; j < grade.length; j++) {
                grade[j] = Double.parseDouble(inputGrade[j]);
            }
            studentInfo.put(name, grade);
        }
        for (var entry : studentInfo.entrySet()) {
            double sum = 0.0;
            for (var value : entry.getValue()) {
                sum += value;
            }
            System.out.printf("%s is graduated with %s%n", entry.getKey(), sum / entry.getValue().length);
        }
    }
}
