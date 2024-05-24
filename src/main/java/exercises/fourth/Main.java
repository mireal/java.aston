package exercises.fourth;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"b", "a", "c", "d"};
        LinkedList<String> l = new LinkedList<>(Arrays.asList(arr));
        System.out.println("size: " + l.size());
        System.out.println("to string: " + l);
        System.out.println("pop: " + l.pop(3));

        System.out.println("contains a: " + l.contains("a"));
        System.out.println("contains d: " + l.contains("d"));

        System.out.println("Int generator print: ");
        System.out.println(Arrays.toString(l.toArray(String[]::new)));

        System.out.println("forEach: ");
        l.forEach(System.out::print);

        System.out.println("\nfor loop:");
        for (String val:l) {
            System.out.print(val);
        }

        BubbleSort.sort(l);
        System.out.println("\n" + l);
    }
}
