package Exception123;

public class task4 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{28, 7, null, 39, null, null};
        checkArray(arr);
    }
    public static void checkArray(Integer[] array){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            if (array[i] == null) sb.append(i).append(", ");
        }
        sb.replace(sb.length() - 2, sb.length() - 1, ".");
        if (sb.length() > 0) throw new RuntimeException("В массиве находятся null-ы на индексах: " + sb);
    }
}
