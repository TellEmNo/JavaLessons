package oop1;

import oop1.units.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> listOfHeroes1 = new ArrayList<>();
        ArrayList<BaseHero> listOfHeroes2 = new ArrayList<>();

//        for (int i = 0; i < 10; i++) {
//            int val = new Random().nextInt(7);
//            switch (val){
//                case 0 -> listOfHeroes1.add(new Archer());
//                case 1 -> listOfHeroes1.add(new Crossbowman());
//                case 2 -> listOfHeroes1.add(new Magician());
//                case 3 -> listOfHeroes1.add(new Monk());
//                case 4 -> listOfHeroes1.add(new Peasant());
//                case 5 -> listOfHeroes1.add(new Rogue());
//                case 6 -> listOfHeroes1.add(new Spearman());
//            }
//            System.out.println(listOfHeroes1.get(i));
//        }


        RandomHero randomHero = new RandomHero(new RandomHS[]{
                new Archer(),
                new Crossbowman(),
                new Magician(),
                new Monk(),
                new Peasant(),
                new Rogue(),
                new Spearman()
        });

        System.out.println("Команда №1: ");
        for (int i = 0; i < 10; i++) {
            listOfHeroes1.add(randomHero.create());
            System.out.println(listOfHeroes1.get(i).getInfo());
        }
        System.out.println("Команда №2: ");
        for (int i = 0; i < 10; i++) {
            listOfHeroes2.add(randomHero.create());
            System.out.println(listOfHeroes2.get(i).getInfo());
        }
    }
}
