package oop1.units;

import oop1.InGameInterface;

import java.util.ArrayList;

public abstract class MeleeHeroes extends BaseHero implements InGameInterface {

    protected float endurance;
    protected float maxEndurance;
//    protected float rage;
    public MeleeHeroes(String name, float hp, int speed, int x, int y) {
        super(name, hp, speed, x, y);
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " выносливость: " + this.endurance
                + "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        if(super.hp > 0){
            if(alliedTeam.contains(Peasant.class)) return;
            else if(alliedTeam.contains(Plowman.class)) return;
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            closestEnemyInfo(enemyTeam);
            System.out.println(super.getClass().getSimpleName()+ " " + super.name + " наносит удар! ...");
            attack(currentEnemy);
            closestEnemyInfo(enemyTeam);
        }
        else return ;
    }

}
