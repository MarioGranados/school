package Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Mario Granados
public class Deck implements DeckInterface<String> {
    //const variables
    public final String[] symbols = {"H", "D", "S", "C"};
    public final String[] numbers = {"A", "2", "3", "4", "5", "6", "7","8", "9", "10", "J", "Q", "K"};
    //java says i need this
    public List<String> deck;
    //constructor
    public Deck() {
        deck = new ArrayList<>();
        for(String symbol : symbols){
            for(String number : numbers ) {
                deck.add(number + "" + symbol);
            }
        }

        this.shuffle();
        this.showDeck();
    }
    //override methods
    @Override
    public void push(String card) {
        if (this.deck.size() == 52) {
            System.out.println("Cannot add more cards!");
        } else {
            deck.add(card);

        }

    }

    @Override
    public String pop() {
        if (deck.isEmpty()) {
            return null;
        }
        int lastIndex = deck.size() - 1;
        return deck.remove(lastIndex);
    }

    @Override
    public boolean isEmpty() {
        return deck.isEmpty();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(deck);
        System.out.println("Deck has been shuffled!");
        System.out.println(showDeck());
    }
    //additional methods
    public List<String> showDeck() {
        return new ArrayList<>(this.deck);
    }

    public int cardsRemaining() {
        return deck.size();
    }

}
