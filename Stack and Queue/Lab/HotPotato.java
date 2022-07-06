package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int games = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
        while (queue.size() != 1) {
            int count = 0;
            for (int i = 0; i < games; i++) {
                count++;
                if (count == games) {
                    System.out.println("Removed " + queue.peek());
                    queue.poll();
                    break;
                }
                String currentKid = queue.poll();
                queue.offer(currentKid);
            }
        }
        System.out.println("Last is " + queue.poll());
    }
}
