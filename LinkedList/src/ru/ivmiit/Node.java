package ru.ivmiit;

/**
 * Structural unit of Stack
 */
public class Node {
    private int value;
    private Node link;
    // constructor
    public Node(int value) {
        this.value = value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public void setLink(Node node) {
        this.link = node;
    }

    public int getValue() {
        return value;
    }

    public Node getLink() {
        return link;
    }
}
