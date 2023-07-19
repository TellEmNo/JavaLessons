package oop1.units;

import java.util.ArrayList;

public abstract class RangedHeroes extends BaseHero{
    public RangedHeroes(String name, float hp, int speed, int initiative, int x, int y, double attackRange) {
        super(name, hp, speed, initiative, x, y, attackRange);
    }

    @Override
    public void step(ArrayList<BaseHero> alliedTeam, ArrayList<BaseHero> enemyTeam, double dist, double attackRange) {
        ArrayList<BaseHero> tmp;
        if(super.hp > 0) {
            if (dist > 0) tmp = enemyTeam;
            else tmp = alliedTeam;
            BaseHero currentEnemy = closestEnemy(tmp);
            if (super.hp > 0 & this.arrows > 0 & distanceTo(tmp) < attackRange) {
                closestCharacterInfo(tmp);
                System.out.println(super.getClass().getSimpleName() + " " + super.name + " стреляет! ...");
                attack(currentEnemy);
                closestCharacterInfo(tmp);
            } else if (super.hp > 0 & this.arrows > 0 & distanceTo(tmp) > attackRange) {
                closestCharacterInfo(tmp);
                move(distanceTo(tmp), currentEnemy);
                System.out.println(super.getClass().getSimpleName() + " " + super.name
                        + " движется к " + currentEnemy.getClass().getSimpleName() + " " + currentEnemy.name
                        + ". Новые координаты: " + super.coordinates.x + ":" + super.coordinates.y);
            }
            System.out.println();
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
