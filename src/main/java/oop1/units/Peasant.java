package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.Random;

public class Peasant extends MeleeHeroes implements InGameInterface, RandomHS {
    public Peasant() {
        super(getName(), new Random().nextInt(40, 50));
        super.endurance = new Random().nextInt(40, 50);
        super.maxEndurance = super.endurance;
    }

    public void woundDressing(BaseHero target){
        float luck = super.luck();
        float hp;
        if (this.endurance > 0) {
            hp = new Random().nextInt(5, 11);
        }
        else hp = 0;
        target.getHeal((hp*luck));
        this.endurance -= hp;
        if ((hp * luck) > 10) System.out.println(name+": Удачная перевязка раны!");
        else if ((hp * luck) < 5) System.out.println(name+": Неудачная перевязка раны!");
    }

    public void bringAnArrow(BaseHero target){
        ++target.arrows;
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
        return new Peasant();
    }
}
