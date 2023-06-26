package HomeWork6;

import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SetImitation imitation = new SetImitation();
        System.out.println(imitation.add(9));
        System.out.println(imitation.add(10));
        System.out.println(imitation.add(2));
        System.out.println(imitation.add(2));
        System.out.println(imitation.add(6));
        System.out.println(imitation.size());
        System.out.println(imitation.remove(10));
        System.out.println(imitation.remove(10));
        System.out.println(imitation.size());
        System.out.println(imitation.isEmpty());
        System.out.println(imitation.contains(9));
        System.out.println(imitation.contains(10));
        Iterator<Integer> iterator = imitation.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            System.out.print(i + " ");
        }
        System.out.println("\n" + imitation.getElmByIndex(1));
    }
}
class SetImitation<E>{
    private HashMap<E, Object> map = new HashMap<>();
    private static final Object OBJECT = new Object();
    public boolean add(E num){
        return map.put(num, OBJECT) == null;
    }
    public boolean remove(E num){
        return map.remove(num, OBJECT);
    }
    public int size(){
        return map.size();
    }
    public boolean isEmpty(){
        return map.isEmpty();
    }
    public boolean contains(Object num){
        return map.containsKey(num);
    }
    public Iterator<E> iterator(){
        return map.keySet().iterator();
    }
    public E getElmByIndex(int index){
        E[] mapArray = (E[]) map.keySet().toArray();
        return mapArray[index];
    }
}
