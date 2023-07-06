package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.Random;

public class Monk extends BaseHero implements InGameInterface, RandomHS {
    protected float concentration;
    protected float maxConcentration;
    public Monk() {
        super(getName(), new Random().nextInt(100, 150));
        this.concentration = new Random().nextInt(100, 120);
        this.maxConcentration = this.concentration;
    }

    public void attack(BaseHero target) {
        float luck = super.luck();
        float damage;

        if (this.concentration > 0){
            damage = new Random().nextInt(23, 30);
        }
        else damage = 0;

        target.getDamage((damage * luck));
        this.concentration -= damage * 0.5;
        if ((damage * luck) > 29) System.out.println(name+": Удачный удар!");
        else if ((damage * luck) < 23) System.out.println(name+": Неудачный удар!");
    }

    public void heal(BaseHero target){
        float luck = super.luck();
        float hp;
        if (this.concentration > 0) {
            hp = new Random().nextInt(15, 26);
        }
        else hp = 0;
        target.getHeal((hp*luck));
        this.concentration -= hp;
        if ((hp * luck) > 25) System.out.println(name+": Удачное лечение!");
        else if ((hp * luck) < 15) System.out.println(name+": Неудачное лечение!");
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " концентрация: " + this.concentration);
    }

    public void step() {
        super.step();
    }

    @Override
    public BaseHero create() {
        return new Monk();
    }
}
