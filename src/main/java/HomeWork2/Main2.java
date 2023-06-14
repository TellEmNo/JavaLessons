//Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
//{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
//Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:


package HomeWork2;

import java.util.Scanner;

public class Main2 {

    public static StringBuilder deleter(StringBuilder s){
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.toString().contains("}")) {
                s.insert(s.indexOf("}") + 1, "." + System.lineSeparator())
                        .delete(s.indexOf("}"), s.indexOf("}") + 1)
                        .delete(s.indexOf("{"), s.indexOf("{") + 1);
            }
            if (s.toString().contains("]")) {
                s.delete(s.indexOf("["), s.indexOf("[") + 1)
                        .delete(s.indexOf("]"), s.indexOf("]") + 1);
            }
            if (s.toString().contains("\"")){
                s.delete(s.indexOf("\""), s.indexOf("\"") + 1);
            }
            if (s.toString().contains(":")){
                s.delete(s.indexOf(":"), s.indexOf(":") + 1);
            }
            if (s.toString().contains(",")){
                s.delete(s.indexOf(","), s.indexOf(",") + 1);
            }
        }
        return s;
    }

    public static StringBuilder replacer(StringBuilder s){
        for (int i = 0; i < s.length(); i++) {
            if (!s.toString().contains(" Физика.")){
                s.replace(s.indexOf("фа"), s.indexOf("я") + 1, "Студент ")
                        .replace(s.indexOf("оц"), s.indexOf("нка") + 3, " получил(а) ")
                        .replace(s.lastIndexOf(" ") + 2, s.lastIndexOf(" ") + 9, " по предмету ");
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder s = new StringBuilder(scanner.nextLine());
        int len = s.length();
        deleter(s);
        replacer(s);
        System.out.println(s);
    }
}
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.