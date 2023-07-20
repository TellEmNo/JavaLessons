package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends BaseHero implements InGameInterface, RandomHS {
    protected float concentration;
    protected float maxConcentration;
    public Monk() {
        super(getName(), new Random().nextInt(100, 150), 4, 4,
                new Random().nextInt(1, 3) ,new Random().nextInt(1, 11), 1.42);
        this.concentration = new Random().nextInt(100, 120);
        this.maxConcentration = this.concentration;
        super.arrows = 0;
    }

    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;
        if (this.concentration - 15 > 0){
            damage = new Random().nextInt(11, 16);
        }
        else damage = 0;

        System.out.println(target.getDamage((damage * luck)));

        this.concentration -= damage * 0.7;
        if ((damage * luck) > 15) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 11) System.out.println(name+": Неудачный удар!");
    }

    public void heal(BaseHero target){
        float luck = super.luck();
        float hp;
        if (this.concentration - 18 > 0) {
            hp = new Random().nextInt(9, 19);
        }
        else hp = 0;
        target.getHeal((hp*luck));
        this.concentration -= hp;
        System.out.println("Цель излечена на " + (hp*luck) + " | HP: " + target.getHp());
        if ((hp * luck) > 15) System.out.println(name+": Удачное лечение!");
        else if ((hp * luck) < 8) System.out.println(name+": Неудачное лечение!");
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " концентрация: " + this.concentration +
                "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange) {
        ArrayList<BaseHero> tmp;
        ArrayList<BaseHero> tmpHeal;
        String res;
        if(super.hp > 0){
            if (dist > 0) {
                tmp = enemyTeam;
                tmpHeal = alliedTeam;
            } else {
                tmp = alliedTeam;
                tmpHeal = enemyTeam;
            }
            BaseHero currentEnemy = closestEnemy(tmp);
            BaseHero currentAlly = checkMinHP(tmpHeal);

            if (checkMinHP(tmpHeal).getHp() < 40 & !(currentAlly instanceof Monk) & !(currentAlly instanceof Peasant)
            & !tmp.contains(currentAlly) & currentAlly.hp != 0) {
                res = String.format( "Цель лечения - %s, класс: %s, hp: %.1f"
                        , currentAlly.name, currentAlly.getClass().getSimpleName(), currentAlly.hp);
                System.out.println(res);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " молится за "
                        + currentAlly.getClass().getSimpleName() + " " + currentAlly.name);
                heal(currentAlly);
            } else if(distanceTo(tmp) > attackRange & currentEnemy.hp != 0) {
                closestCharacterInfo(tmp);
                move(distanceTo(tmp) ,currentEnemy);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                if(distanceTo(tmp) < attackRange & currentEnemy.hp != 0) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар посохом! ...");
                    attack(currentEnemy);
                    closestCharacterInfo(tmp);
                }
            }
            else if ( currentEnemy.hp != 0){
                closestCharacterInfo(tmp);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар посохом! ...");
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
        return new Monk();
    }

    @Override
    public BaseHero create2() {
        return null;
    }
}
