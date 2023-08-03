package Exception123.HomeWork3;

import java.io.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class task {
    public static void main(String[] args) {
        String lastName;
        String name;
        String middleName;
        String dateOfBirth;
        long telNumber;
        String gender;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите следующие данные, разделенные пробелом: " +
                    "Фамилия Имя Отчество датаРождения номерТелефона пол. Мужчина - m, Женщина - f");
            System.out.println("Для выхода оставьте строку пустой.");
            String allData = scanner.nextLine();
            if (allData.equals("")) break;
            try {
                amountOfData(allData);
                System.out.println(allData);
                String[] strings = allData.split(" ");
                String[] date = strings[3].split("\\.");
                checkFormat(strings);
                lastName = strings[0];
                name = strings[1];
                middleName = strings[2];
                dateOfBirth = String.valueOf(strings[3]);
                telNumber = Integer.parseInt(strings[4]);
                gender = strings[5];
                try {
                    String res = lastName + " " + name + " " + middleName + " " + dateOfBirth + " " + telNumber + " " + gender;
                    addToFile(lastName, res);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void amountOfData(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            String tmp = String.valueOf(str.charAt(i));
            if (tmp.equals(" ")) {
                sum++;
            }
        }
        if (sum != 5) throw new InvalidAmountOfData();
    }
    public static void checkFormat(String[] strings){

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (isNumeric2(strings[i].charAt(j))) throw new wrongFormatFIO(strings[i]);
            }
        }

        String[] date = strings[3].split("\\.");

        for (int i = 0; i < date.length; i++) {
            if (!isNumeric(date[0])) throw new wrongDate();
            int day = Integer.parseInt(date[0]);
            if (!isNumeric(date[1])) throw new wrongDate();
            int month = Integer.parseInt(date[1]);
            if (!isNumeric(date[2])) throw new wrongDate();
            int year = Integer.parseInt(date[2]);
            if ((day < 0 || day > 31) | (month < 0 || month > 12) | (year < 1900 || year > 2023)) throw new wrongDate();
        }

        if (!isNumeric(strings[4])) throw new wrongTelephoneNumber();
        if (strings[5].equals("m") || strings[5].equals("f")) return;
        else throw new genderIsIncorrect();
    }
    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public static boolean isNumeric2(char ch) {
        try {
            Long.parseLong(String.valueOf(ch));
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public static void addToFile(String file, String newData) throws IOException {
        File file1 = new File(file);
        if (!file1.exists()) {
            file1.createNewFile();
        }
        // Asd Qwe Zxc 28.01.1997 987948235 m, Asd Qweasd Zxcwq 11.04.2001 747948576 f
        // Asdfg Qwe Zxc 28.01.1997 857948349 m, Asdfg Qwezx Zxdsc 13.12.1945 287397231 f
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(newData + "\n");
        bw.flush();
        bw.close();
    }
}
class InvalidAmountOfData extends RuntimeException {
    public InvalidAmountOfData() {
        super("Введено неверное количество данных!");
    }
}
class wrongFormatFIO extends RuntimeException {
    public wrongFormatFIO(String str) {
        super("Неверный формат Фамилии, Имени или Отчества-> " + str + ". Не используйте цифры и знаки!");
    }
}
class wrongDate extends RuntimeException {
    public wrongDate() {
        super("Неверная дата!");
    }
}
class wrongTelephoneNumber extends RuntimeException {
    public wrongTelephoneNumber() {
        super("Неверный формат номера телефона, используйте только цифры");
    }
}
class genderIsIncorrect extends RuntimeException {
    public genderIsIncorrect() {
        super("Неверно указан пол!");
    }
}
