package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameFrame {

    private Integer gridSize;
    private GridPane gridPane;
    protected Label timerLabel = new Label();
    public Integer seconds = 0;
    public Integer minutes = 0;
    private Timeline timeline;
    public static List<Card> deck;
    public static List<Card> clicked;

    public static int getChosenCount() {
        return chosenCount.get();
    }

    public static IntegerProperty chosenCountProperty() {
        return chosenCount;
    }

    public static void setChosenCount(int chosenCount) {
        GameFrame.chosenCount.set(chosenCount);
    }
    public static void incrementChosenCount(){
        chosenCount.set(getChosenCount()+1);
    }

    public static IntegerProperty chosenCount;



    public GameFrame(Integer gridSize) {
        Stage newGameFrame = new Stage();


        chosenCount = new SimpleIntegerProperty();
        clicked = new ArrayList<>();

        chosenCountProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (getChosenCount() == 2){
                    compareSelected();
                } else {
                    System.out.println("jedna karta wybrana");
                }
            }
        });

        BorderPane mainPane = new BorderPane();

        this.gridSize = gridSize;

        this.gridPane = new GridPane();
        gridPane.setBackground(Background.EMPTY);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);


        timerLabel.setText(seconds.toString());
        timerLabel.setTextFill(Color.GREEN);
        timerLabel.setStyle("-fx-font-size: 3em;-fx-font-family: 'sans-serif';");

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        event -> {
                            seconds++;
                            timerLabel.setText(minutes.toString()+":"+seconds.toString());
                            if (seconds>59){
                                minutes++;
                                seconds= 0;
                                timerLabel.setText(minutes.toString()+":"+seconds.toString());
                            }

                        })
        );
        timeline.playFromStart();

        Deck deck1 = new Deck(gridSize);
        deck = deck1.getDeck();
        generateGrid(deck1.getDeck());


        mainPane.setCenter(gridPane);
        mainPane.setBottom(timerLabel);
        mainPane.setBackground(Background.EMPTY);
        BorderPane.setAlignment(timerLabel,Pos.BOTTOM_CENTER);





        Scene scene = new Scene(mainPane, 640, 480, Color.rgb(48, 194, 228));
        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();
        scene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());

        }

    public void compareSelected(){
        Card tmp1 = null;
        Card tmp2 = null;
        for (int i = 0; i < GameFrame.deck.size() && tmp1 == null ; i++) {
            if (GameFrame.deck.get(i).getSelected()) {
                tmp1 = GameFrame.deck.get(i);
                for (int j = i + 1; j < GameFrame.deck.size(); j++) {
                    if (GameFrame.deck.get(j).getSelected()) {
                        tmp2 = GameFrame.deck.get(j);
                        break;
                    }
                }
            }
        }

        if (tmp1.getName().equals(tmp2.getName())){
            System.out.println("Zgadzają się");
            tmp1.setClickedStyle();
            tmp2.setClickedStyle();
            GameFrame.setChosenCount(0);

        } else {
            System.out.println("Nie zgadzają się");
            tmp1.setSelected(false);
            tmp2.setSelected(false);

            GameFrame.setChosenCount(0);

            tmp1.setHide();
            tmp2.setHide();
        }
    }



    public  void setInitCardStyle(Card x){
        x.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#ffd65b, #e68400),\n" +
                "        linear-gradient(#ffef84, #f2ba44),\n" +
                "        linear-gradient(#ffea6a, #efaa22),\n" +
                "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n" +
                "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,2,3,0;\n" +
                "    -fx-text-fill: #654b00;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-padding: 10 20 10 20;" +
                "    -fx-text-fill: transparent;");
        x.setPrefSize(70,70);
    }


    public void generateGrid(List<Card> deck){
        int licznik = 0;
        Card tmp;

        for (int row = 0; row < gridSize ; row++) {
            for (int column = 0; column < gridSize ; column++) {
                tmp = deck.get(licznik);
                gridPane.getChildren().add(tmp);
                GridPane.setConstraints(tmp,row,column);
                licznik++;
            }
        }
    }
}
