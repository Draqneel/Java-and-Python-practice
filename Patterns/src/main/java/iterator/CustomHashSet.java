package iterator;

import java.util.*;

public class CustomHashSet<T> implements Iterable {
    private int capacity = 10;
    private float loadFactor = (float) 0.75;

    private HashMap<T, Object> collection = new HashMap<>(capacity, loadFactor);
    private static final Object object = new Object();

    boolean add(T element) {
        return collection.put(element, object) == null;
    }

    public boolean remove(T element) {
        return collection.remove(element) == object;
    }

    public void clear() {
        collection.clear();
    }

    public boolean contains(T value) {
        return collection.get(value) == object;
    }

    public boolean isEmpty() {
        return collection.isEmpty();
    }

    private class CustomHashSetIterator implements Iterator {
        private ArrayList<T> list = new ArrayList<>();
        private int count = 0;

        CustomHashSetIterator() {
            for (Map.Entry<T, Object> entry : collection.entrySet()) {
                list.add(entry.getKey());
            }
        }

        @Override
        public boolean hasNext() {
            return count < collection.size();
        }

        @Override
        public Object next() {
            return list.get(count++);
        }

        @Override
        public void remove() {
            collection.remove(list.remove(count--));
        }

        public void reset(){
            count = 0;
        }

    }

    @Override
    public Iterator iterator() {
        return new CustomHashSetIterator();
    }
}
