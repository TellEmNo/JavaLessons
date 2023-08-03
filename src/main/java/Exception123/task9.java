package Exception123;

// 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера неоходимо бросить исключение MyArraySizeException.
// 2. Далее метод должен пройтись по элементам массива, преобразовать в int и суммировать.
// Если преобразовать элемент(ы) не удается, должно быть брошено исключение MyArrayDataException с детализацией,
// в какой именно ячейке лежат неверные данные.
// 3. В методе main() вызвать полученный метод, обработать возможные исключения и вывести сумму элементов


public class task9 {
    public static void main(String[] args) {
        String[][] array = new String[][]{{"1", "1", "1", "w"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};

        try {
            System.out.println(checkArray(array));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int checkArray(String[][] array) {
        if (array.length != 4 || array[0].length != 4) throw new MyArraySizeException(array.length, array[0].length);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return sum;
    }
}
class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(int length1, int length2) {
        super("Неподходящий размер массива! Нужен массив: 4x4. Ваш массив: " + length1 + "x" + length2 );
    }
}
class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(int index1, int index2) {
        super("Не удалось преобразовать в int элемент: [" + index1 + "][" + index2 + "]");
    }
}
