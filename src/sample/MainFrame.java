package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainFrame extends Application {


    private Stage mainFrame;
    private Button playBt;
    private Button highScoreBt;
    private Button exitBt;

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

    private void openNewWindowFrame() {

        NewGameFrame newGameFrame = new NewGameFrame(mainFrame);


    }
}
