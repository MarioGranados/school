package InClass.InClass_3_Mario_Granados;

import java.util.List;

public interface DeckInterface {
    public void push(String Card);

    public String pop();

    public boolean isEmpty();

    public void shuffle();

    boolean isEmpty(List<String> deck);

}