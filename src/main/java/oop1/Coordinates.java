package oop1;

import oop1.units.BaseHero;

import java.util.ArrayList;

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

    public Coordinates newPosition(Coordinates targetPos){
        Coordinates currentCoord = new Coordinates(x, y);
        int dx = targetPos.x - x;
        int dy = targetPos.y - y;
        if (Math.abs(dx) >= Math.abs(dy)) {
            if (dx > 0) currentCoord.x++;
            else currentCoord.x--;
        }
        if (Math.abs(dx) < Math.abs(dy)) {
            if (dy > 0) currentCoord.y++;
            else currentCoord.y--;
        }
//        if (Math.abs(dx) == Math.abs(dy)) {
//            if (dx > 0) {
//                currentCoord.x++;
//                currentCoord.y++;
//            } else {
//                currentCoord.x--;
//                currentCoord.y--;
//            }
//        }
        if (currentCoord.x > 10) currentCoord.x = 10;
        if (currentCoord.y > 10)  currentCoord.y = 10;
        if (currentCoord.x < 1)  currentCoord.x = 1;
        if (currentCoord.y < 1)  currentCoord.y = 1;
        return currentCoord;
    }


    public boolean containsByPosAlly(Coordinates nextPos, ArrayList<BaseHero> alliedTeam){
        for (BaseHero allyHero: alliedTeam){
            if (allyHero.coordinates == nextPos){
                return true;
            }
        }
        return false;
    }
    public boolean containsByPosEnemy(Coordinates nextPos, ArrayList<BaseHero> enemyTeam){
        for (BaseHero TargetHero: enemyTeam){
            if (TargetHero.coordinates == nextPos) {
                return true;
            }
        }
        return false;
    }

}
