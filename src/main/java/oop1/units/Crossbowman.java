package oop1.units;

import oop1.InGameInterface;

import java.util.ArrayList;
import java.util.Random;

public class Crossbowman extends RangedHeroes implements InGameInterface {

    public Crossbowman(int x, int y) {
        super(getName(), new Random().nextInt(60, 85), 1, 5,x, y, 8);
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
        System.out.println(target.getDamage((damage * luck)));
        --this.arrows;
        if ((damage * luck) > 15) System.out.println(name+": Удачный выстрел!");
        else if ((damage * luck) < 11) System.out.println(name+": Неудачный выстрел!");
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " болтов: " + super.arrows +
                "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }
}
