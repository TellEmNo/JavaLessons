package oop1.units;

import oop1.InGameInterface;

import java.util.ArrayList;

public abstract class MeleeHeroes extends BaseHero implements InGameInterface {

    protected float endurance;
    protected float maxEndurance;
//    protected float rage;
    public MeleeHeroes(String name, float hp, int speed, int initiative, int x, int y, double attackRange) {
        super(name, hp, speed, initiative, x, y, attackRange);
        super.arrows = 0;
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " выносливость: " + this.endurance
                + "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }

//    могут взаимодействовать с целью, если дистанция < 1.42
    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange) {
        ArrayList<BaseHero> tmp;
        if(super.hp > 0){
            if(dist > 0)
                tmp = enemyTeam;
            else
                tmp = alliedTeam;
            BaseHero currentEnemy = closestEnemy(tmp);
            if(distanceTo(tmp) > 1.42) {
                closestCharacterInfo(tmp);
                move(distanceTo(tmp), currentEnemy);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                if(distanceTo(tmp) < 1.42) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар! ...");
                    attack(currentEnemy);
                    closestCharacterInfo(tmp);
                }
            }
            else {
                closestCharacterInfo(tmp);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар! ...");
                attack(currentEnemy);
                closestCharacterInfo(tmp);
            }
            System.out.println();
        }
        else return;
    }

}
