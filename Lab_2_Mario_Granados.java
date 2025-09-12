import java.util.Collections;
import java.util.Stack;

public class Lab_2_Mario_Granados {
    public static void main(String[] args) {
        // prepare a program that print characters in a stack

        Stack<Character> stack = new Stack<>();
        Collections.addAll(stack, 'a', 'b', 'c', 'd', 'e');

        ignoreMiddleCharacter(stack);
        stack.clear();

        Collections.addAll(stack, 'f', 'o', 'u', 'r');
        ignoreMiddleCharacter(stack);
        stack.clear();

        Collections.addAll(stack, 's', 'e', 'v', 'e', 'n');
        ignoreMiddleCharacter(stack, true);

        stack.clear();

    }

    public static void ignoreMiddleCharacter(Stack<Character> stack) {
        if (stack.isEmpty()) {
            return;
        }

        System.out.println("original stack: " + stack);

        // used to fidn middle character which will be skipped
        int middleCharacter = stack.size() / 2;

        Stack<Character> tempStack = new Stack<>();

        int count = 0;

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (count == middleCharacter) {
                System.out.println("Skipped: " + c);
            } else {
                tempStack.push(c);
            }
            count++;
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        tempStack.clear();

        System.out.println("Updated Stack: " + stack);
        System.out.println();

    }

    public static void ignoreMiddleCharacter(Stack<Character> stack, boolean doLazyWay) {
        if (stack.isEmpty())
            return;

        int middleCharacter = stack.size() / 2;
        char skipped = stack.remove(middleCharacter);
        System.out.println("Skipped: " + skipped);
        System.out.println(stack);
    }

}