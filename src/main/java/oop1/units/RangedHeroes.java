package oop1.units;

import java.util.Random;

public abstract class RangedHeroes extends BaseHero{

//    protected float accuracy;
    public RangedHeroes(String name, float hp, int x, int y) {
        super(name, hp, x, y);
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
