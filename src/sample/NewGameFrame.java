package sample;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewGameFrame {

    public NewGameFrame(Stage root) {

        Stage newGameFrame = new Stage();
        newGameFrame.initOwner(root);
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


        Scene scene = new Scene(gridPane,300,250, Color.rgb(48, 194, 228));

        // Set position of second window, related to primary window.
        newGameFrame.setX(root.getX() + 200);
        newGameFrame.setY(root.getY() + 100);

        newGameFrame.setTitle("New Game");
        newGameFrame.setScene(scene);
        newGameFrame.show();

        playBt.setOnAction(event -> new GameFrame());
        }
    }


