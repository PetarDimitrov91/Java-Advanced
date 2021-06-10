package com.advanced;

import java.util.function.Consumer;

public class DoublyLinkedList {

    private class Node { //всеки елемент от моя свързан списък
        //текущ елемент, следващия елемент, предишния елемент
        private int element;
        private Node next;
        private Node prev;

        private Node(int element) {
            this.element = element;
            //next = null;
            //prev = null;
        }
    }
    //глава, опашка, размер
    private Node head;
    private Node tail;
    private int size;


    //методи
    public void addFirst(int element) {
        //добавям в началото (първи елемент) => глава
        Node newNode = new Node(element);
        if(this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element){
        //добавя елемент в края (последен елемент) => опашка
        Node newNode = new Node(element);
        if(this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public int removeFirst() throws Exception {
        //премахва първия елемент (глава)
        if(this.size == 0) {
            throw new Exception("Cannot remove element from collection with size 0.");
        } else if (this.size == 1) {
            Node firstElement = this.head;
            this.head = null;
            this.tail = null;
            this.size = 0;
            return firstElement.element;
        } else {
            Node firstElement = this.head;
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return firstElement.element;
        }
    }

    public int removeLast() throws Exception {
        if(this.size == 0) {
            throw new Exception("Cannot remove element from collection with size 0.");
        } else if (this.size == 1) {
            Node removedElement = this.head;
            this.head = null;
            this.tail = null;
            this.size = 0;
            return removedElement.element;
        } else {
            Node removedElement = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.size--;
            return removedElement.element;
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while(currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        Node currentNode = this.head;
        int index = 0;
        while(currentNode != null) {
            array[index] = currentNode.element;
            index++;
            currentNode = currentNode.next;
        }
        return array;
    }
}
