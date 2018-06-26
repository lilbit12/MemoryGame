package sample;

import java.io.Serializable;

public class Result implements Serializable {

    private int gridSize;

    public Result(String name,int gridSize, String points, int time) {
        this.gridSize = gridSize;
        this.points = points;
        this.time = time;
        this.name = name;
    }

    private String points;
    private int time;
    private String name;

    public String getInformation(){
        return name + " (Time: " + time +", grid " + gridSize + "x" + gridSize +" points-" + points +")";
    }

}
