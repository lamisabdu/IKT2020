package ikt;


public class DoubleLinked {
    public int data;
    public DoubleLinked next;
    public DoubleLinked previous;

    public DoubleLinked(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}