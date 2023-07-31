package oop1.units;

import oop1.InGameInterface;

import java.util.ArrayList;
import java.util.Random;

public class Rogue extends MeleeHeroes implements InGameInterface {
    public Rogue(int x, int y) {
        super(getName(), new Random().nextInt(65, 80), 3, 9, x ,y, 1.42);
        super.endurance = new Random().nextInt(60, 90);
        super.maxEndurance = super.endurance;
    }
    public void attack(BaseHero target) {
        float luck = this.luck();
        float damage;

        if (super.endurance - 19 > 0){
            damage = new Random().nextInt(19, 20);
        }
        else damage = 0;

        System.out.println(target.getDamage((damage * luck)));

        super.endurance -= damage * 0.4;
        if ((damage * luck) > 19) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 19) System.out.println(name+": Неудачный удар!");
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
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        if(super.hp > 0) {
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            BaseHero currentAlly = checkMinHP(alliedTeam);
            if (distanceTo(enemyTeam) >super.attackRange) {
                closestCharacterInfo(enemyTeam);
                move(alliedTeam, enemyTeam ,currentEnemy.coordinates);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);

                if(distanceTo(enemyTeam) < super.attackRange && distanceTo(enemyTeam) != 0) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар исподтишка! ...");
                    attack(currentEnemy);
                    attack(currentEnemy);
                }
            }
            else if (distanceTo(enemyTeam ) <= super.attackRange && distanceTo(enemyTeam) != 0){
                closestCharacterInfo(enemyTeam);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар исподтишка! ...");
                attack(currentEnemy);
                attack(currentEnemy);
            }
            if (currentEnemy.hp == 0)
                System.out.println(currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name + " погиб в бою!");
        }
        System.out.println();
    }
}
