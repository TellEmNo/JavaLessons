package oop1.units;

import java.util.ArrayList;

public abstract class RangedHeroes extends BaseHero{
    public RangedHeroes(String name, float hp, int speed, int initiative, int x, int y, double attackRange) {
        super(name, hp, speed, initiative, x, y, attackRange);
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        if(super.hp > 0) {
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            BaseHero currentAlly = checkMinHP(alliedTeam);
            if (super.hp > 0 & this.arrows > 0 & distanceTo(enemyTeam) < super.attackRange) {
                closestCharacterInfo(enemyTeam);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " стреляет! ...");
                attack(currentEnemy);
            } else if (super.hp > 0 & this.arrows > 0 & distanceTo(enemyTeam) > super.attackRange) {
                closestCharacterInfo(enemyTeam);
                move(alliedTeam, enemyTeam ,currentEnemy.coordinates);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
            } else if (this.arrows == 0) {
                super.attackRange = 1.42;
                if (distanceTo(enemyTeam) < super.attackRange) attack(currentEnemy);
                else move(alliedTeam, enemyTeam ,currentEnemy.coordinates);
            }
            if (currentEnemy.hp == 0)
                System.out.println(currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name + " погиб в бою!");
        }
        System.out.println();
    }

}
