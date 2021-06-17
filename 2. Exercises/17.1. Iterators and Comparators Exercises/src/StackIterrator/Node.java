package StackIterrator;

public class Node<Integer> {
    public int element;
    public Node<Integer> prev;

   public Node(int element) {
        this.element = element;
        this.prev = null;
    }
}

