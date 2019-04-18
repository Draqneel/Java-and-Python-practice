package iterator;

import java.util.Iterator;

public class MainIterator {
    public static void main(String[] args) {
        CustomHashSet<String> customHashSet = new CustomHashSet<>();

        customHashSet.add("hello");
        customHashSet.add("world");
        customHashSet.add("piece");

        Iterator iterator = customHashSet.iterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
