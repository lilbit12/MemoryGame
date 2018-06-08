package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;


public class MemoryTimer extends Thread {

    public SimpleIntegerProperty secondsProp;
    int seconds =0;
    private  int minutes;
    private boolean flaga;
    private Label timeLab;

    public MemoryTimer(Label label){
        secondsProp = new SimpleIntegerProperty(seconds);
        minutes = 0;
        this.timeLab = label;
        flaga = true;
        this.start();

        timeLab.textProperty().bind(secondsProp.asString());
    }

    public void setSeconds(){
        secondsProp.set(seconds++);
    }


    public void updateTime(){
        setSeconds();
    }

    public int getSeconds(){
        return seconds;
    }

    @Override
    public void run() {
        try {
            while (true){
                updateTime();
                Thread.sleep(1000);
                System.out.println(seconds);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
