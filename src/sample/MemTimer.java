package sample;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

public class MemTimer extends Label implements Runnable {

    private SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:S");
    private String[] split;
    private SimpleStringProperty sspTime;
    private long time;
    private Timer t = new Timer("Metronome", true);
    private TimerTask tt;
    boolean timing = false;

    public MemTimer() {
        sspTime = new SimpleStringProperty("00:00:00");

    }

    @Override
    public void run() {
        if (!timing){
            try {

            }
        }
    }
}
