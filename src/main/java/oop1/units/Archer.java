package oop1.units;

import oop1.InGameInterface;
import java.util.ArrayList;
import java.util.Random;

public class Archer extends RangedHeroes implements InGameInterface {

    public Archer(int x, int y){
        super(getName(), new Random().nextInt(60, 75), 1, 5, x ,y, 7);
        super.arrows = new Random().nextInt(8, 11);
    }

    @Override
    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;
        if (this.arrows > 0){
            damage = new Random().nextInt(10, 13);
        }
        else damage = 0;
        System.out.println(target.getDamage((damage * luck)));
        --this.arrows;
        if ((damage * luck) > 13) System.out.println(name+": Удачный выстрел!");
        else if ((damage * luck) < 10) System.out.println(name+": Неудачный выстрел!");
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " стрел: " + super.arrows +
                "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y));
    }
}
