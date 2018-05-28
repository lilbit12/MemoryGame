package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainFrame extends Application {



    Stage window;
    Button playBt;
    Button highscoreBt;
    Button exitBt;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("Memory game");

        Group rootGroup;

        playBt = new Button("New game");
        highscoreBt = new Button("High score");
        exitBt = new Button("Exit");
        playBt.setMaxWidth(Double.MAX_VALUE);
        highscoreBt.setMaxWidth(Double.MAX_VALUE);
        exitBt.setMaxWidth(Double.MAX_VALUE);

        Rectangle blue = new Rectangle(300,300,Color.SKYBLUE);
        blue.setArcHeight(50);
        blue.setArcWidth(50);

        /*
        GridPane grid = new GridPane();
        grid.setVgap(20);
        grid.add(playBt,0,1);
        grid.add(highscoreBt,0,2);
        grid.add(exitBt,0,3);
        grid.setAlignment(Pos.CENTER);
        grid.getChildren().add(blue);
        */
        VBox gameMenu = new VBox(playBt,highscoreBt,exitBt);
        gameMenu.setAlignment(Pos.CENTER);
        gameMenu.setSpacing(20);
        gameMenu.setLayoutX(80);
        gameMenu.setLayoutY(50);

        rootGroup = new Group(blue, gameMenu);




        Scene scene = new Scene(rootGroup,300,300);




        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
