package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;

import java.util.Random;

public class Card extends Button {

    private String name;
    private Random rand = new Random();

    public Card(){
        char n = (char) (rand.nextInt(25) + 'A');
        name = String.valueOf(n);
        this.setText(name);
        this.setStyle("-fx-text-fill: transparent; ");

        this.setOnAction(event -> setStyle("-fx-text-fill: #000000; "));
    }

    public Card(String str){
        this.name = str;
        this.setText(name);
    }

}
