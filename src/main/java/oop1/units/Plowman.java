package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Plowman extends MeleeHeroes implements InGameInterface, RandomHS {
    public Plowman() {
        super(getName(), new Random().nextInt(50, 60), 4, 6,
                new Random().nextInt(9, 11) ,new Random().nextInt(1, 11), 1.42);
        super.endurance = new Random().nextInt(40, 50);
        super.maxEndurance = super.endurance;
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

    public void bringAnArrow(BaseHero target){++target.arrows;}

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange) {
        ArrayList<BaseHero> tmp;
        ArrayList<BaseHero> tmpHeal;
        String res;
        if(super.hp > 0) {
            if (dist > 0) {
                tmp = enemyTeam;
                tmpHeal = alliedTeam;
            } else {
                tmp = alliedTeam;
                tmpHeal = enemyTeam;
            }
            BaseHero currentEnemy = closestEnemy(tmp);
            BaseHero currentAlly = checkMinHP(tmpHeal);
            BaseHero currentRAlly = checkMinArrows(tmpHeal);
            if (currentRAlly instanceof RangedHeroes && currentRAlly.arrows < 7) {
                res = String.format("Цель - %s, класс: %s, hp: %.1f"
                        , currentAlly.name, currentRAlly.getClass().getSimpleName(), currentRAlly.hp);
                System.out.println(res);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " подаёт болт "
                        + currentRAlly.getClass().getSimpleName() + " " + currentRAlly.name);
                bringAnArrow(currentRAlly);
                currentRAlly.getInfo();
            } else {
                if (checkMinHP(tmpHeal).getHp() < checkMinHP(tmpHeal).getMaxHp() & !(currentAlly instanceof Plowman)) {
                    res = String.format("Цель лечения - %s, класс: %s, hp: %.1f"
                            , currentAlly.name, currentAlly.getClass().getSimpleName(), currentAlly.hp);
                    System.out.println(res);
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " лечит "
                            + currentAlly.getClass().getSimpleName() + " " + currentAlly.name);
                    woundDressing(currentAlly);
                } else if (distanceTo(tmp) > attackRange) {
                    closestCharacterInfo(tmp);
                    move(distanceTo(tmp), currentEnemy);
                    System.out.println(super.getClass().getSimpleName() + " " + super.name
                            + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                            + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                    if (distanceTo(tmp) < attackRange) {
                        System.out.println(super.getClass().getSimpleName() + " " + super.name + " тычет вилами! ...");
                        attack(currentEnemy);
                        closestCharacterInfo(tmp);
                    }
                } else {
                    closestCharacterInfo(tmp);
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " тычет вилами! ...");
                    attack(currentEnemy);
                    closestCharacterInfo(tmp);
                }
                System.out.println();
            }
        }
        else return;
    }

    @Override
    public BaseHero create2() {
        return new Plowman();
    }

    @Override
    public BaseHero create1() {
        return null;
    }
}
