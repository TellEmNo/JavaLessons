package oop1.units;

import oop1.InGameInterface;

import java.util.ArrayList;
import java.util.Random;

public class Spearman extends MeleeHeroes implements InGameInterface {

    public Spearman(int x, int y) {
        super(getName(), new Random().nextInt(100, 150), 2, 7, x , y, 2);
        super.endurance = new Random().nextInt(100, 130);
        super.maxEndurance = super.endurance;
    }
//new Random().nextInt(9, 11) ,new Random().nextInt(1, 11)
    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;

        if (super.endurance - 15> 0){
            damage = new Random().nextInt(11, 16);
        }
        else damage = 0;

        System.out.println(target.getDamage((damage * luck)));

        super.endurance -= damage * 0.8;
        if ((damage * luck) > 15) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 11) System.out.println(name+": Неудачный удар!");
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        if(super.hp > 0) {
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            BaseHero currentAlly = checkMinHP(alliedTeam);
            if(distanceTo(enemyTeam) > super.attackRange) {
                closestCharacterInfo(enemyTeam);
                move(alliedTeam, enemyTeam ,currentEnemy.coordinates);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                if(distanceTo(enemyTeam) < super.attackRange && distanceTo(enemyTeam) != 0) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " бьёт копьём! ...");
                    attack(currentEnemy);
                }
            }
            else if (distanceTo(enemyTeam) != 0){
                closestCharacterInfo(enemyTeam);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " бьёт копьём! ...");
                attack(currentEnemy);
            }
            if (currentEnemy.hp == 0)
                System.out.println(currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name + " погиб в бою!");
        }
        System.out.println();
    }
}
