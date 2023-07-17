package oop1.units;

import oop1.Coordinates;
import oop1.InGameInterface;

import java.util.ArrayList;

public abstract class MeleeHeroes extends BaseHero implements InGameInterface {

    protected float endurance;
    protected float maxEndurance;
//    protected float rage;
    public MeleeHeroes(String name, float hp, int speed, int x, int y) {
        super(name, hp, speed, x, y);
    }

//    public void move(ArrayList<BaseHero> enemyTeam){
//        Coordinates coord = super.coordinates;
//
//
//    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " выносливость: " + this.endurance
                + "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }
//    могут взаимодействовать с целью, если дистанция < 1.5
    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist) {
        ArrayList<BaseHero> tmp;
        if(super.hp > 0){
            if(dist > 0)
                tmp = enemyTeam;
            else
                tmp = alliedTeam;
            if(alliedTeam.contains(Peasant.class)) return;
            else if(alliedTeam.contains(Plowman.class)) return;
            BaseHero currentEnemy = closestEnemy(tmp);
            closestEnemyInfo(tmp);
            System.out.println(super.getClass().getSimpleName()+ " " + super.name + " наносит удар! ...");
            attack(currentEnemy);
            closestEnemyInfo(tmp);
        }
        else return;
    }

}
