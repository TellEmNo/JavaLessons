package Exception123;

import java.io.IOException;

public class task6 {
    public static void main(String[] args) {
    try {
        doSomething();
    } catch (Exception e) {
        System.out.println("Исключение!");
    }
    }
    public static void doSomething() throws Exception {
        throw new Exception();
    }
}
