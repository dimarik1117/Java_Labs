import java.util.Arrays;

public class ThirdLab {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable<>();

        System.out.println(myHashTable.isEmpty());
        myHashTable.put("ключ", "значение1");
        myHashTable.put("ключ", "значение2");
        System.out.println(myHashTable.size());
        myHashTable.put(1, Arrays.asList(1, 2, 3));
        myHashTable.put('а', 123);
        System.out.println(myHashTable.size());
        System.out.println(myHashTable.isEmpty());
        System.out.println();

        System.out.println(myHashTable.get("ключ"));
        System.out.println(myHashTable.get(1));
        System.out.println(myHashTable.get('а'));
        System.out.println();

        myHashTable.remove(1);
        myHashTable.remove(9999);
        System.out.println(myHashTable.size());
        System.out.println(myHashTable.get(1));
        System.out.println();

        HashTable<Integer, Order> secondHashTable = new HashTable<>();
        Order firstOrder = new Order("Салат", "200 руб", "10 мин");
        Order secondOrder = new Order("Суп", "250 руб", "20 мин");
        secondHashTable.put(1, firstOrder);
        secondHashTable.put(2, secondOrder);
        System.out.println(secondHashTable.get(1).getPrice());
        secondHashTable.remove(1);
        System.out.println(secondHashTable.get(2).getTime());
        secondHashTable.get(2).setTime("30 мин");
        System.out.println(secondHashTable.get(2).getTime());
    }
}