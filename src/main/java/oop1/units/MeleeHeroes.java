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
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        if(super.hp > 0) {
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            BaseHero currentAlly = checkMinHP(alliedTeam);
            if(distanceTo(enemyTeam) > 1.42) {
                closestCharacterInfo(enemyTeam);
                move(alliedTeam, enemyTeam,currentEnemy.coordinates);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                if(distanceTo(enemyTeam) < 1.42 && distanceTo(enemyTeam) != 0) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар! ...");
                    attack(currentEnemy);
                }
            }
            else if (distanceTo(enemyTeam) != 0){
                closestCharacterInfo(enemyTeam);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар! ...");
                attack(currentEnemy);
            }
            System.out.println();
        }
        else return;
    }

}
