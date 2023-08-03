package Exception123;

import java.io.IOException;

public class task7 {
    public static void main(String[] args) {
        try (Counter counter = new Counter()){
            counter.add();
            System.out.println(counter.getValue());
            counter.close();
            System.out.println(counter.getValue());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
class Counter implements AutoCloseable {
    private Integer value = 0;

    public void add() throws IOException {
        if (value == null) throw new IOException("Счетчик закрыт!");
        value++;
    }

    public Integer getValue() throws IOException{
        if (value == null) throw new IOException("Счетчик закрыт!");
        return value;
    }

    @Override
    public void close() throws IOException{
        value = null;
    }
}
