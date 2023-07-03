package oop1.units;

import java.util.Random;

public abstract class RangedHeroes extends BaseHero{

//    protected float accuracy;
    public RangedHeroes(String name, float hp) {
        super(name, hp);
    }

//    public void attack(BaseHero target) {
//        float damage;
//        if (this.arrows > 0){
//        damage = new Random().nextInt(10, 20);
//        }
//        else damage = 0;
//
//        target.getDamage(damage);
//        --this.arrows;
//    }
}
