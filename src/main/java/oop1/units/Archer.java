package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.Random;

public class Archer extends RangedHeroes implements InGameInterface, RandomHS {

    public Archer(){
        super(getName(), new Random().nextInt(60, 75));
        super.arrows = new Random().nextInt(6, 8);
    }

    @Override
    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;
        if (this.arrows > 0){
            damage = new Random().nextInt(20, 25);
        }
        else damage = 0;
        target.getDamage((damage * luck));
        --this.arrows;
        if ((damage * luck) > 24) System.out.println(name+": Удачный выстрел!");
        else if ((damage * luck) < 20) System.out.println(name+": Неудачный выстрел!");
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " стрел: " + super.arrows);
    }

    @Override
    public void step() {
        super.step();
    }

    @Override
    public BaseHero create() {
        return new Archer();
    }
}
