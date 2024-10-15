/** Array based list.
 *  @author Josh Hug
 */

public class AList<T> {
    private T[] IntNode;
    private int size;
    private final int FACTOR = 100;
//    /**  the size of the list divided by the length of the items array */
//    private double R;

    /** Creates an empty list. */
    public AList() {
        IntNode = (T[]) new Object[FACTOR];
        size = 0;
    }

    /** Resize the list if the list has been full */
    private void resize(int capacity) {
        Object[] newNode = new Object[capacity];
        System.arraycopy(IntNode, 0, newNode, 0, size);
        IntNode = (T[]) newNode;
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size >= IntNode.length) {
            resize(size * FACTOR);
        }
        IntNode[size] = x;
        size++;
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return IntNode[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return IntNode[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T lastNode = getLast();
        IntNode[--size] = null;
        return lastNode;
    }
} 