package StackIterrator;

import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer> {

    private Node<Integer> top;

    public Stack() {
        this.top = null;
    }

    public void push(int element) {
        Node<Integer> newNode = new Node<>(element);
        newNode.prev = this.top;
        this.top = newNode;
    }

    public int pop() throws Exception {
        if (this.top == null) {
           throw new Exception("No elements");
        } else {
            Node<Integer> current = this.top;
            this.top = this.top.prev;
            return current.element;
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node<Integer> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }
            @Override
            public Integer next(){
                int currentValue = current.element;
                this.current = this.current.prev;
                return (Integer) java.lang.Integer.valueOf(currentValue);
            }
        };
    }
}
