package oop1.units;

import java.util.Random;

public class Rogue extends MeleeHeroes{
    public Rogue() {
        super(getName(), new Random().nextInt(50, 75));
        super.endurance = new Random().nextInt(50, 75);
        super.maxEndurance = super.endurance;
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " выносливость: " + super.endurance);
    }

    public void attack(BaseHero target) {
        float luck = this.luck();
        float damage;

        if (super.endurance > 0){
            damage = new Random().nextInt(33, 34);
        }
        else damage = 0;

        target.getDamage((damage * luck));
        super.endurance -= damage * 0.2;
        if ((damage * luck) > 33) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 33) System.out.println(name+": Неудачный удар!");
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
}
