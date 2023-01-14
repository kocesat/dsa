package com.kocesat.datastructure.linear.linkedlist;

import java.util.Objects;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public Node getKthFromTheEnd(int k) {
        if (head == null) {
            return null;
        }
        if (size < k) {
            throw new IllegalArgumentException("k is too big");
        }
        if (k < 1) {
            throw new IllegalArgumentException("k is too small");
        }
        Node first = head;
        Node second;
        int move = 1;
        Node current = head;
        while (move < k) {
            current = current.getNext();
            move++;
        }
        second = current;
        while(second != null) {
            if (second == tail) {
                return first;
            }
            first = first.getNext();
            second = second.getNext();
        }
        throw new IllegalArgumentException("Illegal k");
    }

    public void reverse() {
        // 10 -> 20 -> 30
        // 30 -> 20 -> 10
        var current = head;
        Node previous = null;
        while (current != null) {
            var now = current;
            var next = current.getNext();
            now.setNext(previous);
            previous = now;
            current = next;
        }
        var tmp = head;
        head = tail;
        tail = tmp;
    }

    public Node removeLast() {
        var previous = getPrevious(tail);
        var removable = tail;
        tail = previous;
        tail.setNext(null);
        size--;
        return removable;
    }

    private Node getPrevious(Node node) {
        var current = head;
        while (current != null) {
            if (current.getNext() == node) return current;
            current = current.getNext();
        }
        return null;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node removable = head;
        head = removable.getNext();
        removable.setNext(null);
        size--;
        return removable;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public int indexOf(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.getValue() == value) {
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }


    public void addLast(int item) {
        Node node = new Node(item);
        if (tail == null) {
            head = tail = node;
            size++;
            return;
        }
        tail.setNext(node);
        tail = node;
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (head == null) {
            head = tail = node;
            size++;
            return;
        }
        node.setNext(head);
        head = node;
        size++;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = head;
        var index = 0;
        while (current != null) {
            array[index++] = current.getValue();
            current = current.getNext();
        }
        return array;
    }

    public void print() {
        Node current = head;
        while (Objects.nonNull(current)) {
            if (current != head) {
                System.out.print(" => ");
            }
            System.out.print(current.getValue());
            current = current.getNext();
        }
    }

    public int size() {
        return size;
    }
}
