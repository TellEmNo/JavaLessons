package oop1;

import oop1.units.BaseHero;

import java.util.Random;

public class RandomHero implements RandomHS {
    RandomHS[] randomHS;
    Random r = new Random();

    public RandomHero(RandomHS[] randomHS){
        this.randomHS = randomHS;
    }

    @Override
    public BaseHero create1() {
        int index = r.nextInt(randomHS.length/2);
        return randomHS[index].create1();
    }
    @Override
    public BaseHero create2() {
        int index = r.nextInt(randomHS.length/2, randomHS.length);
        return randomHS[index].create2();
    }
}
