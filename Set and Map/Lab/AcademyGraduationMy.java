package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduationMy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            double sumGrade = 0.0;
            for (int j = 0; j < input.length; j++) {
                double grade = input[j];
                sumGrade += grade;
            }
            double averageGrade = sumGrade / input.length;
            studentInfo.put(name, averageGrade);
        }
        for (Map.Entry<String, Double> entry : studentInfo.entrySet()) {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), entry.getValue());
        }
    }
}
