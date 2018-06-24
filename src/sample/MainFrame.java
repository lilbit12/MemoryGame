package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainFrame extends Application {

    private Stage mainFrame;
    private Button playBt;
    private Button highScoreBt;
    private Button exitBt;
    public static ObservableList<String> scores = FXCollections.observableArrayList();


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        mainFrame = primaryStage;
        primaryStage.setTitle("Memory game");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.setBackground(Background.EMPTY);


        playBt = new Button("New Game");
        highScoreBt = new Button("High score");
        exitBt = new Button("Exit");
        playBt.setMaxWidth(Double.MAX_VALUE);
        highScoreBt.setMaxWidth(Double.MAX_VALUE);
        exitBt.setMaxWidth(Double.MAX_VALUE);


        highScoreBt.setOnMouseClicked(event -> {
            showScores(primaryStage);
        });


        VBox gameMenu = new VBox(playBt,highScoreBt,exitBt);
        gameMenu.setAlignment(Pos.CENTER);
        gameMenu.setSpacing(20);


        gridPane.add(gameMenu,0,1);
        Scene scene = new Scene(gridPane,300,300, Color.rgb(48, 194, 228));

        scene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();


        playBt.setOnAction(event -> openNewWindowFrame());

    }

    private void showScores(Stage root) {

        Stage highScoreStage = new Stage();
        highScoreStage.initOwner(root);
        highScoreStage.initModality(Modality.WINDOW_MODAL);

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(300,400);



        ListView<String> scoresLV = new ListView<>(scores);
        Button checkButton = new Button(" > ");

        borderPane.setCenter(scoresLV);
        borderPane.setBottom(checkButton);
        checkButton.setOnMouseClicked(event -> {
            scores.add("Radek (Time: 3:40, grid 4x4)");
        });


        Scene scene = new Scene(borderPane,300,250);

        highScoreStage.setTitle("High scores");
        highScoreStage.setScene(scene);
        highScoreStage.show();

        // Set position of second window, related to primary window.
        highScoreStage.setX(root.getX() -400);
        highScoreStage.setY(root.getY() +100);



    }

    private void openNewWindowFrame() {

        NewGameFrame newGameFrame = new NewGameFrame(mainFrame);


    }
}
