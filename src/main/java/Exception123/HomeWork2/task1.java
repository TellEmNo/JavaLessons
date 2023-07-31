package Exception123.HomeWork2;

//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
//Ввод текста вместо числа не должен приводить к падению приложения, вместо этого,
//необходимо повторно запросить у пользователя ввод данных.


import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        float a = floatNumber();
        System.out.println("Число: " + a);
    }
    public static float floatNumber() {
        Scanner scanner = new Scanner(System.in);
        String str;
        float num;
        while (true) {
            System.out.println("Введите пустую строку, чтобы выйти.");
            System.out.print("Введите дробное число типа float(например: 2.3): ");
            str = scanner.nextLine();
            if (str.isEmpty()) break;

            try {
                num = Float.parseFloat(str);
                return num;
            } catch (NumberFormatException e) {
                System.err.println("Введён текст или некорректное число: \"" + str + "\", вместо числа, введите снова:");
            }
        }
        return 0;
    }
}
