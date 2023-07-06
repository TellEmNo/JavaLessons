package oop1.units;

import oop1.InGameInterface;

import java.util.Random;

public abstract class MeleeHeroes extends BaseHero implements InGameInterface {

    protected float endurance;
    protected float maxEndurance;
//    protected float rage;
    public MeleeHeroes(String name, float hp) {
        super(name, hp);
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " выносливость: " + this.endurance);
    }
}
