package Exception123;

// Анна=4 Елена=5 Марина=6 Владимир=? Константин=? Иван=4
// Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив ( либо в HashMap).
// В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
// Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
// Записать в тот же файл данные с замененными символами ?

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class task5 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\Desktop\\Projects and study\\Java lssns\\Seminar\\JavaHomeWork\\src\\main\\java\\Exception123\\nameLength");
        ArrayList<String[]> list = readFile(file);
        changeChar(list);
        fileWriter(list, file);
    }
    public static ArrayList<String[]> readFile(File file){
        ArrayList<String[]> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null){
                list.add(line.split("="));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return list;
    }
    public static void changeChar(ArrayList<String[]> list){
        for (String[] el : list){
            if (!isNumeric(el[1]) && !el[1].equals("?")) throw new RuntimeException(el[1] + ": Не число и не знак вопроса!");
            if (el[1].equals("?")) el[1] = String.valueOf(el[0].length());
        }
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public static void fileWriter(ArrayList<String[]> list, File file){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (String[] s : list){
                bw.write(s[0] + "=" + s[1] + "\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
