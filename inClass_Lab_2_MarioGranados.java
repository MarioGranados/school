import java.util.Collections;
import java.util.Stack;

public class inClass_Lab_2_MarioGranados {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Collections.addAll(stack, 'a', 'b', 'c', 'd', 'e');

        Stack<Character> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        System.out.println("Reversed Stack: " + tempStack);

        for(char c : tempStack) {
            stack.push(c);
        }
        tempStack.clear();

        System.out.println("Original Stack: " + stack);
        System.out.println("Reversed Stack: after calling clear() method" + tempStack);


    }
    
}
