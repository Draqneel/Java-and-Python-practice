package adapter;

import adapter.implementations.CircleTrashImpl;
import adapter.implementations.SquareTrashImpl;
import adapter.interfaces.CircleTrash;
import adapter.interfaces.SquareTrash;

public class MainAdapter {
    public static void main(String[] args) {
        CircleTrash circleTrash = new CircleTrashImpl(50.5);
        SquareTrash squareTrash = new SquareTrashImpl(12.3);

        CircleFormTrashcan trashcan = new CircleFormTrashcan(15.5);

        System.out.println(trashcan.addTrash(new CircleTrashAdapter(squareTrash)));
    }
}
