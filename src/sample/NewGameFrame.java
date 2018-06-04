package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewGameFrame {

    public NewGameFrame(Stage root) {

            Stage window = new Stage();
            window.initOwner(root);
            window.initModality(Modality.WINDOW_MODAL);


            GridPane gridPane = new GridPane();

            Scene scene = new Scene(gridPane, 300, 300);


            window.setTitle("New Game");
            window.setScene(scene);
            window.show();
        }
    }


