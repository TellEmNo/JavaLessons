package Exception123;

import java.lang.reflect.Array;

public class task1 {
    public static void main(String[] args) {

    int[] arr = new int[6];
    int min = 5;

    int res = array(arr, min);
        System.out.println(res);
    }
    public static int array(int[] arr, int minLength){
        if (arr.length < minLength)
            return -1;
        return arr.length;
    }

}
