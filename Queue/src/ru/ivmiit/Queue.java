package ru.ivmiit;

/**
 * SPECIFICATION
 * wiki: https://en.wikipedia.org/wiki/Queue_(abstract_data_type)
 *
 * @author Draqneel
 */
public class Queue {
    private Node root;
    private Node tail;
    private Node temp;

    public Node element() {
        if (root != null) {
            return root;
        } else {
            System.err.println("NoSuchElementException");
        }
        return null;
    }

    public void push(Node node) {
        if (root == null) {
            root = node;
            tail = node;
        } else {
            temp = tail;
            temp.setLink(node);
            tail = node;
        }
    }

    public Node peek() {
        return root;
    }

    public Node poll() {
        temp = root;
        root = root.getLink();
        return temp;
    }

    public Node remove() {
        if (root != null) {
            temp = root;
            root = root.getLink();
            return temp;
        } else {
            System.err.println("NoSuchElementException");
        }
        return null;
    }
}
