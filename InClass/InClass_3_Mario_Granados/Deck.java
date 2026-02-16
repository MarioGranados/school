package InClass.InClass_3_Mario_Granados;

import java.util.Random;


public class Deck implements DeckInterface {

    // private Stack<String> deck = new Stack<>();
    // private List<String> symbols = Arrays.asList("Heart", "Club", "Spades",
    // "Diamond");
    // private List<String> number = new ArrayList<>();

    private String[] deck = new String[52];
    private String[] symbols = { "heart", "Club", "Spades", "Diamond" };
    private int[] numbers = new int[13];

    private int top = -1; //index pointer

    public Deck() {
        for (int c = 0; c < 13; c++) {
            numbers[c] = c + 1;
        }

        for (int j = 0; j < symbols.length; j++) {
            for (int i = 0; i < numbers.length; i++) {
                switch (numbers[i]){
                    case 1:
                        this.push("A " + symbols[j]);
                        break;
                    case 11:
                        this.push("J " + symbols[j]);
                        break;
                    case 12:
                        this.push("Q " + symbols[j]);
                        break;
                    case 13:
                        this.push("K " + symbols[j]);
                        break;
                    default:
                        if (numbers[i] < 11) {
                            this.push(numbers[i] + " " + symbols[j]);
                        }
                        break;
                }

            }
        }
        shuffle(deck);
        showDeck();

    }

    @Override
    public void push(String Card)  {
        if (top == deck.length - 1) {
            throw new RuntimeException("Deck is full! you cannot add more cards, please remove a card first");
        }
        this.top++; // basically just for recording the last index that contains a card. (pointer)
        deck[top] = Card;
    }

    @Override
    public String pop() {
        if(this.isEmpty()) {
            throw new RuntimeException("There are no more card to drawn");
        }
        String card = deck[top];
        deck[top] = null;
        this.top--;
        return card;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;

    }

    @Override
    public void shuffle(String[] deck) {
        Random rand = new Random();
        recurciveShuffle(deck, rand);

    }

    public void recurciveShuffle(String[] deck, Random rand) {
        if (top < 1) {
            return; // if deck is 0
        }

        String topCard = this.pop();; // grab top card from deck;

        recurciveShuffle(deck, rand); // shuffle deck and check if deck is 0

        int position = rand.nextInt(top + 1); // we popped card so size is 51, we are still working with 52 two
                                                      // cards so we have to add +1

        insertAt(deck, topCard, position);
    }

    public void insertAt(String[] deck, String card, int position) {
        if (position == top) {
            this.push(card); // if the position is the top, then we add card in the bottom of the stack
                             // (push)
            return;
        }

        String temp = this.pop();
        insertAt(deck, card, position);
        this.push(temp);
    }

    public void showDeck() {
        for (String card : deck) {
            System.out.println(card);
        }
    }

}
