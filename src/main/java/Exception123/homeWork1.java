package Exception123;


    class Answer {
        public static void arrayOutOfBoundsException() {
            // Напишите свое решение ниже
            int[] arr = new int[3];
            int min = 4;
            System.out.println(arr[4]);

        }

        public static void divisionByZero() {
            // Напишите свое решение ниже
            int a = 3;
            int b = 0;
            System.out.println(a/b);
        }

        public static void numberFormatException() {
            // Напишите свое решение ниже
            String s = "sad";
            Integer.parseInt(s);
        }
    }

    public class homeWork1 {
        public static void main(String[] args) {
            Answer ans = new Answer();
            try {
                ans.arrayOutOfBoundsException();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Выход за пределы массива");
            }

            try {
                ans.divisionByZero();
            } catch (ArithmeticException e) {
                System.out.println("Деление на ноль");
            }

            try {
                ans.numberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Ошибка преобразования строки в число");
            }
        }
    }

