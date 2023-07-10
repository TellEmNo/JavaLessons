package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Magician extends BaseHero implements InGameInterface, RandomHS {
    protected float mana;
    protected float maxMana;
    public Magician() {
        super(getName(), new Random().nextInt(60, 75),
                new Random().nextInt(8, 10) ,new Random().nextInt(10));
        this.mana = new Random().nextInt(100, 130);
        this.maxMana = this.mana;
    }

    @Override
    public void attack(BaseHero target) {
        float damage;
        if (this.mana > 0){
            damage = new Random().nextInt(15, 21);
        }
        else damage = 0;
        target.getDamage((damage));
        this.mana -= damage * 2;
    }
        public void restoreMana(){
        float hp = this.hp/2;
        this.mana = this.mana + hp > this.maxMana ? this.maxMana : this.mana + hp;
        this.hp -= this.hp/4;
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
    public void step(ArrayList<BaseHero> team) {
        System.out.println(closest(team));
        System.out.println(this.getClass().getSimpleName()+ " " + this.name + " совершает свой ход ...");
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
