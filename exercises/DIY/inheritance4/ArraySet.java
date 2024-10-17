import java.util.*;

public class ArraySet<T> implements Iterable<T>{
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int curItem;

        public ArraySetIterator() {
            curItem = 0;
        }
        @Override
        public boolean hasNext() {
            return curItem <= size - 1;
        }

        @Override
        public T next() {
            T item = items[curItem];
            curItem += 1;
            return item;
        }
    }

//    @Override
//    public String toString(){
//        StringBuilder str = new StringBuilder("{");
//        for (int i = 0; i < size; i++) {
//            str.append(items[i]);
//            if (i != size - 1) {
//                str.append(", ");
//            }
//        }
//        str = new StringBuilder(str.toString().strip());
//        str.append("}");
//        return str.toString();
//    }

    /* Better way to implement toString*/
    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<String>();
        for (T item: this) {
            listOfItems.add(item.toString());
        }
        return "{" + String.join(", ", listOfItems) + "}";
    }


    public static <I> ArraySet<I> of(I...stuff) {
        ArraySet<I> arraySet = new ArraySet<I>();
        for (I item: stuff) {
            arraySet.add(item);
        }
        return arraySet;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArraySet<T> obj = (ArraySet<T>) o;
        if (this.size() != obj.size()) {
            return false;
        }
        for (T item: this) {
            if (!obj.contains(item)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ArraySet<String> s = ArraySet.of("I", "am", "Ki1ro");
        System.out.println(s);
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
