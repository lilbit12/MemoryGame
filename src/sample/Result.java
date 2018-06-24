package sample;

public class Result {

    private int gridSize;

    public Result(int gridSize, String points, int time) {
        this.gridSize = gridSize;
        this.points = points;
        this.time = time;
    }

    private String points;
    private int time;
    private String name;

    public String getInformation(){
        return "Radek" + "( Time: " + time +", grid " + gridSize + "x" + gridSize +" points" + points +")";
    }
}
