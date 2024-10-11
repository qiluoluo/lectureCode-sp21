package lec4_lists1;

public class MyInitList {
    public int first;
    public MyInitList rest;

    public MyInitList(int f, MyInitList r) {
        this.first = f;
        this.rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (this.rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        MyInitList curList = this;
        int total = 1;
        while (curList.rest != null) {
            curList = curList.rest;
            total++;
        }
        return total;
    }

    /** Returns the ith item of this IntList. */
    public int get(int idx) {
        assert  0 <= idx && idx < this.iterativeSize();
        MyInitList curList = this;
        while (idx != 0) {
            curList = curList.rest;
            idx++;
        }
        return curList.first;
    }

    public static void main(String[] args) {
        MyInitList L = new MyInitList(15, null);
        L = new MyInitList(10, L);
        L = new MyInitList(5, L);
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
    }
}
