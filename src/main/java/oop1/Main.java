package oop1;

import oop1.units.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
        public static ArrayList<BaseHero> team1 = new ArrayList<>();
        public static ArrayList<BaseHero> team2 = new ArrayList<>();
        public static ArrayList<BaseHero> battle = new ArrayList<>();
    public static void main(String[] args) {

        int teamSize = 10;

        System.out.println("Команда №1: ");
        for (int i = 0; i < teamSize; i++) {
            int val = new Random().nextInt(7);
            switch (val){
                case 0 -> team1.add(new Archer(1, i + 1));
                case 1 -> team1.add(new Monk(2, i + 1));
                case 2 -> team1.add(new Rogue(2, i + 1));
                case 3 -> team1.add(new Crossbowman(1, i + 1));
                case 4 -> team1.add(new Magician(1, i + 1));
                case 5 -> team1.add(new Spearman(2, i + 1));
                case 6 -> team1.add(new Peasant(2, i + 1));
            }
            System.out.println(team1.get(i).getInfo());
        }
        System.out.println();

        System.out.println("Команда №2: ");
        for (int i = 0; i < teamSize; i++) {
            int val = new Random().nextInt(7);
            switch (val){
                case 0 -> team2.add(new Archer(10, i + 1));
                case 1 -> team2.add(new Monk(9, i + 1));
                case 2 -> team2.add(new Rogue(9, i + 1));
                case 3 -> team2.add(new Crossbowman(10, i + 1));
                case 4 -> team2.add(new Magician(10, i + 1));
                case 5 -> team2.add(new Spearman(9, i + 1));
                case 6 -> team2.add(new Plowman(9, i + 1));
            }
            System.out.println(team2.get(i).getInfo());
        }

        battle.addAll(team1);
        battle.addAll(team2);

        battle.sort(Comparator.comparingInt(BaseHero::getInitiative).reversed());

        View.view();
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (true) {
            in.nextLine();
            String message = null;
            System.out.println("РАУНД " + (i + 1));

            for (BaseHero hero : battle){
                if(team1.contains(hero)) hero.step(team1, team2);
                else hero.step(team2, team1);
            }

            View.view();
            i++;

            if (teamDead(team1)){
                message = "Team 2 (Blue) win!";
                System.out.println(message);
                break;
            }
            if (teamDead(team2)){
                message = "Team 1 (Green) win!";
                System.out.println(message);
                break;
            }
        }

    }
    static boolean teamDead(ArrayList<BaseHero> team){
        for (BaseHero hero : team) {
            if (hero.getHp() > 0) return false;
        }return true;
    }
}
