package oop1;

import oop1.units.BaseHero;

import java.util.ArrayList;

public interface InGameInterface {
    void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam);
//    void step(ArrayList<BaseHero> battle);
    String getInfo();
    BaseHero closestEnemy(ArrayList<BaseHero> baseHeroes);
    void closestCharacterInfo(ArrayList<BaseHero> enemyTeam);
    Double distanceTo(ArrayList<BaseHero> enemyTeam);
    void move(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, Coordinates target);
}