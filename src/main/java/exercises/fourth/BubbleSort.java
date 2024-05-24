package exercises.fourth;

import java.util.ArrayList;
import java.util.Collection;

public class BubbleSort {
    public static <E extends Comparable<E>> void sort(Collection<E> c) {
        ArrayList<E> list = new ArrayList<>(c);

        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < list.size() - 1; i++) {
                E curr = list.get(i);
                E next = list.get(i + 1);

                if (curr.compareTo(next) > 0) {
                    list.set(i, next);
                    list.set(i + 1, curr);
                    swapped = true;
                }
            }
        }

        c.clear();
        c.addAll(list);
    }
}
