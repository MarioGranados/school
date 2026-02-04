package InClass.InClass_2_Mario_Granados.Lab2;

import java.util.Collections;
import java.util.Stack;

public class main {

    public static Stack<Character> removeMiddleCharacter(Stack<Character> array) {
        if (array.isEmpty())
            System.out.println("array is empty");
        Stack<Character> memoryStack = new Stack<>();
        int middle = array.size() / 2;

        int count = 0;

        while (!array.isEmpty()) {
            if (count == middle) {
                array.pop();
            } else {
                memoryStack.push(array.pop());
            }
            count++;
        }

        while (!memoryStack.isEmpty()) {
            array.push(memoryStack.pop());
        }
        memoryStack.empty();
        return array;

    }

    public static void main(String[] args) {
        Stack<Character> array = new Stack<>();
        Collections.addAll(array, 'f', 'o', 'u', 'r');

        Stack<Character> array2 = new Stack<>();
        Collections.addAll(array2, 's', 'e', 'v', 'e', 'n');

        Stack<Character> array3 = new Stack<>();
        Collections.addAll(array3, 'f', 'l', 'o', 'w', 'e', 'r');

        System.out.println("current arrays");
        System.out.println(array);
        System.out.println(array2);
        System.out.println(array3);

        array = removeMiddleCharacter(array);

        array2 = removeMiddleCharacter(array2);
        array3 = removeMiddleCharacter(array3);

        System.out.println("after removing middle or left from middle");
        System.out.println(array);
        System.out.println(array2);
        System.out.println(array3);

    }
}
