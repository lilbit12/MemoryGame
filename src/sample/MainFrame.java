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


        playBt = new Button("New game");
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
        primaryStage.setScene(scene);
        primaryStage.show();


        playBt.setOnAction(event -> openNewWindowFrame());

    }

    private void openNewWindowFrame() {
        /*
        Stage newGameFrame = new Stage();
        newGameFrame.initOwner(mainFrame);
        newGameFrame.initModality(Modality.WINDOW_MODAL);

        Label gridSelectLabel = new Label("Wybierz ilosc wierszy");
        ComboBox<Integer> gridSelect = new ComboBox<>();

        gridSelect.getItems().addAll(3,4);
        gridSelect.getSelectionModel().selectFirst();
        Button playBt = new Button("Play");
        playBt.setMaxWidth(Double.MAX_VALUE);


        VBox playMenu = new VBox(gridSelectLabel,gridSelect,playBt);
        playMenu.setAlignment(Pos.CENTER);
        playMenu.setSpacing(20);


        GridPane gridPane = new GridPane();
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.setBackground(Background.EMPTY);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(playMenu,0,1);


        Scene scene = new Scene(gridPane,300,250,Color.rgb(48, 194, 228));

        // Set position of second window, related to primary window.
        newGameFrame.setX(mainFrame.getX() + 200);
        newGameFrame.setY(mainFrame.getY() + 100);

        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();
        */
        NewGameFrame newGameFrame = new NewGameFrame(mainFrame);

    }
}
