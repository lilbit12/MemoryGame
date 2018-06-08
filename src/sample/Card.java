package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;

import java.util.Random;

public class Card extends Button {

    public String getName() {
        return name;
    }

    private String name;
    private Random rand = new Random();

    public Card(){
        char n = (char) (rand.nextInt(25) + 'A');
        name = String.valueOf(n);
        this.setText(name);
        setInitCardStyle(this);

        this.setOnAction(event -> setStyle("-fx-text-fill: #000000; "));

    }

    public void setName(String name) {
        this.name = name;
    }

    public Card(String str){
        this.name = str;
        this.setText(name);
        setInitCardStyle(this);
        this.setOnAction(event -> setStyle("-fx-text-fill: #000000; "));
    }

    public void setInitCardStyle(Card card){
        //card.setStyle("-fx-text-fill: transparent; ");
        card.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#ffd65b, #e68400),\n" +
                "        linear-gradient(#ffef84, #f2ba44),\n" +
                "        linear-gradient(#ffea6a, #efaa22),\n" +
                "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
                "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 14px;\n" +
                "    -fx-padding: 10 20 10 20; -fx-text-fill: transparent; ");
        card.setPrefSize(50,50);
    }

}
