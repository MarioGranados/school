package InClass.InClass_3_Mario_Granados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class Deck implements DeckInterface {

    private Stack<String> deck = new Stack();
    private List<String> symbols = Arrays.asList("Heart", "Club", "Spades", "Diamond");
    private List<String> number = new ArrayList<>();

    public Deck() {
        for (int c = 1; c <= 13; c++) {
            number.add(Integer.toString(c));
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 1; i < 13; i++) {
                if (i < 11 && i != 1) {
                    deck.push(number.get(i) + " " + symbols.get(j));
                } else {
                    switch (number.get(i)) {
                        case "1":
                            deck.push("A " + symbols.get(j));
                            break;
                        case "11":
                            deck.push("J " + symbols.get(j));
                            break;
                        case "12":
                            deck.push("Q " + symbols.get(j));
                            break;
                        case "13":
                            deck.push("K " + symbols.get(j));
                            break;
                        default:
                            break;
                    }
                }
            }
        }

        showDeck();

    }

    @Override
    public void push(String Card) {

    }

    @Override
    public String pop() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        if (deck.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void shuffle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shuffle'");
    }

    @Override
    public boolean isEmpty(List<String> deck) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    public void showDeck() {
        int count = deck.size() - 1;
        while (count > 0) {
            System.out.println(deck.get(count));
            count--;
        }
    }

    public void shuffleDeck() {

    }

}
