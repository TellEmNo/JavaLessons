package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Spearman extends MeleeHeroes implements InGameInterface, RandomHS {

    public Spearman() {
        super(getName(), new Random().nextInt(100, 150),
                new Random().nextInt(8, 10) ,new Random().nextInt(10));
        super.endurance = new Random().nextInt(100, 130);
        super.maxEndurance = super.endurance;
    }

    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;

        if (super.endurance > 0){
            damage = new Random().nextInt(11, 15);
        }
        else damage = 0;

        target.getDamage((damage * luck));
        super.endurance -= damage * 0.4;
        if ((damage * luck) > 14) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 11) System.out.println(name+": Неудачный удар!");
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
                "," + " координаты: " + (super.coordinates.x+":"+super.coordinates.y);
    }

    @Override
    public void step(ArrayList<BaseHero> team) {
        System.out.println(closest(team));
        System.out.println(this.getClass().getSimpleName()+ " " + this.name + " совершает свой ход ...");
    }

    @Override
    public BaseHero create2() {
        return new Spearman();
    }

    @Override
    public BaseHero create1() {
        return null;
    }
}
