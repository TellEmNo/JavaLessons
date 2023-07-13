package oop1;

import oop1.units.BaseHero;

import java.util.ArrayList;

public interface InGameInterface {
    void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam);
    String getInfo();
    BaseHero closestEnemy(ArrayList<BaseHero> baseHeroes);
    void closestEnemyInfo(ArrayList<BaseHero> team);

}
