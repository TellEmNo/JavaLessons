package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Rogue extends MeleeHeroes implements InGameInterface, RandomHS {
    public Rogue() {
        super(getName(), new Random().nextInt(65, 80), 7, 9,
                new Random().nextInt(1, 3) ,new Random().nextInt(1, 11), 1.42);
        super.endurance = new Random().nextInt(60, 90);
        super.maxEndurance = super.endurance;
    }

    public void attack(BaseHero target) {
        float luck = this.luck();
        float damage;

        if (super.endurance - 19 > 0){
            damage = new Random().nextInt(10, 16);
        }
        else damage = 0;

        System.out.println(target.getDamage((damage * luck)));

        super.endurance -= damage * 0.4;
        if ((damage * luck) > 15) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 10) System.out.println(name+": Неудачный удар!");
    }

    @Override
    public float luck() {
        float damageModifier = 0;
        int indicator = new Random().nextInt(1,101);
        if (indicator > 65) damageModifier = 1.4f;
        else if (indicator < 65 & indicator > 5) damageModifier = 1;
        else if (indicator < 6) damageModifier = 0.9f;

        return damageModifier;
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange) {
        ArrayList<BaseHero> tmp;
        if(super.hp > 0){
            if(dist > 0)
                tmp = enemyTeam;
            else
                tmp = alliedTeam;
            BaseHero currentEnemy = closestEnemy(tmp);
            if(distanceTo(tmp) > attackRange) {
                closestCharacterInfo(tmp);
                move(distanceTo(tmp) ,currentEnemy);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                if(distanceTo(tmp) < attackRange) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар исподтишка! ...");
                    attack(currentEnemy);
                    attack(currentEnemy);
                    closestCharacterInfo(tmp);
                }
            }
            else {
                closestCharacterInfo(tmp);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар исподтишка! ...");
                attack(currentEnemy);
                attack(currentEnemy);
                closestCharacterInfo(tmp);
            }
            if (currentEnemy.hp == 0)
                System.out.println(currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name + " погиб в бою!");
            System.out.println();
        }
        else return;
    }

    @Override
    public BaseHero create1() {
        return new Rogue();
    }

    @Override
    public BaseHero create2() {
        return null;
    }
}
