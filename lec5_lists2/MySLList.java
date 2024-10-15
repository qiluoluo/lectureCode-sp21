//import lec4_lists1.MyInitList;

public class MySLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public MySLList(int x) {
        this.first = new IntNode(x, null);
    }

    /**
     * Add x to front of the List.
     */
    public void addFirst(int x) {
        this.first = new IntNode(x, this.first);
    }

    /**
     * Get first item of the List.
     * @return int
     */
    public int getFirst() {
        return this.first.item;
    }


}
