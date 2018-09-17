package ru.ivmiit;

/**
 * SPECIFICATION
 * wiki: https://en.wikipedia.org/wiki/Stack_(abstract_data_type)
 *
 * @author Draqneel
 */
public class Stack {
    public Node tail;
    // add node to the end
    public void push(Node node) {
        if (tail != null) {
            node.setLink(tail);
            tail = node;
        } else {
            tail = node;
        }
    }
    // nodes indicate to previous node
    public void pop() {
        tail = tail.getLink();
    }
}
