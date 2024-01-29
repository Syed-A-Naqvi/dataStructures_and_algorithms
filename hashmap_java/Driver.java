package Hash_Implementation;

/**
 * Driver
 */
public class Driver {

    public static void main(String[] args) {
        HashMap map = new HashMap(5);
        map.put(1, 20);
        map.put(12, 35);
        map.put(22, 800);
        map.put(47, 657);
        map.put(3, 111);
        map.put(18, 89);
        map.put(19, 4);
        map.put(59, 20);
        map.print();

        map.put(47, 0);
        map.print();
        System.out.println("Value for key: 19 = " + map.get(19));
    }

}