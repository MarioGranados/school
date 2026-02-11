package InClass.Lab_4_Mario_Granados;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Enter a task or enter -1 to stop");
            input = scanner.nextLine();
            if (input.equals("-1")) {
                break;
            }
            stack.add(input);
        } while (true);

        System.out.println("Currrent queue");
        System.out.println(stack);

        while (!stack.isEmpty()) {
            String taskName = stack.poll();
            System.out.println("compleeting task: " + taskName + " hit enter to continue");
            input = scanner.nextLine();
            System.out.println("finishing task, hit enter to continue");
            input = scanner.nextLine();
            System.out.println("Task is done!");
            System.out.println("Remaining tasks " + stack);
        }
    }
}
