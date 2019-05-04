package adapter;

import adapter.interfaces.CircleTrash;

public class CircleFormTrashcan {
    private CircleTrash trash;
    private double trashcanRadius;

    public CircleFormTrashcan(double trashcanRadius) {
        this.trashcanRadius = trashcanRadius;
    }

    public boolean addTrash(CircleTrash trash){
        if (trash.getDiameter() <= trashcanRadius) {
            this.trash = trash;
            return true;
        }
        return false;
    }

    public CircleTrash getTrash() {
        return trash;
    }
}
