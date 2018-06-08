package sample;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
    protected Label timeLb;
    protected MemoryTimer timer;

    public GameFrame(Integer gridSize) {
        Stage newGameFrame = new Stage();
        this.gridSize = gridSize;
        timeLb = new Label();

        this.gridPane = new GridPane();
        //gridPane.setBackground(Background.EMPTY);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        timeLb = new Label();

        Deck deck1 = new Deck(gridSize);
        generateGrid(deck1.getDeck());
        timer = new MemoryTimer(timeLb);




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
        gridPane.getChildren().add(timeLb);
        GridPane.setConstraints(timeLb,gridSize/2,gridSize+1);
    }
}
