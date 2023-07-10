package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.ArrayList;
import java.util.Random;

public class Rogue extends MeleeHeroes implements InGameInterface, RandomHS {
    public Rogue() {
        super(getName(), new Random().nextInt(65, 80),
                new Random().nextInt(0, 2) ,new Random().nextInt(10));
        super.endurance = new Random().nextInt(60, 90);
        super.maxEndurance = super.endurance;
    }

    public void attack(BaseHero target) {
        float luck = this.luck();
        float damage;

        if (super.endurance > 0){
            damage = new Random().nextInt(19, 20);
        }
        else damage = 0;

        target.getDamage((damage * luck));
        super.endurance -= damage * 0.2;
        if ((damage * luck) > 19) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 19) System.out.println(name+": Неудачный удар!");
    }

    @Override
    public float luck() {
        float damageModifier = 0;
        int indicator = new Random().nextInt(1,101);
        if (indicator > 65) damageModifier = 1.4f;
        else if (indicator < 65 & indicator > 5) damageModifier = 1;
        else if (indicator < 6) damageModifier = 0.9f;

        return damageModifier;
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
    public BaseHero create1() {
        return new Rogue();
    }

    @Override
    public BaseHero create2() {
        return null;
    }
}
