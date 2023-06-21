package HomeWork4;

//Организовать ввод и хранение данных пользователей. ФИО возраст и пол
//вывод в формате Фамилия И.О. возраст пол
//добавить возможность выхода или вывода списка отсортированного по возрасту!)
//*реализовать сортировку по возрасту с использованием индексов
//*реализовать сортировку по возрасту и полу с использованием индексов

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static String[] getArray(String str){
        String[] res = null;
        res = str.strip().split(" ");
        if (res.length == 0){
            return null;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> middleName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> sex = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        String[] arrStr;
        Scanner scan = new Scanner(System.in);
        while (true){
            if (!scan.hasNextLine()) {
                break;
            } else {
                arrStr = getArray(scan.nextLine());
                lastName.add(arrStr[0]);
                name.add(arrStr[1]);
                middleName.add(arrStr[2]);
                age.add(Integer.parseInt(arrStr[3]));
                sex.add(arrStr[4]);
                id.add(age.size()-1);
            }
        }
        scan.close();
//  Сортировки
        Collections.sort(id, ((o1, o2) -> age.get(o1) - age.get(o2)));
//        Collections.sort(id, ((o1, o2) -> sex.get(o1).charAt(0) - sex.get(o2).charAt(0)));

//  Какая-то странная сортировка
//        Collections.sort(id, ((o1, o2) -> ((age.get(o1) + sex.get(o1).charAt(0)) - (age.get(o2) + sex.get(o2).charAt(0)))));

        System.out.println(id);
        id.forEach(n -> System.out.println(lastName.get(n)+ " " +name.get(0).charAt(0)+"." + " "
                + middleName.get(0).charAt(0)+"."+ " " + age.get(n) + " " + sex.get(n)));
    }
}