package oop1.units;

import java.util.Random;

public class Spearman extends MeleeHeroes{

    public Spearman() {
        super(getName(), new Random().nextInt(100, 150));
        super.endurance = new Random().nextInt(70, 100);
        super.maxEndurance = super.endurance;
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " выносливость: " + super.endurance);
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
}
