package ikt;


public class DoubleLinked {
    public int data;
    public DoubleLinked next;
    public DoubleLinked previous;
// this is test
    
    public DoubleLinked(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
