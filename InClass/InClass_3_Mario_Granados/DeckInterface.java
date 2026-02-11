package InClass.InClass_3_Mario_Granados;

import java.util.Stack;

public interface DeckInterface {
    public void push(String Card);

    public String pop();

    public boolean isEmpty();

    public void shuffle(Stack<String> deck); // added deck to try to do recursive shuffle


}