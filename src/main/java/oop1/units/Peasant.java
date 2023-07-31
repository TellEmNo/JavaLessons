package oop1.units;

import oop1.InGameInterface;

import java.util.ArrayList;
import java.util.Random;

public class Peasant extends MeleeHeroes implements InGameInterface {
    public Peasant(int x, int y) {
        super(getName(), new Random().nextInt(50, 60), 1, 6, x ,y, 1.42);
        super.endurance = new Random().nextInt(40, 50);
        super.maxEndurance = super.endurance;
    }

    @Override
    public void attack(BaseHero target) {
        float damage = new Random().nextInt(5, 10);
        System.out.println(target.getDamage((damage)));
    }

    public void woundDressing(BaseHero target){
        float luck = super.luck();
        float hp;
        if (this.endurance - 10 > 0) {
            hp = new Random().nextInt(5, 11);
        }
        else hp = 0;
        target.getHeal((hp*luck));
        this.endurance -= hp * 0.8;
        System.out.println("Цель излечена на " + (hp*luck) + " | HP: " + target.getHp());
        if ((hp * luck) > 10) System.out.println(name+": Удачная перевязка раны!");
        else if ((hp * luck) < 5) System.out.println(name+": Неудачная перевязка раны!");
    }

    public void bringAnArrow(BaseHero target){
        ++target.arrows;
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        String res;
        if(super.hp > 0) {
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            BaseHero currentAlly = checkMinHP(alliedTeam);
            BaseHero currentRAlly = checkMinArrows(alliedTeam);
            if (currentRAlly instanceof RangedHeroes && currentRAlly.arrows < 8 & currentRAlly.hp != 0) {
                res = String.format("Цель - %s, класс: %s, hp: %.1f"
                        , currentAlly.name, currentRAlly.getClass().getSimpleName(), currentRAlly.hp);
                System.out.println(res);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " подаёт стрелу "
                        + currentRAlly.getClass().getSimpleName() + " " + currentRAlly.name);
                System.out.println();
                bringAnArrow(currentRAlly);
                currentRAlly.getInfo();
            } else {
                if (checkMinHP(alliedTeam).getHp() < checkMinHP(alliedTeam).getMaxHp()
                        & !(currentAlly instanceof Plowman) & currentAlly.hp != 0) {
                    res = String.format("Цель лечения - %s, класс: %s, hp: %.1f"
                            , currentAlly.name, currentAlly.getClass().getSimpleName(), currentAlly.hp);
                    System.out.println(res);
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " лечит "
                            + currentAlly.getClass().getSimpleName() + " " + currentAlly.name);
                    woundDressing(currentAlly);
                } else if (distanceTo(enemyTeam) > super.attackRange & currentEnemy.hp != 0) {
                    closestCharacterInfo(enemyTeam);
                    move(alliedTeam, enemyTeam ,currentEnemy.coordinates);
                    System.out.println(super.getClass().getSimpleName() + " " + super.name
                            + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                            + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                    if (distanceTo(enemyTeam) < super.attackRange & currentEnemy.hp != 0 && distanceTo(enemyTeam) != 0) {
                        System.out.println(super.getClass().getSimpleName() + " " + super.name + " бьёт лопатой! ...");
                        attack(currentEnemy);
                    }
                } else if ( currentEnemy.hp != 0 && distanceTo(enemyTeam) != 0){
                    closestCharacterInfo(enemyTeam);
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " бьёт лопатой! ...");
                    attack(currentEnemy);
                }
                if (currentEnemy.hp == 0)
                    System.out.println(currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name + " погиб в бою!");
            }
        }
        System.out.println();
    }
}
