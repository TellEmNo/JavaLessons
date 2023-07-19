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
        super.arrows = 0;
    }

    @Override
    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;
        if (this.mana - 20 > 0){
            damage = new Random().nextInt(15, 21);
        }
        else {
            damage = 0;
            restoreMana();
        }
        target.getDamage((damage * luck));
        this.mana -= damage * 1.2;
        if ((damage * luck) > 20) System.out.println(name+": Удачное заклинание!");
        else if ((damage * luck) < 15) System.out.println(name+": Неудачное заклинание!");
    }
    public void restoreMana(){
        float hp = super.hp/2;
        this.mana = this.mana + hp > this.maxMana ? this.maxMana : this.mana + hp;
        super.hp -= super.hp/4;
    }

    public void heal(BaseHero target){
        float luck = super.luck();
        float hp;
        if (this.mana - 10 > 0) {
            hp = new Random().nextInt(5, 11);
        }
        else {
            hp = 0;
            restoreMana();
        }
        target.getHeal((hp*luck));
        this.mana -= hp;
        System.out.println("Цель излечена на " + (hp*luck) + " | HP: " + target.getHp());
        if ((hp * luck) > 10) System.out.println(name+": Удачное лечение!");
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
        ArrayList<BaseHero> tmpHeal;
        String res;
        if (super.hp > 0) {
            if (dist > 0) {
                tmp = enemyTeam;
                tmpHeal = alliedTeam;
            } else {
                tmp = alliedTeam;
                tmpHeal = enemyTeam;
            }
            BaseHero currentEnemy = closestEnemy(tmp);
            BaseHero currentAlly = checkMinHP(tmpHeal);
            if (checkMinHP(tmpHeal).getHp() < 55 & !(currentAlly instanceof Magician) & !(currentAlly instanceof Plowman)
                    & !tmp.contains(currentAlly)) {
                res = String.format( "Цель лечения - %s, класс: %s, hp: %.1f"
                        , currentAlly.name, currentAlly.getClass().getSimpleName(), currentAlly.hp);
                System.out.println(res);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " лечит "
                        + currentAlly.getClass().getSimpleName() + " " + currentAlly.name);
                heal(currentAlly);
            } else if (super.hp > 0 & distanceTo(tmp) < attackRange) {
                closestCharacterInfo(tmp);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " запускает огненный шар! ...");
                attack(currentEnemy);
                closestCharacterInfo(tmp);
            } else if (super.hp > 0 & distanceTo(tmp) > attackRange) {
                closestCharacterInfo(tmp);
                move(distanceTo(tmp), currentEnemy);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
            }
            System.out.println();
        }else return;
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
