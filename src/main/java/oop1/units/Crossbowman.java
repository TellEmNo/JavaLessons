package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Crossbowman extends RangedHeroes implements InGameInterface, RandomHS {

    public Crossbowman() {
        super(getName(), new Random().nextInt(60, 85),
                new Random().nextInt(8, 10) ,new Random().nextInt(10));
        super.arrows = new Random().nextInt(7, 10);
    }

    @Override
    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;
        if (this.arrows > 0){
            damage = new Random().nextInt(11, 15);
        }
        else damage = 0;
        target.getDamage((damage * luck));
        --this.arrows;
        if ((damage * luck) > 15) System.out.println(name+": Удачный выстрел!");
        else if ((damage * luck) < 11) System.out.println(name+": Неудачный выстрел!");
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " болтов: " + super.arrows +
                "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }

    @Override
    public void step() {
        super.step();
    }

    @Override
    public BaseHero create1() {
        return null;
    }

    @Override
    public BaseHero create2() {
        return new Crossbowman();
    }
}
