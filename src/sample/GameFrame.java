package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class GameFrame {

    private Integer gridSize;
    private GridPane gridPane;

    public GameFrame(Integer gridSize) {
        Stage newGameFrame = new Stage();
        this.gridSize = gridSize;



        this.gridPane = new GridPane();

        gridPane.setVgap(20);
        gridPane.setHgap(20);


        Deck deck1 = new Deck(gridSize);


        int licznik = 0;
        Card tmp;
        for (int row = 0; row < gridSize; row++) {
            for (int column = 0; column < gridSize; column++) {
                tmp = deck1.getDeck().get(licznik);
                gridPane.add(tmp, row, column);
                licznik++;
            }


            Scene scene = new Scene(gridPane, 740, 640, Color.rgb(48, 194, 228));
            newGameFrame.setTitle("New Game");
            newGameFrame.setScene(scene);
            newGameFrame.show();
        }
    }

    public void generateGrid(List<Card> deck){
        int licznik = 0;
        Card tmp;
        for (int row = 0; row < gridSize ; row++) {
            for (int column = 0; column < gridSize ; column++) {
                tmp = deck.get(licznik);
                gridPane.add(tmp,row,column);
                licznik++;
            }
        }
    }
}
