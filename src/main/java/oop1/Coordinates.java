package oop1;

public class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public double distance(Coordinates coordinates) {
        int dx = coordinates.x - this.x;
        int dy = coordinates.y - this.y;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

}
