package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.List;

public class GameFrame {

    public static Integer gridSize;
    public GridPane gridPane;
    protected Label timerLabel = new Label();
    public static Integer seconds = 0;
    public static Timeline timeline;
    public static List<Card> deck;
    public static int clicked = 2;
    public static Card selected = null;
    public static int pairsLeft;
    public static double result;



    public GameFrame(Integer gridSize) {
        Stage newGameFrame = new Stage();

        BorderPane mainPane = new BorderPane();

        this.gridSize = gridSize;

        pairsLeft=(gridSize*gridSize)/2;
        System.out.println(pairsLeft);

        this.gridPane = new GridPane();
        gridPane.setBackground(Background.EMPTY);

        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.setAlignment(Pos.CENTER);

        timerLabel.setText(seconds.toString());
        timerLabel.setTextFill(Color.GREEN);
        timerLabel.setStyle("-fx-font-size: 2em;-fx-font-family: 'Arial Narrow'");

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        event -> {
                            seconds++;
                            timerLabel.setText(seconds.toString());
                            }));
        timeline.playFromStart();

        Deck deck1 = new Deck(gridSize);
        deck = deck1.getDeck();
        generateGrid(deck1.getDeck());


        mainPane.setCenter(gridPane);
        mainPane.setBottom(timerLabel);
        mainPane.setBackground(Background.EMPTY);
        BorderPane.setAlignment(timerLabel,Pos.BOTTOM_CENTER);

        Scene scene = new Scene(mainPane, 640, 480, Color.rgb(186,191,195));
        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();
        scene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());

        newGameFrame.setOnCloseRequest( event -> {
            timeline.stop();
            GameFrame.seconds=0;
        });
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
