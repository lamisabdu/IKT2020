package ikt;


public class DoubleLinkedList {

    private DoubleLinked head;
    private DoubleLinked tail;
    private DoubleLinked newNode;
    private int listCount;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.listCount = 0;
    }



    private void prepend(DoubleLinked addfirst) {
        this.newNode = addfirst;
        if (head == null) {
            this.head = this.newNode;
            this.tail = this.newNode;
            this.head.previous = null;
            this.tail.next = null;
        } else {
            DoubleLinked temp = this.head;
            this.head = this.newNode;
            this.newNode.next = temp;
            temp.previous = this.newNode;
            this.newNode.previous = null;
        }

        this.listCount++;
    }


    public void append(DoubleLinked addend) {
        this.newNode = addend;
        if (head == null) {
            this.head = this.newNode;
            this.tail = this.newNode;
            this.head.previous = null;
            this.tail.next = null;
        } else {
            this.tail.next = this.newNode;
            this.newNode.previous = this.tail;
            this.tail = this.newNode;
            this.tail.next = null;
        }

        this.listCount++;
    }

    public void insert(DoubleLinked node, int position) {
        newNode = node;
        DoubleLinked current = head;
        int count = 1;
        while (count < position - 1) {
            current = current.next;
            count++;
        }
        newNode.next = current.next;
        current.next.previous = newNode;
        newNode.previous = current;
        current.next = newNode;

        this.listCount++;
    }

    public DoubleLinked get(int position) {

        if (position > this.size()) {
            System.out.println("index is larger than the list size !!!!");
            return null;
        }

        if (position <= 0) {
            System.out.println("index is smaller than 1 !!!!");
            return null;
        }

        DoubleLinked node = this.head;


        for (int i = 1; i < position; i++) {
            node = node.next;
        }

        return node;
    }


    public boolean remove(int position) {

        DoubleLinked nodeToDelete = this.get(position);


        if (this.head == null || nodeToDelete == null) {
            return false;
        }

        if (this.head == nodeToDelete) {
            this.head = nodeToDelete.next;
        }

        if (nodeToDelete.next != null) {
            nodeToDelete.next.previous = nodeToDelete.previous;
        }

        if (nodeToDelete.previous != null) {
            nodeToDelete.previous.next = nodeToDelete.next;
        }

        listCount--;
        return true;
    }


    public boolean contains(int node) {
        DoubleLinked current = head;
        while (current != null) {
            if (current.data == node) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {

        return this.listCount;
    }

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        for (int i = 1; i <= 10; i++) {
            list.prepend(new DoubleLinked(i));
            System.out.println(list.head.data);
            System.out.println(list.tail.data);
            System.out.println();
        }
        //for (int i = 1; i <= 10; i++) {
           // list.prepend(new DoubleLinked(i));
          //  System.out.println(list.head.data);
       // }
  //      list.insert(new DoubleLinked(1000), 3);

//        System.out.println(list.size());

        //System.out.println(list.remove(10));
        //System.out.println(list.size());

        //System.out.println(list.remove(10));
        //System.out.println(list.size());

       // for (int i = 1; i <= list.size(); i++) {
           // System.out.println(list.get(i).data);
       // }

    }
}