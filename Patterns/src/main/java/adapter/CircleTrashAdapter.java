package adapter;

import adapter.interfaces.CircleTrash;
import adapter.interfaces.SquareTrash;

public class CircleTrashAdapter implements CircleTrash {
    private SquareTrash trash;

    public CircleTrashAdapter(SquareTrash trash) {
        this.trash = trash;
    }

    @Override
    public double getDiameter() {
        return trash.getDiagonal();
    }
}
