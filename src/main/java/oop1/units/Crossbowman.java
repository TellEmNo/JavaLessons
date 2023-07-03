package oop1.units;

import java.util.Random;

public class Crossbowman extends RangedHeroes{

    public Crossbowman() {
        super(getName(), new Random().nextInt(60, 85));
        super.arrows = new Random().nextInt(4, 6);
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " болтов: " + super.arrows);
    }

    @Override
    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;
        if (this.arrows > 0){
            damage = new Random().nextInt(22, 29);
        }
        else damage = 0;
        target.getDamage((damage * luck));
        --this.arrows;
        if ((damage * luck) > 28) System.out.println(name+": Удачный выстрел!");
        else if ((damage * luck) < 22) System.out.println(name+": Неудачный выстрел!");
    }
}
