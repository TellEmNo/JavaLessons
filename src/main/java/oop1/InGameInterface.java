package oop1;

import oop1.units.BaseHero;

import java.util.ArrayList;

public interface InGameInterface {
    void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange);
//    void step(ArrayList<BaseHero> battle);
    String getInfo();
    BaseHero closestEnemy(ArrayList<BaseHero> baseHeroes);
    void closestEnemyInfo(ArrayList<BaseHero> enemyTeam);
    Double distanceTo(ArrayList<BaseHero> enemyTeam);
    void move(double distance, BaseHero target);
}