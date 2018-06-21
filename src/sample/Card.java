package sample;



import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.Button;


import java.util.Random;

public class Card extends Button {

    public String getName() {
        return name;
    }

    private String name;
    private Random rand = new Random();

    public boolean getSelected() {
        return selected.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }


    private BooleanProperty selected = new SimpleBooleanProperty();

    public void setSelected(Boolean flag) {
        selected.set(flag);
    }


    public Card() {
        this.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());
        setSelected(false);
        char n = (char) (rand.nextInt(25) + 'A');
        name = String.valueOf(n);
        this.setText(name);
        this.setPrefSize(50,50);

        this.setId("button-start");


        this.setOnMouseClicked(event -> {
            setClickedStyle();
            GameFrame.incrementChosenCount();
            System.out.println(GameFrame.chosenCount);
        });
    }



    public Card(String str) {
        this.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());
        setSelected(false);
        this.name = str;
        this.setText(name);
        this.setId("button-start");
        this.setPrefSize(50,50);


        this.setOnMouseClicked(event -> {
            setClickedStyle();
            GameFrame.incrementChosenCount();
            System.out.println(GameFrame.chosenCount);
        });
    }

    public void setHide(){
        this.setId("button-start");
    }

    public void setClickedStyle(){
        this.setId("button-clicked");
        setSelected(true);
    }

}
