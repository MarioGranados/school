package Deck;
//Mario Granados
public interface DeckInterface<String> {
    void push(String card);
    String pop();
    boolean isEmpty();
    void shuffle();
}
