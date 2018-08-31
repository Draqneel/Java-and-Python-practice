package ru.ivmiit;

public class Stack {
    public Node tail;

    public void push(Node node) {
        if (tail != null) {
            node.setLink(tail);
            tail = node;
        } else {
            tail = node;
        }
    }

    public void pop() {
        tail = tail.getLink();
    }

    public int getLast() {
        return tail.getValue();
    }
    // nodes indicate to previous node
}
