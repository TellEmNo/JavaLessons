// Задание
//
//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
//используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//В итоге должно получится select * from students where name=Ivanov, country=Russia, city=Moscow

package HomeWork2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = "select * from students where ";
        StringBuilder builder = new StringBuilder(
                "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        for (int i = 0; i < builder.length() + 1 ; i++) {
            if (builder.toString().contains("\""))
                builder.deleteCharAt(builder.indexOf("\""));
        }
        for (int i = 0; i < builder.length(); i+=builder.length() - 1)
            builder.delete(i, i + 1);
        builder.replace(builder.lastIndexOf(","), builder.length(), "");
        System.out.println(s + builder);
    }
}