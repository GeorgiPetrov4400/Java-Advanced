package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        String currentUrl = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.isEmpty()) {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                } else {
                    currentUrl = browserHistory.pop();
                }
            } else {
                if (!currentUrl.equals("")) {
                    browserHistory.push(currentUrl);
                }
                currentUrl = input;
            }
            System.out.println(currentUrl);

            input = scanner.nextLine();
        }
    }
}
