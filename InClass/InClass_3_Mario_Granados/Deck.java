package InClass.InClass_3_Mario_Granados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Deck implements DeckInterface {

    private Stack<String> deck = new Stack<>();
    private List<String> symbols = Arrays.asList("Heart", "Club", "Spades", "Diamond");
    private List<String> number = new ArrayList<>();

    public Deck() {
        for (int c = 1; c <= 13; c++) {
            number.add(Integer.toString(c));
        }


        for (int j = 0; j < symbols.size(); j++) {

            for (int i = 0; i < number.size(); i++) {
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
                        if (i < 11) {
                            deck.push(number.get(i) + " " + symbols.get(j));
                        }
                        break;

                }
            }
        }
        shuffle(deck);
        showDeck();

    }

    @Override
    public void push(String Card) {
        deck.push(Card);
    }

    @Override
    public String pop() {
        if(!deck.isEmpty()) {
        return deck.pop();
        } else {
            throw new Error ("There are no more cards in the deck");
        }
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
    public void shuffle(Stack<String> deck) {
        Random rand = new Random();
        recurciveShuffle(deck, rand);

    }

    public void recurciveShuffle(Stack<String> deck, Random rand) {
        if (deck.size() <= 1) {
            return; // if deck is 0
        }

        String topCard = deck.pop(); // grab top card from deck;

        recurciveShuffle(deck, rand); // shuffle deck and check if deck is 0

        int position = rand.nextInt(deck.size() + 1); // we popped card so size is 51, we are still working with 52 two cards so we have to add +1

        insertAt(deck, topCard, position);
    }

    public void insertAt(Stack<String> deck, String card, int position) {
        if (position == deck.size()) {
            deck.push(card); //if the position is the top, then we add card in the bottom of the stack (push)
            return;
        }

        String temp = deck.pop();
        insertAt(deck, card, position);
        deck.push(temp);
    }

    public void showDeck() {
        System.out.println(deck);
    }



}
