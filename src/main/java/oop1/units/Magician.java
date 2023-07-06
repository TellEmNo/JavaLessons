package oop1.units;

import oop1.InGameInterface;
import oop1.RandomHS;

import java.util.Random;

public class Magician extends BaseHero implements InGameInterface, RandomHS {
    protected float mana;
    protected float maxMana;
    public Magician() {
        super(getName(), new Random().nextInt(60, 75));
        this.mana = new Random().nextInt(100, 130);
        this.maxMana = this.mana;
    }

    @Override
    public void attack(BaseHero target) {
        float damage;
        if (this.mana > 0){
            damage = new Random().nextInt(30, 41);
        }
        else damage = 0;
        target.getDamage((damage));
        this.mana -= damage * 2;
    }
        public void restoreMana(){
        float hp = this.hp/2;
        this.mana = this.mana + hp > this.maxMana ? this.maxMana : this.mana + hp;
        this.hp -= this.hp/4;
    }

    @Override
    public String getInfo() {
        return  (super.getInfo()+ "," + " мана: " + this.mana);
    }

    @Override
    public void step() {
        super.step();
    }

    @Override
    public BaseHero create() {
        return new Magician();
    }
}
