package Exception123.HomeWork2;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println("Введите делитель:");
        int d = scanner.nextInt();
        if (d == 0) throw new ArithmeticException("Деление на ноль.");
        System.out.println("Введите индекс делимого:");
        int index = scanner.nextInt();
        if (index > (intArray.length - 1)) throw new ArrayIndexOutOfBoundsException("Выход индекса за пределы массива");
        else {
            double catchedRes1 = intArray[index]/d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
    }
}
