package adapter.implementations;

import adapter.interfaces.CircleTrash;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CircleTrashImpl implements CircleTrash {
    private double radius;

    @Override
    public double getDiameter() {
        return radius;
    }
}
