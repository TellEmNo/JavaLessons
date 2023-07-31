package Exception123;

public class task3 {
    public static void main(String[] args) {
    int[][] arr = new int[][] {{1, 0, 1},{1, 2, 0},{0, 1, 2}};

        System.out.println(sumOfElements(arr));
    }
    public static int sumOfElements(int[][] arr){
        int sum = 0;
        if (arr.length != arr[0].length) throw new RuntimeException("Количество строк неравно количеству столбцов!");
        for (int i = 0; i < arr.length; i++) { // строки
            for (int j = 0; j < arr[0].length; j++) { // столбцы
                if (arr[i][j] != 0 && arr[i][j] != 1){
                    throw new RuntimeException("Значение в ячейке: [" + i + ":" + j + "] не удовлетворяют условиям!");
                }
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
