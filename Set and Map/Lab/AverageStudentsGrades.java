package SetsAndMapsAdvancedLab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentInfo = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String studentName = input[0];
            double studentGrade = Double.parseDouble(input[1]);
            if (studentInfo.containsKey(studentName)) {
                studentInfo.get(studentName).add(studentGrade);
            } else {
                studentInfo.put(studentName, new ArrayList<>());
                studentInfo.get(studentName).add(studentGrade);
            }
        }
        for (Map.Entry<String, List<Double>> entry : studentInfo.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double sum = 0.0;
            int count = 0;
            for (var value : studentInfo.get(entry.getKey())) {
                sum += value;
                count++;
                System.out.printf("%.2f ", value);
            }
            double averageGrade = sum / count;
            System.out.printf("(avg: %.2f)%n", averageGrade);
        }
    }
}
