package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Deck {

    protected List<Card> deck;
    private Integer gridSize;
    int numberOfPairs;
    private Random rand = new Random();


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
        char n = (char) (rand.nextInt(25) + 'A');
        for (int i = 0; i < numberOfPairs; i++) {
            deck.add(new Card(String.valueOf(n)));
            deck.add(new Card(String.valueOf(n)));
            n++;
        }

            if (gridSize % 2 == 1) {
                deck.add(new Card(":-)"));
            }
            Collections.shuffle(deck);
        }
    }
