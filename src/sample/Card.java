package sample;


import com.sun.org.apache.regexp.internal.RE;
import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import sun.applet.Main;

import java.text.DecimalFormat;


public class Card extends StackPane {
    private static DecimalFormat df2 = new DecimalFormat(".##");
    private Text name = new Text();

    public Card(String value) {
        this.getStylesheets().add(getClass().getResource("buttons.css").toExternalForm());
        Rectangle border = new Rectangle(60,60);
        border.setFill(null);

        border.setStroke(Color.BLACK);
        name.setText(value);
        name.setOpacity(0);
        name.setFont(Font.font(25));

        getChildren().addAll(border,name);
        this.setPrefSize(50,50);
        this.setStyle("-fx-background-color: #fbff92;");
        setOnMouseClicked(this::mouseEventClick);
    }

    private boolean isClicked() {
        return name.getOpacity() == 1;
    }

    public void mouseEventClick(MouseEvent event){
        if (isClicked() || GameFrame.clicked == 0){
            return;
        }

        GameFrame.clicked--;

        if (GameFrame.selected == null){
            GameFrame.selected = this;
            openCard(() -> {});
        } else {
            openCard(() -> {
                if (!hasSameValue(GameFrame.selected)){
                    GameFrame.selected.setHide();
                    this.setHide();
                    //notMatchAnimation(GameFrame.selected);
                } else {
                    correctAnimation(GameFrame.selected);
                    GameFrame.pairsLeft--;
                    if (GameFrame.pairsLeft==0){
                        saveResult();
                    }

                }
                GameFrame.selected = null;
                GameFrame.clicked = 2;
            });
        }
    }

    private void saveResult() {

        Stage inputStage = new Stage();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);

        TextField name = new TextField();
        Label inoLb = new Label("Wprowadź imię:");
        Button okBtn = new Button("Ok");
        gridPane.add(inoLb,0,0);
        gridPane.add(name,0,1);
        gridPane.add(okBtn,0,2);


        Scene inputScene = new Scene(gridPane,50,100);
        inputStage.setScene(inputScene);

        inputStage.show();



        GameFrame.timeline.stop();
        double sec = GameFrame.seconds;


        GameFrame.result= ((GameFrame.gridSize*GameFrame.gridSize)/sec);

        String tmp = df2.format(GameFrame.result);



        System.out.println(GameFrame.gridSize + " " + GameFrame.seconds);


        System.out.println(GameFrame.result);

        okBtn.setOnAction(event -> {
            Result result = new Result(name.getText(),GameFrame.gridSize,tmp,GameFrame.seconds);
            MainFrame.scores.add(result.getInformation());
            GameFrame.seconds=0;
            GameFrame.result=0;
            GameFrame.gridSize=0;
            inputStage.close();
        });
    }

    private void correctAnimation(Card card) {
        this.setStyle("-fx-background-color: #67ff1f;");
        card.setStyle("-fx-background-color: #67ff1f;");

        ScaleTransition sT = new ScaleTransition(Duration.millis(100),this);
        ScaleTransition sT2 = new ScaleTransition(Duration.millis(100),card);

        sT.setByX(1.0f);
        sT.setByY(1.5f);
        sT.setCycleCount(2);
        sT.setAutoReverse(true);

        sT2.setByX(1.0f);
        sT2.setByY(1.5f);
        sT2.setCycleCount(2);
        sT2.setAutoReverse(true);

        ParallelTransition pt = new ParallelTransition(sT,sT2);
        pt.play();

    }

    private boolean hasSameValue(Card other) {
        return this.name.getText().equals(other.name.getText());
    }

    private void openCard(Runnable action) {



        FadeTransition ft = new FadeTransition(Duration.seconds(0.5), name);
        ft.setToValue(1);
        ft.setOnFinished(event -> action.run());

        this.setStyle("-fx-background-color: #516bff;");

        boolean flag = true;
        ft.play();

        while (flag){
            if (ft.getStatus() == Animation.Status.RUNNING){
                this.setMouseTransparent(true);
            } else {
                flag = false;
            }
        }






    }

    public void setHide(){
        this.setStyle("-fx-background-color: #fbff92;");
        FadeTransition ft = new FadeTransition(Duration.seconds(0.5),name);
        ft.setToValue(0);
        ft.play();
    }

    @Override
    public String toString() {
        return name.getText();
    }
}
