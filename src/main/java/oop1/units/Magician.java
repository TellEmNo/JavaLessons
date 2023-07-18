package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Magician extends BaseHero implements InGameInterface, RandomHS {
    protected float mana;
    protected float maxMana;
    public Magician() {
        super(getName(), new Random().nextInt(60, 75), 3, 3,
                new Random().nextInt(9, 11) ,new Random().nextInt(1, 11), 10);
        this.mana = new Random().nextInt(100, 130);
        this.maxMana = this.mana;
    }

    @Override
    public void attack(BaseHero target) {
        float damage;
        if (this.mana > 0){
            damage = new Random().nextInt(15, 21);
        }
        else {
            damage = 0;
            restoreMana();
        }
        target.getDamage((damage));
        this.mana -= damage * 2;
    }
    public void restoreMana(){
        float hp = this.hp/2;
        this.mana = this.mana + hp > this.maxMana ? this.maxMana : this.mana + hp;
        super.hp -= super.hp/4;
    }

    public void heal(BaseHero target){
        float luck = super.luck();
        float hp;
        if (this.mana > 0) {
            hp = new Random().nextInt(5, 8);
        }
        else hp = 0;
        target.getHeal((hp*luck));
        this.mana -= hp;
        if ((hp * luck) > 7) System.out.println(name+": Удачное лечение!");
        else if ((hp * luck) < 5) System.out.println(name+": Неудачное лечение!");
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " мана: " + this.mana +
                "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange) {
        ArrayList<BaseHero> tmp;
        if(dist > 0) tmp = enemyTeam;
        else tmp = alliedTeam;
        BaseHero currentEnemy = closestEnemy(tmp);
        if(super.hp > 0 & distanceTo(tmp) < attackRange){
            closestEnemyInfo(tmp);
            System.out.println(super.getClass().getSimpleName()+ " " + super.name + " запускает огненный шар! ...");
            attack(currentEnemy);
            closestEnemyInfo(tmp);
        } else if (super.hp > 0 & distanceTo(tmp) > attackRange) {
            move(distanceTo(tmp), currentEnemy);
            System.out.println(super.getClass().getSimpleName() + " " + super.name
                    + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                    + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
        } else return;
    }

    @Override
    public BaseHero create1() {
        return null;
    }

    @Override
    public BaseHero create2() {
        return new Magician();
    }
}
