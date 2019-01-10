package project.Interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface CrudDAO<T> {
    T getByLogin(String login) throws SQLException;

    void update(T model, int index) throws SQLException;

    void add(T model) throws SQLException;

    void delete(int index) throws SQLException;

    List<T> getAll() throws SQLException;

    void addAllInFile(Collection<T> collection) throws SQLException, IOException;

    void addRecordInFile (T object) throws SQLException;

    void getAllFromFile ();
}
