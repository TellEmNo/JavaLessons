package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.Random;

public class Spearman extends MeleeHeroes implements InGameInterface, RandomHS {

    public Spearman() {
        super(getName(), new Random().nextInt(100, 150));
        super.endurance = new Random().nextInt(100, 130);
        super.maxEndurance = super.endurance;
    }

    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;

        if (super.endurance > 0){
            damage = new Random().nextInt(23, 30);
        }
        else damage = 0;

        target.getDamage((damage * luck));
        super.endurance -= damage * 0.4;
        if ((damage * luck) > 29) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 23) System.out.println(name+": Неудачный удар!");
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

    @Override
    public void step() {
        super.step();
    }

    @Override
    public BaseHero create() {
        return new Spearman();
    }
}
