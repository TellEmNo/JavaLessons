// Сравнить время выполнения замены символа "а" на "А"
// любой строки содержащей >1000 символов средствами String и StringBuilder.

package HomeWork2;
public class Main3 {

    public static void string1(String str){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            str += "a";
        }
        System.out.println(str.replace("a", "A"));
        System.out.println("String result: "+ (System.currentTimeMillis() - start));
    }

    public static void stringBuilder(StringBuilder builder){
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            builder.append("a");
            builder.replace(i, i + 1, "A");
        }
        System.out.println(builder);
        System.out.println("StringBuilder result: "+ (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) {
        String str = "";
        StringBuilder builder = new StringBuilder();

        stringBuilder(builder);
        string1(str);
    }
}
// Результат на 100_000 символов:
// StringBuilder ≈ 15мс
// String ≈ 950мс