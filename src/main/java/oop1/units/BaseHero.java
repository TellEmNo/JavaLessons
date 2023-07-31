package oop1.units;

// Проанализировать и описать персонажей: Маг, монах, разбойник, копейщик, снайпер, арбалетчик, крестьянин.
// На базе описания персонажей описать простейшую иерархию классов.
// В основной программе создать по одному экземпляру каждого класса.

import oop1.Coordinates;
import oop1.InGameInterface;
import oop1.Name;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public abstract class BaseHero implements InGameInterface {

    protected String name;
    protected float hp;
    protected float maxHp;
    protected int initiative;
    protected int speed;
    protected double attackRange;
    protected int arrows;
    protected int maxArrows;
    public Coordinates coordinates;

    public BaseHero(String name, float hp, int speed, int initiative, int x, int y, double attackRange) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.initiative = initiative;
        this.speed = speed;
        this.attackRange = attackRange;
        this.arrows = arrows;
        this.maxArrows = arrows;
        coordinates = new Coordinates(x, y);
    }

    public static int startPositionRangedGreen(){
        int y = 0;
        y ++;
        return y;
    }

    public static String getName() {
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    public float getHp() {
        return hp;
    }

    public float getMaxHp() {
        return maxHp;
    }

    public int getInitiative() {
        return initiative;
    }

    protected void getHeal(float hp) {
        this.hp = hp + this.hp > this.maxHp ? this.maxHp : hp + this.hp;
    }

    protected float getDamage(float damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        else {
            this.hp = 0;
        }
        return damage;
    }

    public void attack(BaseHero target) {
        float luck = this.luck();
        float damage = new Random().nextInt(5, 10);
        System.out.println(target.getDamage((damage * luck)));
    }

    public String getInfo() {
        return ("Герой " + this.name + "," + " Type: " + this.getClass().getSimpleName() + ", Hp: " + this.hp
                + ", инициатива: " + this.initiative + ", скорость: " + this.speed);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public double getAttackRange() {
        return attackRange;
    }

    public int getArrows() {
        return arrows;
    }

    public float luck() {
        float damageModifier = 0;
        int indicator = new Random().nextInt(1, 101);
        if (indicator > 79) damageModifier = 1.5f;
        else if (indicator < 80 & indicator > 14) damageModifier = 1;
        else if (indicator < 15) damageModifier = 0.7f;

        return damageModifier;
    }

    public BaseHero checkMinHP(ArrayList<BaseHero> alliedTeam){
        BaseHero currentAlly = null;
        float minHP = Float.MAX_VALUE;
        for (BaseHero hero: alliedTeam){
            if (hero.getHp() < minHP){
                minHP = hero.getHp();
                currentAlly = hero;
            }
        }
        return currentAlly;
    }

    public BaseHero checkMinArrows(ArrayList<BaseHero> alliedTeam){
        BaseHero currentAlly = null;
        int minArrows = Integer.MAX_VALUE;
        for (int i = 0; i < alliedTeam.size(); i++){
            if (alliedTeam.get(i) instanceof RangedHeroes & alliedTeam.get(i).getArrows() < minArrows){
                minArrows = alliedTeam.get(i).getArrows();
                currentAlly = alliedTeam.get(i);
            }
//            else return alliedTeam.get(i);
        }
        return currentAlly;
    }
    @Override
    public void move(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, Coordinates targetPos) {
        if (!coordinates.containsByPosAlly(coordinates.newPosition(targetPos), alliedTeam)
            && !coordinates.containsByPosEnemy(coordinates.newPosition(targetPos), enemyTeam)) {
            for (int i = 0; i < speed; i++) {
                coordinates = coordinates.newPosition(targetPos);
            }
        }
        else coordinates.x--;
    }

    @Override
    public void closestCharacterInfo(ArrayList<BaseHero> team){
        Double closestD = Double.MAX_VALUE;
        Double dist;
        String heroType = null;
        String heroName = null;
        String res = null;
        for (int i = 0; i < team.size(); i++){
            dist = coordinates.distance(team.get(i).coordinates);
            if (dist < closestD & dist != 0 & team.get(i).hp > 0) {
                closestD = dist;
                heroType = team.get(i).getClass().getSimpleName();
                heroName = team.get(i).name;
                res = String.format( "Цель - %s, класс: %s, hp: %.1f, находится на расстоянии: %.2f "
                        , heroName, heroType, team.get(i).hp, closestD);
            }
            else if (team.get(i).hp <= 0) {
                team.get(i).hp = 0;
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

    public int[] getCoords() {
        int[] coordxy = new int[2];
        coordxy[0] = coordinates.x;
        coordxy[1] = coordinates.y;
        return coordxy;
    }
}