package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade75 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browserHistoryBackCommand = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryForwardCommand = new ArrayDeque<>();

        String currentUrl = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistoryBackCommand.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    String nextURL = currentUrl;
                    browserHistoryForwardCommand.offer(nextURL);
                    currentUrl = browserHistoryBackCommand.pollLast();
                }
            } else if (input.equals("forward")) {
                if (browserHistoryForwardCommand.isEmpty()) {
                    System.out.println("no next URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = browserHistoryForwardCommand.pollLast();
                }

            } else {
                if (!currentUrl.equals("")) {
                    browserHistoryBackCommand.offer(currentUrl);
                }
                currentUrl = input;
            }
            System.out.println(currentUrl);

            input = scanner.nextLine();
        }
    }
}