package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;



public class MemoryTimer extends Thread {


    Integer seconds = 0;
    public IntegerProperty secondsProp = new SimpleIntegerProperty();
    private  int minutes;
    private boolean flaga;


    public MemoryTimer(){
        secondsProp.set(seconds);
        minutes = 0;
        flaga = true;
        this.start();
    }

    public synchronized void setSeconds(Integer x){
        secondsProp.setValue(Integer.valueOf(x));
    }


    @Override
    public void run() {
        try {
            while (true){
                seconds++;
                Integer tmp = seconds;
                this.setSeconds(tmp);
                Thread.sleep(1000);
                System.out.println(seconds);
            }
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
