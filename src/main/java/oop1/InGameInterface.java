package oop1;

import oop1.units.BaseHero;

import java.util.ArrayList;
import java.util.HashMap;

public interface InGameInterface {
    void step(ArrayList<BaseHero> team);
    String getInfo();
    String closest(ArrayList<BaseHero> baseHeroes);
}
