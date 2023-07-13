package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends BaseHero implements InGameInterface, RandomHS {
    protected float concentration;
    protected float maxConcentration;
    public Monk() {
        super(getName(), new Random().nextInt(100, 150), 4,
                new Random().nextInt(0, 2) ,new Random().nextInt(10));
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
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        if(super.hp > 0){
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            closestEnemyInfo(enemyTeam);
            System.out.println(super.getClass().getSimpleName()+ " " + super.name + " бьёт ладонью! ...");
            attack(currentEnemy);
            closestEnemyInfo(enemyTeam);
        }
        else return ;
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
