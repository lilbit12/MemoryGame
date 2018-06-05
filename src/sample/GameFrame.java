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

public class GameFrame {

    private Integer gridSize;
    private GridPane gridPane;

    public GameFrame(Integer gridSize){

        this.gridSize = gridSize;

        Stage newGameFrame = new Stage();

        this.gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25,25,25,25));


        /*
        Card cd1 = new Card();
        Card cd2 = new Card();

        */
        Deck deck1 = new Deck(gridSize);
        deck1.setDeck();
        deck1.printDeck();


        generateGrid();


        Scene scene = new Scene(gridPane,640,480, Color.rgb(48, 194, 228));
        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();

    }

    public void generateGrid(){
        for (int row = 0; row <= gridSize ; row++) {
            for (int column = 0; column <= gridSize ; column++) {
                gridPane.add(new Card(),row,column);
            }
        }
    }
}
