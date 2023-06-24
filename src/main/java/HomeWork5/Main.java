package HomeWork5;

import java.util.*;
import java.util.Collections;

//Задание
//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.

public class Main {

//    private static void addElm(HashMap<String, ArrayList<String>> pb, String name, String phone){
//        pb.putIfAbsent(name, new ArrayList<>());
//        pb.get(name).add(phone);
//    }

    public static void main(String[] args) {
        HashMap<String, String> pb = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String name;
        String phone;

        while (true) {
            System.out.println("Введите имя и номер телефона");
            System.out.println(("Если хотите выйти, оставьте поля пустыми"));
            name = sc.nextLine();
            phone = sc.nextLine();
            if (name.isEmpty() && phone.isEmpty())
                break;
            else
                pb.merge(name, phone, (o, n) -> o.isEmpty() ? o = n : o + " " + n);
            if (arrayList.contains(name))
                System.out.print("");
            else
                arrayList.add(name);

            Collections.sort(arrayList, (((o1, o2) -> pb.get(o2).split(" ").length - pb.get(o1).split(" ").length)));

            System.out.println(pb);
            System.out.println(arrayList);
        }
    }
}
