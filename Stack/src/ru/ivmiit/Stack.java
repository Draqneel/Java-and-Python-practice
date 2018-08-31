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
    // nodes indicate to previous node
}
