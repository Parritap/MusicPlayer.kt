package model.logic.dataStructures;

import java.util.ArrayList;

public class LinkedList<E> {

    private Node<E> head;

    public LinkedList() {
        this.head = null;
    }

    public LinkedList(ArrayList<E> elements) {
        elements.forEach(song -> add(song));
    }

    public void add(E data) {
        var newNode = new Node<E>(data);
        if (head == null) {
            head = newNode;
        } else {
            var temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void add(E data, int index) {
        var newNode = new Node<E>(data);
        if (head == null) {
            head = newNode;
        } else {
            var temp = head;
            int i = 1;
            while (i < index) {
                if (temp.getNext() == null) {
                    throw new IndexOutOfBoundsException();
                }

                temp = temp.getNext();
                i++;
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
    }

    public int size() {
        int size = 0;
        var temp = head;
        while (temp != null) {
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public boolean contains(E data) {
        var temp = head;
        while (temp != null) {
            if (temp.getData().equals(data)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public E get(int index) {
        var temp = head;
        int i = 0;
        while (i < index) {
            if (temp.getNext() == null) {
                throw new IndexOutOfBoundsException();
            }
            temp = temp.getNext();
            i++;
        }
        return temp.getData();
    }

    public void print() {
        var temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
