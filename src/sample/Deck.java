package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

    protected List<Card> deck;
    private Integer gridSize;
    int numberOfPairs;

    public Deck(Integer gridSize) {
        this.gridSize = gridSize;
        int capacity = gridSize * gridSize;
        deck = new ArrayList<>();

        numberOfPairs = capacity / 2;

        generateDeck(numberOfPairs);
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void generateDeck(int numberOfPairs) {
        Card tmp, tmp1;
        for (int i = 0; i < numberOfPairs; i++) {
            tmp = new Card();
            boolean cardIsAdded = false;

            while (!cardIsAdded) {
                if (isUnique(tmp, deck)) {
                    deck.add(tmp);
                    tmp1 = new Card(tmp.getName());
                    deck.add(tmp1);
                    cardIsAdded = true;
                } else {
                    System.out.println("Karta " + tmp.getName() + " już występuje.");
                    tmp = new Card();
                    cardIsAdded = false;
                }
            }
        }

            if (gridSize % 2 == 1) {
                deck.add(new Card(":-)"));
            }

            Collections.shuffle(deck);
        }



    public static boolean isUnique(Card card, List<Card> deck) {
        boolean znacznik = true;

        for (int i = 0; i < deck.size() ; i++) {
            if (card.getName().equals(deck.get(i).getName())){
                znacznik = false;
                break;
            } else {
                znacznik = true;
            }
        }
        return znacznik;
    }


}