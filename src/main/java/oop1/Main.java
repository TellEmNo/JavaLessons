package oop1;

import oop1.units.*;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<BaseHero> team1 = new ArrayList<>();
        ArrayList<BaseHero> team2 = new ArrayList<>();

//        for (int i = 0; i < 10; i++) {
//            int val = new Random().nextInt(7);
//            switch (val){
//                case 0 -> team1.add(new Archer());
//                case 1 -> team1.add(new Crossbowman());
//                case 2 -> team1.add(new Magician());
//                case 3 -> team1.add(new Monk());
//                case 4 -> team1.add(new Peasant());
//                case 5 -> team1.add(new Rogue());
//                case 6 -> team1.add(new Spearman());
//            }
//            System.out.println(team1.get(i));
//        }


        RandomHero randomHero = new RandomHero(new RandomHS[]{
                new Archer(),
                new Monk(),
                new Rogue(),
                new Peasant(),
                new Plowman(),
                new Crossbowman(),
                new Magician(),
                new Spearman()
        });

        System.out.println("Команда №1: ");
        for (int i = 0; i < 4; i++) {
            team1.add(randomHero.create1());
            System.out.println(team1.get(i).getInfo());
        }
        System.out.println();
        System.out.println("Команда №2: ");
        for (int j = 0; j < 4; j++) {
            team2.add(randomHero.create2());
            System.out.println(team2.get(j).getInfo());
        }

        ArrayList<BaseHero> battle = new ArrayList<>();
        battle.addAll(team1);
        battle.addAll(team2);

        battle.sort(Comparator.comparingInt(BaseHero::getInitiative).reversed());

        for (int i = 0; i < 5; i++) {
            System.out.println("__________________________________________________________________________________________");
            battle.forEach(n -> n.step(team1, team2, n.distanceTo(team2), n.getAttackRange()));
            System.out.println("__________________________________________________________________________________________");
        }
        System.out.println("Команда №1: ");
        for (int i = 0; i < team1.size(); i++) {
            System.out.println(team1.get(i).getInfo());
        }
        System.out.println();
        System.out.println("Команда №2: ");
        for (int j = 0; j < team2.size(); j++) {
            System.out.println(team2.get(j).getInfo());
        }
    }
}
