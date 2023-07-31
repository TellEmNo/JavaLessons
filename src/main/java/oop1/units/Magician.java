package oop1.units;

import oop1.InGameInterface;

import java.util.ArrayList;
import java.util.Random;

public class Magician extends BaseHero implements InGameInterface {
    protected float mana;
    protected float maxMana;
    public Magician(int x, int y) {
        super(getName(), new Random().nextInt(60, 75), 1, 3, x, y, 10);
        this.mana = new Random().nextInt(140, 160);
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
        System.out.println(target.getDamage((damage * luck)));
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
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        String res;
        if (super.hp > 0) {
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            BaseHero currentAlly = checkMinHP(alliedTeam);
            if (checkMinHP(alliedTeam).getHp() < 55 & !(currentAlly instanceof Magician)
                    & !(currentAlly instanceof Plowman) & !enemyTeam.contains(currentAlly) & currentAlly.hp != 0) {
                res = String.format( "Цель лечения - %s, класс: %s, hp: %.1f"
                        , currentAlly.name, currentAlly.getClass().getSimpleName(), currentAlly.hp);
                System.out.println(res);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " лечит "
                        + currentAlly.getClass().getSimpleName() + " " + currentAlly.name);
                heal(currentAlly);
            } else if (super.hp > 0 & distanceTo(enemyTeam) < super.attackRange & currentEnemy.hp != 0) {
                closestCharacterInfo(enemyTeam);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " запускает огненный шар! ...");
                attack(currentEnemy);
            } else if (super.hp > 0 & distanceTo(enemyTeam) > super.attackRange & currentEnemy.hp != 0) {
                closestCharacterInfo(enemyTeam);
                move(alliedTeam, enemyTeam ,currentEnemy.coordinates);
                if (currentEnemy.coordinates == super.coordinates && enemyTeam.contains(enemyTeam)) super.coordinates.x--;
                else super.coordinates.x++;
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
            }
            if (currentEnemy.hp == 0)
                System.out.println(currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name + " погиб в бою!");
        }
        System.out.println();
    }
}
