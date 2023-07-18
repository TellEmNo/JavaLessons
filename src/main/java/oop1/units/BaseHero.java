package oop1.units;

// Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
// На базе описания персонажей описать простейшую иерархию классов.
// В основной программе создать по одному экземпляру каждого класса.

import oop1.Coordinates;
import oop1.InGameInterface;
import oop1.Name;

import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements InGameInterface {

    protected String name;
    protected float hp;
    protected float maxHp;
    protected int arrows;
    protected int initiative;
    protected int speed;
    protected double attackRange;

    protected String state = "Stand";
    Coordinates coordinates;

    public BaseHero(String name, float hp, int speed, int initiative, int x, int y, double attackRange) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.initiative = initiative;
        this.speed = speed;
        this.attackRange = attackRange;
        this.state = state;
        coordinates = new Coordinates(x, y);
    }

//    public BaseHero() {this((getName()), new Random().nextInt(100, 200),
//            new Random().nextInt(0, 2) ,new Random().nextInt(10));}

    public static String getName() {
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    public float getHp() {
        return hp;
    }

    public int getInitiative() {
        return initiative;
    }

    protected void getHeal(float hp) {
        this.hp = hp + this.hp > this.maxHp ? this.maxHp : hp + this.hp;
    }

    protected void getDamage(float damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        else {
            this.hp = 0;
        }
    }

    public void attack(BaseHero target) {
        float damage = new Random().nextInt(5, 10);
        target.getDamage((damage));
    }

    public float luck() {
        float damageModifier = 0;
        int indicator = new Random().nextInt(1, 101);
        if (indicator > 79) damageModifier = 1.5f;
        else if (indicator < 80 & indicator > 14) damageModifier = 1;
        else if (indicator < 15) damageModifier = 0.7f;

        return damageModifier;
    }

    public String getInfo() {
        return ("Герой " + this.name + "," + " Type: " + this.getClass().getSimpleName() + "," + " Hp: " + this.hp);
    }

    public double getAttackRange() {
        return attackRange;
    }

    @Override
    public void move(double distance, BaseHero target){
        int tmp;
        if (distance > 1.42){
            if (this.coordinates.x + this.speed > target.coordinates.x || this.coordinates.x - target.coordinates.x == 0) {
                tmp = this.coordinates.x + this.speed - target.coordinates.x;
                this.coordinates.x = this.coordinates.x + this.speed - tmp - 1;
            }
            else if(this.coordinates.x < target.coordinates.x) this.coordinates.x = this.coordinates.x + this.speed;
            else if (this.coordinates.y + this.speed > target.coordinates.y || this.coordinates.y - target.coordinates.y == 0) {
                tmp = this.coordinates.y + this.speed - target.coordinates.y;
                this.coordinates.y = this.coordinates.y + this.speed - tmp - 1;
            }
            else if(this.coordinates.y < target.coordinates.y) this.coordinates.y = this.coordinates.y + this.speed;
            else if (this.coordinates.x - this.speed < target.coordinates.x || this.coordinates.x - target.coordinates.x == 0) {
                tmp = this.coordinates.x - this.speed - target.coordinates.x;
                this.coordinates.x = this.coordinates.x - this.speed - tmp + 1;
            }
            else if(this.coordinates.x > target.coordinates.x) this.coordinates.x = this.coordinates.x - this.speed;
            else if (this.coordinates.y + this.speed < target.coordinates.y || this.coordinates.y - target.coordinates.y == 0) {
                tmp = this.coordinates.y - this.speed - target.coordinates.y;
                this.coordinates.y = this.coordinates.y - this.speed - tmp + 1;
            }
            else if(this.coordinates.y > target.coordinates.y) this.coordinates.y = this.coordinates.y - this.speed;
        }
        if (this.coordinates.x > 10) this.coordinates.x = 10;
        else if (this.coordinates.y > 10)  this.coordinates.y = 10;
        else if (this.coordinates.x < 0)  this.coordinates.x = 0;
        else if (this.coordinates.y < 0)  this.coordinates.y = 0;

    }

    @Override
    public void closestEnemyInfo(ArrayList<BaseHero> team){
        Double closestD = Double.MAX_VALUE;
        Double dist;
        String heroType = null;
        String heroName = null;
        String res = null;
        for (int i = 0; i < team.size(); i++){
            dist = coordinates.distance(team.get(i).coordinates);
            if (dist < closestD & team.get(i).hp > 0) {
                closestD = dist;
                heroType = team.get(i).getClass().getSimpleName();
                heroName = team.get(i).name;
                res = String.format( "Противник - %s, класс: %s, hp: %.1f, находится на расстоянии: %.2f "
                        , heroName, heroType, team.get(i).hp, closestD);
            }
            else if (team.get(i).hp <= 0) {
                System.out.println("Противник " + team.get(i).name + " погиб в бою!");
                team.remove(team.get(i));
            }
        }
        System.out.println(res);
    }

    @Override
    public BaseHero closestEnemy(ArrayList<BaseHero> team) {
        Double closestD = Double.MAX_VALUE;
        Double dist;
        BaseHero currentEnemy = null;
        for (int i = 0; i < team.size(); i++) {
            dist = coordinates.distance(team.get(i).coordinates);
            if (dist < closestD & team.get(i).hp > 0) {
                closestD = dist;
                currentEnemy = team.get(i);
            }
        }
        return currentEnemy;
    }

    @Override
    public Double distanceTo(ArrayList<BaseHero> team) {
        Double distance;
        Double closestD = Double.MAX_VALUE;
        for (int i = 0; i < team.size(); i++) {
            distance = coordinates.distance(team.get(i).coordinates);
            if (distance < closestD & team.get(i).hp > 0)
                closestD = distance;
        }
        return closestD;
    }

}