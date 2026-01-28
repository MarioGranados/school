package InClass.InClass_2_Mario_Granados;

import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> word = new Stack<>();
        Collections.addAll(word, 'f', 'o', 'u', 'r');

        System.out.printf("Array of characters named word: %s%n", word);

        Stack<Character> stack = new Stack<>();
        System.out.printf("Empty stack: %s%n%n", stack);

        while (!word.isEmpty()) {
            char c = word.pop();
            System.out.printf("Array of characters: %s%n", word);

            stack.push(c);
            System.out.printf("Computer stack: %s%n%n", stack);
        }

        System.out.printf("Array of characters named word: %s%n", word);

        System.out.printf("Empty stack: %s%n%n", stack);

        while (!stack.isEmpty()) {
            char c = stack.pop();
            System.out.printf("Computer stack: %s%n%n", stack);

            word.push(c);
            System.out.printf("Array of characters: %s%n", word);

        }

        System.out.printf("Array of characters we started with: %s%n", word);
        System.out.printf("Computer stack memory: %s%n", stack);
    }
}
