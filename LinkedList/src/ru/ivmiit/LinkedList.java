package ru.ivmiit;

/**
 * SPECIFICATION
 * wiki: https://en.wikipedia.org/wiki/Linked_list
 *
 * @author Draqneel
 */
public class LinkedList {
    private Node root;
    private Node tail;
    private Node temp;
    private int count = 0;

    // add to the end
    public void addLast(Node node) {
        if (count == 0) {
            this.root = node;
            this.tail = node;
            count++;
        } else {
            temp = tail;
            temp.setLink(node);
            tail = node;
            count++;
        }
    }

    // add to the beginning
    public void addFirst(Node node) {
        temp = root;
        root = node;
        root.setLink(temp);
        count++;
    }

    public void removeFirst() {
        root = root.getLink();
        count--;
    }

    public void removeLast() {
        Node currentNode = root;
        for (int i = 0; i < (count - 1); i++) {
            currentNode = currentNode.getLink();
        }
        this.tail = currentNode;
        count--;
    }

    public Node getFitst() {
        return root;
    }

    public Node getLast() {
        return tail;
    }

    public void printAll() {
        Node currentNode = root;
        for (int i = 0; i < count; i++) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getLink();
        }
    }

    public int size() {
        return count;
    }

    // linked list contains input value or not
    public boolean contains(int value) {
        Node currentNode = root;
        for (int i = 0; i < count; i++) {
            if (currentNode.getValue() == value) {
                return true;
            }
            currentNode = currentNode.getLink();
        }
        return false;
    }


}
