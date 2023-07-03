package oop1.units;

import java.util.Random;

public abstract class MeleeHeroes extends BaseHero{

    protected float endurance;
    protected float maxEndurance;
//    protected float rage;
    public MeleeHeroes(String name, float hp) {
        super(name, hp);
    }

}
