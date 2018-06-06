package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Deck {

    private List<Card> deck;
    private Integer gridSize;
    int numberOfPairs;

    public Deck(Integer gridSize) {
        this.gridSize = gridSize;
        int capacity = gridSize*gridSize;
        deck = new ArrayList<>();

        numberOfPairs = capacity/2;

        generateDeck(numberOfPairs);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void generateDeck(int numberOfPairs){
        Card tmp;
        for (int i = 0; i < numberOfPairs ; i++) {
            tmp = new Card();
            if (!(deck.contains(tmp))){
                deck.add(tmp);
                deck.add(tmp);
            }
        }
        if (gridSize%2==1){
            deck.add(new Card(":-)"));
        }
        Collections.shuffle(deck);
    }

}