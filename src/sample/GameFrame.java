package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameFrame {

    public GameFrame(){

        Stage newGameFrame = new Stage();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.setBackground(Background.EMPTY);


        Button bn1 = new Button();
        bn1.setText("A");


        Group buttonGroup = new Group();
        buttonGroup.getChildren().add(bn1);
        buttonGroup.resize(40,40);

        gridPane.add(buttonGroup,0,0);


        Scene scene = new Scene(gridPane,640,480, Color.rgb(48, 194, 228));
        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();

    }
}
