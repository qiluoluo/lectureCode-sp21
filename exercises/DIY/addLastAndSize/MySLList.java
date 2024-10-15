public class MySLList {
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int itemSize;

    public  MySLList() {
        sentinel = new IntNode(7, null);
        itemSize = 0;
    }

    public MySLList(int x) {
        sentinel = new IntNode(7, null);
        sentinel.next = new IntNode(x, null);
        itemSize = 1;

    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        itemSize += 1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        IntNode curNode = sentinel;
        while (curNode.next != null) {
            curNode = curNode.next;
        }
        curNode.next = new IntNode(x, null);
        itemSize += 1;
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
        return itemSize;
    }


    public static void main(String[] args) {
        MySLList mySLList = new MySLList(3);
        mySLList.addFirst(4);
        mySLList.addFirst(5);
        System.out.println(mySLList.size());
        System.out.println(mySLList.getFirst());
//        MySLList mySLList = new MySLList();
//        mySLList.addLast(1);
//        System.out.println(mySLList.size());
    }

}