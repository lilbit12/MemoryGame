package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class Deck {

    private List<Card> deck;
    private Integer gridSize;

    public Deck(Integer gridSize) {
        this.gridSize = gridSize;
        int capacity = gridSize*gridSize;
        deck = new ArrayList<>(capacity);
    }

    public void setDeck() {
        Card tmp;
        for (int i = 0; i <= gridSize*gridSize; i++) {

            do{
                tmp = new Card();
                deck.add(tmp);
            }
            while (isUnique(deck,tmp) && deck.size()<=i);
                deck.add(tmp);
                deck.add(tmp);
            }
        }



    public void printDeck() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(deck.get(i).getName());
        }
    }

    public boolean isUnique(List<Card> existingCards, Card x) {
        boolean flag = false;

        for (Card card : existingCards) {
            if (!existingCards.isEmpty()) {
                if (x.getName().equals(existingCards)) {
                } else
                    flag = true;
            } else {
                break;
            }
        }
        return flag;
    }
}