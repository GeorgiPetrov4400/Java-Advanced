package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int games = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < games; i++) {
                String currentKid = queue.poll();
                queue.offer(currentKid);
            }
            if (forRemove(cycle)) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Prime " + queue.peek());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean forRemove(int cycle) {
        if (cycle == 1 || cycle == 4) {
            return true;
        }
        if (cycle > 5 && (cycle % 2 == 0 || cycle % 3 == 0 || cycle % 5 == 0)) {
            return true;
        }
        return false;
    }
}

