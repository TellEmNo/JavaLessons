package Exception123;

import java.io.*;

public class task8 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int a = 5 / 1;
            Integer[] arr = new Integer[] {1, null, 3};
            System.out.println(arr[0] += 1);
            File file = new File("text");
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
        } catch (ArithmeticException e) {
            throw new divByZero();
        } catch (NullPointerException e) {
            throw new nullElm();
        } catch (FileNotFoundException e) {
            throw new fileNotExist("text");
        }
    }
}
class divByZero extends ArithmeticException {
    public divByZero() {
        super("Нельзя делить на ноль!");
    }
}
class nullElm extends NullPointerException {
    public nullElm(int index) {
        super("Вы обращаетесь к пустому элементу массива по индексу " + index + " !");
    }
    public nullElm() {
        super("Вы обращаетесь к пустому элементу массива!");
    }
}
class fileNotExist extends FileNotFoundException {
    public fileNotExist() {
        super("Такого файла на существует!");
    }
    public fileNotExist(String path) {
        super("Такого файла на существует! " + path);
    }
}