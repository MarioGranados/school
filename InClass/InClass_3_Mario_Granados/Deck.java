package InClass.InClass_3_Mario_Granados;

import java.util.ArrayList;
import java.util.List;

public class Deck implements DeckInterface{

    public List<String> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        for(int i= 0; i < 13; i++){
            
        }
    }


    @Override
    public void push(String Card) {
        
    }

    @Override
    public String pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public void shuffle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shuffle'");
    }
    
}
