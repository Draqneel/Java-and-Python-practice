package iterator;

import java.util.Iterator;

public interface Iterable<T> {
    Iterator<T> iterator();
}
