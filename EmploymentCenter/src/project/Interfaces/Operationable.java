package project.Interfaces;

import java.io.IOException;
import java.sql.SQLException;

public interface Operationable<T> {
    void operation(T event) throws IOException, SQLException;
}
