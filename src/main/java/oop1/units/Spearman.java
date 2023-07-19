package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Spearman extends MeleeHeroes implements InGameInterface, RandomHS {

    public Spearman() {
        super(getName(), new Random().nextInt(100, 150), 5, 7,
                new Random().nextInt(9, 11) ,new Random().nextInt(1, 11), 2);
        super.endurance = new Random().nextInt(100, 130);
        super.maxEndurance = super.endurance;
    }

    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;

        if (super.endurance - 15> 0){
            damage = new Random().nextInt(11, 16);
        }
        else damage = 0;

        target.getDamage((damage * luck));
        super.endurance -= damage * 0.8;
        if ((damage * luck) > 14) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 11) System.out.println(name+": Неудачный удар!");
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange) {
        ArrayList<BaseHero> tmp;
        if(super.hp > 0){
            if(dist > 0)
                tmp = enemyTeam;
            else
                tmp = alliedTeam;
//            if(alliedTeam.contains(Peasant.class)) return;
//            else if(alliedTeam.contains(Plowman.class)) return;
            BaseHero currentEnemy = closestEnemy(tmp);
            if(distanceTo(tmp) > attackRange) {
                closestCharacterInfo(tmp);
                move(distanceTo(tmp), currentEnemy);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                if(distanceTo(tmp) < attackRange) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " бьёт копьём! ...");
                    attack(currentEnemy);
                    closestCharacterInfo(tmp);
                }
            }
            else {
                closestCharacterInfo(tmp);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " бьёт копьём! ...");
                attack(currentEnemy);
                closestCharacterInfo(tmp);
            }
            System.out.println();
        }
        else return;
    }

    @Override
    public BaseHero create2() {
        return new Spearman();
    }

    @Override
    public BaseHero create1() {
        return null;
    }
}
