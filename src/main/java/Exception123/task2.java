package Exception123;

public class task2 {
    public static void main(String[] args) {
    int[] arr = new int[]{1, 23, 45, 12, 32, 28, 7, 3, 39, 49}; //null;
    int val = 28;

    int res = checkArray(arr, val, 11);

    System.out.println(printError(res));

    }
    public static int checkArray(int[] arr, int value, int minLength){
        if (arr == null) return -3;

        if (arr.length < minLength) return -1;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == value) return i;
        }
        return -2;
    }
    public static String printError(int error){
        if (error == -1) return "Длина массива меньше заданного минимума!";
        else if (error == -2) return "Искомый элемент не найден!";
        else if (error == -3) return "Вместо массива пришел null";
        return "Индекс искомого значения: " + error;
    }
}
