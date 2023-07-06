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
    public BaseHero create() {
        int index = r.nextInt(randomHS.length);
        return randomHS[index].create();
    }
}
