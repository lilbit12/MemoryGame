package sample;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class GameFrame {

    private Integer gridSize;
    private GridPane gridPane;
    private Label timeLb;

    public GameFrame(Integer gridSize) {
        Stage newGameFrame = new Stage();
        this.gridSize = gridSize;

        this.gridPane = new GridPane();
        //gridPane.setBackground(Background.EMPTY);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);


        Deck deck1 = new Deck(gridSize);
        generateGrid(deck1.getDeck());



        Scene scene = new Scene(gridPane, 740, 640, Color.rgb(48, 194, 228));
        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();


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

        timeLb = new Label();
        Time time1 = new Time(timeLb);
        time1.startTimer(0);


        gridPane.getChildren().add(timeLb);
        GridPane.setConstraints(timeLb,gridSize/2,gridSize+1);
    }
}
