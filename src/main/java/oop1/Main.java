package oop1;

import oop1.units.*;

public class Main {
    public static void main(String[] args) {
        Archer archer1 = new Archer();
        System.out.println(archer1.getInfo());
        Crossbowman crossbowman1 = new Crossbowman();
        System.out.println(crossbowman1.getInfo());
        Peasant peasant1 = new Peasant();
        System.out.println(peasant1.getInfo());
        Peasant peasant2 = new Peasant();
        System.out.println(peasant2.getInfo());
        while (true) {
//            peasant1.bringAnArrow(crossbowman1);
            crossbowman1.attack(archer1);
            if(archer1.getHp() == 0) {
                System.out.println(archer1.getInfo());
                break;
            }
//            peasant2.bringAnArrow(archer1);
            archer1.attack(crossbowman1);
            if (crossbowman1.getHp() == 0) {
                System.out.println(crossbowman1.getInfo());
                break;
            }
            System.out.println(archer1.getInfo());
            System.out.println(crossbowman1.getInfo());
        }
//        Archer archer1 = new Archer();
//        System.out.println(archer1.getInfo());
//        Crossbowman crossbowman1 = new Crossbowman();
//        System.out.println(crossbowman1.getInfo());
//        Spearman spearman1 = new Spearman();
//        System.out.println(spearman1.getInfo());
//        Rogue rogue1 = new Rogue();
//        System.out.println(rogue1.getInfo());
//        Magician magician1 = new Magician();
//        System.out.println(magician1.getInfo());
//        Monk monk1 = new Monk();
//        System.out.println(monk1.getInfo());
//        Peasant peasant1 = new Peasant();
//        System.out.println(peasant1.getInfo());
    }
}
