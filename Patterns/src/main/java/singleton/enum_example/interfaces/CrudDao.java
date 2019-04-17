package singleton.enum_example.interfaces;

import java.sql.SQLException;
import java.util.List;


/**
 * @param <T> - data type of implement collection
 *
 * CRUD - create, read, update, delete data operations
 */
public interface CrudDao<T> {
    T getByName(String login) throws SQLException;

    void update(T model, int index) throws SQLException;

    void add(T model) throws SQLException;

    void delete(int index) throws SQLException;

    List<T> getAll() throws SQLException;
}
