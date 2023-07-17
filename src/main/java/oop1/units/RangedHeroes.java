package oop1.units;

import java.util.ArrayList;

public abstract class RangedHeroes extends BaseHero{

//    protected float accuracy;
    public RangedHeroes(String name, float hp, int speed, int x, int y) {
        super(name, hp, speed, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist) {
        ArrayList<BaseHero> tmp;
        if(super.hp > 0 & super.arrows > 0){
            if(dist > 0)
                tmp = enemyTeam;
            else
                tmp = alliedTeam;
            BaseHero currentEnemy = closestEnemy(tmp);
            closestEnemyInfo(tmp);
            System.out.println(super.getClass().getSimpleName()+ " " + super.name + " стреляет! ...");
            attack(currentEnemy);
            closestEnemyInfo(tmp);
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
