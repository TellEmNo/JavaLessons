//Задание: Первый семинар.
//        1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//        2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//        3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//        4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
//
//        Пункты реализовать в методе main
//        *Пункты реализовать в разных методах
//
//        int i = new Random().nextInt(k); //это кидалка случайных чисел!)

package HomeWork1;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int randomz(int num) {
        int i = new Random().nextInt(num);
        return i;
    }

    public static int mSB(int x){
        int i = 1;
        int t = 0;
        while (i < x){
            x >>= 1 ;
            t += 1;
        }
        return t;
    }

    public static int[] multiples(int i_, int n){
        int[] m1 = new int[(Short.MAX_VALUE / n) - (i_ / n) + 1];
        for (int i = i_, j = 0; i <= Short.MAX_VALUE; i += 1) {
            if (i % n == 0){
                m1[j] = i;
                j++;
            }
        }
        return m1;
    }

    public static int[] notMultiples(int i_, int n){
        int[] m2 = new int[(-Short.MIN_VALUE)];
        for (int i = Short.MIN_VALUE, j = 0; i <= i_; i += 1) {
            if (i % n != 0){
                m2[j] = i;
                j++;
            }
        }
        return m2;
    }

    public static void main(String[] args) {
        int k = 2000;
        int i_ = randomz(k);
        int n = mSB(i_);
        int[] m1 = multiples(i_, n);
        int[] m2 = notMultiples(i_, n);
        System.out.println(i_);
        System.out.println(n);
        System.out.println(Arrays.toString(m1));
        System.out.println(Arrays.toString(m2));
    }
}
