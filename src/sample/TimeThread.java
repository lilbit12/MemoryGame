package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.Task;

public class TimeThread extends Thread {

    public int getTime() {
        return time;
    }

    int time = 0;

    public TimeThread(){
        this.start();
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                time++;
                System.out.println(time);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
