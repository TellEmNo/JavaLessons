package oop1.units;

// Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
// На базе описания персонажей описать простейшую иерархию классов.
// В основной программе создать по одному экземпляру каждого класса.

import oop1.Name;

import java.util.Random;

public abstract class BaseHero {

    protected String name;
    protected float hp;
    protected float maxHp;
    protected int arrows;

    public BaseHero(String name, float hp) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
    }

    public BaseHero() {this((getName()), new Random().nextInt(100, 200));}

    public static String getName() {
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    public String getInfo() {
        return ("Герой " + this.name + "," + " Type: " + this.getClass().getSimpleName() + "," + " Hp: " + this.hp);
    }

    public float getHp() {
        return hp;
    }

    protected void getHeal(float hp) {
        this.hp = hp + this.hp > this.maxHp ? this.maxHp : hp + this.hp;
    }

    protected void getDamage(float damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        else this.hp = 0;
    }

    public void attack(BaseHero target) {
        float damage = new Random().nextInt(5, 10);
        target.getDamage((damage * luck()));
    }

    public float luck(){
        float damageModifier = 0;
        int indicator = new Random().nextInt(1,101);
        if (indicator > 79) damageModifier = 1.5f;
        else if (indicator < 80 & indicator > 14) damageModifier = 1;
        else if (indicator < 15) damageModifier = 0.7f;

        return damageModifier;
    }
}