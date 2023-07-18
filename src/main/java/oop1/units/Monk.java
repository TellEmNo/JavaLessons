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
    }

    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;

        if (this.concentration > 0){
            damage = new Random().nextInt(11, 15);
        }
        else damage = 0;

        target.getDamage((damage * luck));
        this.concentration -= damage * 0.5;
        if ((damage * luck) > 15) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 11) System.out.println(name+": Неудачный удар!");
    }

    public void heal(BaseHero target){
        float luck = super.luck();
        float hp;
        if (this.concentration > 0) {
            hp = new Random().nextInt(8, 16);
        }
        else hp = 0;
        target.getHeal((hp*luck));
        this.concentration -= hp;
        if ((hp * luck) > 16) System.out.println(name+": Удачное лечение!");
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
        if(super.hp > 0){
            if(dist > 0)
                tmp = enemyTeam;
            else
                tmp = alliedTeam;
            BaseHero currentEnemy = closestEnemy(tmp);
            closestEnemyInfo(tmp);
            if(distanceTo(tmp) > attackRange) {
                move(distanceTo(tmp), currentEnemy);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
                if(distanceTo(tmp) < attackRange) {
                    System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар! ...");
                    attack(currentEnemy);
                }
            }
            else {
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " наносит удар! ...");
                attack(currentEnemy);
            }
            closestEnemyInfo(tmp);
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
