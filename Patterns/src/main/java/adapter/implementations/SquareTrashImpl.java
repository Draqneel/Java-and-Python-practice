package adapter.implementations;

import adapter.interfaces.SquareTrash;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class SquareTrashImpl implements SquareTrash {
    private double diameter;

    @Override
    public double getDiagonal() {
        return diameter;
    }
}
