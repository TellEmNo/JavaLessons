package oop1.units;

import java.util.ArrayList;

public abstract class RangedHeroes extends BaseHero{

//    protected float accuracy;
    public RangedHeroes(String name, float hp, int speed, int x, int y) {
        super(name, hp, speed, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam) {
        if(super.hp > 0 & super.arrows > 0){
            BaseHero currentEnemy = closestEnemy(enemyTeam);
            closestEnemyInfo(enemyTeam);
            System.out.println(super.getClass().getSimpleName()+ " " + super.name + " стреляет! ...");
            attack(currentEnemy);
            closestEnemyInfo(enemyTeam);
        }
        else return;
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
