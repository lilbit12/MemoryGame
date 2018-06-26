package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MainFrame extends Application {

    private final String fileName = "scores.obj";
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

        loadScores();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(200));
        gridPane.setBackground(Background.EMPTY);


        Label id = new Label("s17430");
        playBt = new Button("New Game");
        highScoreBt = new Button("High score");
        exitBt = new Button("Exit");
        playBt.setMaxWidth(Double.MAX_VALUE);
        highScoreBt.setMaxWidth(Double.MAX_VALUE);
        exitBt.setMaxWidth(Double.MAX_VALUE);


        highScoreBt.setOnMouseClicked(event -> {
            String tmp = "points";
            scores.sort(Comparator
                            .comparing(s -> s.toString().indexOf(tmp,6)) .thenComparing( s -> s.toString().indexOf(tmp,8), Comparator.reverseOrder()));

            showScores(primaryStage);
        });


        VBox gameMenu = new VBox(id,playBt,highScoreBt,exitBt);
        gameMenu.setAlignment(Pos.CENTER);
        gameMenu.setSpacing(20);


        gridPane.add(gameMenu,0,1);
        Scene scene = new Scene(gridPane,300,300, Color.rgb(48, 194, 228));

        scene.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();


        playBt.setOnAction(event -> openNewWindowFrame());

        mainFrame.setOnCloseRequest(e -> closeProgram());

        exitBt.setOnAction( e -> closeProgram());

    }

    private void loadScores() {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis);
        ){
            List<String> score =(ArrayList<String>) ois.readObject();
            scores = FXCollections.observableArrayList(score);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku scores.obj");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Załadowanoa plik scores.obj");
    }

    private void closeProgram() {
        try (FileOutputStream fs = new FileOutputStream("scores.obj");
             ObjectOutputStream os = new ObjectOutputStream(fs)) {

            List<String> scoresTMP = new ArrayList<>(scores);
            os.writeObject(scoresTMP);

        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Zapisano do pliku");
        mainFrame.close();
    }

    private void showScores(Stage root) {

        Stage highScoreStage = new Stage();
        highScoreStage.initOwner(root);
        highScoreStage.initModality(Modality.WINDOW_MODAL);

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefSize(300,400);
        Button addEntry = new Button("Test");
        Button removeEntry = new Button("Remove selected");
        GridPane gridPane = new GridPane();



        ListView<String> scoresLV = new ListView<>(scores);


        borderPane.setBottom(gridPane);
        borderPane.setCenter(scoresLV);

        gridPane.add(addEntry,0,0);
        gridPane.add(removeEntry,1,0);

        addEntry.setOnMouseClicked(event -> MainFrame.scores.add("radek     d   sadass  d    asd     asdads     asd"));

        removeEntry.setOnMouseClicked( event -> {
            String tmp = scoresLV.getSelectionModel().getSelectedItem();
            scores.remove(tmp);
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
