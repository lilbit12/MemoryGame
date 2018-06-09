package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.util.List;

public class GameFrame {

    private Integer gridSize;
    private GridPane gridPane;
    protected Label timerLabel = new Label();
    public Integer seconds = 0;
    public Integer minutes = 0;
    public IntegerProperty secondsProp = new SimpleIntegerProperty(seconds);
    private Timeline timeline;
    private BorderPane timePane = new BorderPane();

    public GameFrame(Integer gridSize) {
        Stage newGameFrame = new Stage();
        this.gridSize = gridSize;

        this.gridPane = new GridPane();
        gridPane.setBackground(Background.EMPTY);
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);


        timerLabel.setText(seconds.toString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 3em;-fx-font-family: 'sans-serif';");

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                seconds++;
                                timerLabel.setText(minutes.toString()+":"+seconds.toString());
                                if (seconds>59){
                                    minutes++;
                                    seconds= 0;
                                    timerLabel.setText(minutes.toString()+":"+seconds.toString());
                                }

                            }
                        })
        );
        timeline.playFromStart();

        Deck deck1 = new Deck(gridSize);
        generateGrid(deck1.getDeck());



        /*
        Task time = new Task() {
            @Override
            protected Integer call() throws Exception {
                while (true){
                    Thread.sleep(1000);
                    updateTime();
                    System.out.println(getSeconds());
                    timeLb.setText(getSeconds());
                }
            }
        };

        new Thread(time).start();

        //timeLb.textProperty().bind(secondsProp.asString());
        */
        Scene scene = new Scene(gridPane, 740, 640, Color.rgb(48, 194, 228));
        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();


        }

        public void  updateTime(){
        secondsProp.setValue(++seconds);
        }

        public String getSeconds(){
            return String.valueOf(seconds);
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

        gridPane.getChildren().add(timerLabel);
        GridPane.setConstraints(timerLabel,gridSize%2==0?gridSize/2:1,gridSize+3);





    }
}
