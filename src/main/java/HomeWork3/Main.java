package HomeWork3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> arrayList(int a, ArrayList<Integer> list){
        for (int i = 0; i < a; i++) {
            list.add(new Random().nextInt(30));
        }
        return list;
    }

    public static void arrayOddList(ArrayList<Integer> list){
        list.removeIf(integer -> integer % 2 == 0);
    }

    public static void minMaxValue(ArrayList<Integer> list){
        list.sort(Comparator.naturalOrder());
        System.out.println("Значение минимального элемента: "+ list.get(0));
        System.out.println("Значение максимального элемента: "+ list.get(list.size()-1));
    }

    public static void middleValue(ArrayList<Integer> list){
        double count = 0.0;
        for (Integer i : list) count += i;
        double midNum = count / list.size();
        System.out.printf("Среднее значение: " + "%.2f",midNum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов списка: ");
        int a = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(arrayList(a, list));
        arrayOddList(list);
        System.out.println(list);
        minMaxValue(list);
        middleValue(list);
    }
}
