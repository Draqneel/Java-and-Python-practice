package singleton.best_practise.repositories;

import singleton.best_practise.interfaces.CrudDao;
import singleton.best_practise.models.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UsersRepository implements CrudDao<User> {

    private static class UsersRepositorySingleton {
        private static final UsersRepository instance = new UsersRepository();
    }

    public static UsersRepository getInstance() {
        return UsersRepositorySingleton.instance;
    }

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet set;

    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO users(name,surname, age, isHuman) VALUES (?, ?, ?, ?)";
    //language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM users";

    //language=SQL
    private static final String SQL_FIND_BY_NAME =
            "SELECT * FROM users WHERE name = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_ID =
            "DELETE FROM users WHERE id = ?";

    //language=SQL
    private static final String SQL_UPDATE_BY_ID =
            "UPDATE users SET name = ?, surname = ?, age = ?, ishuman =? WHERE id = ?";


    public UsersRepository() {
        Properties properties = new Properties();

        try {
            properties.load(new
                    FileInputStream("src/main/resources/properties/db.properties"));
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password")
            );
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByName(String login) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_FIND_BY_NAME);
        preparedStatement.setString(1, login);
        set = preparedStatement.executeQuery();
        set.next();
        return new User(
                set.getInt("id"),
                set.getString("name"),
                set.getString("surname"),
                set.getInt("age"),
                set.getBoolean("isHuman")
        );
    }

    @Override
    public void update(User model, int index) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
        preparedStatement.setString(1, model.getName());
        preparedStatement.setString(2, model.getSurname());
        preparedStatement.setInt(3, model.getAge());
        preparedStatement.setBoolean(4, model.isHuman());
        preparedStatement.setInt(5, index);
        preparedStatement.execute();

    }

    @Override
    public void add(User model) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
        preparedStatement.setString(1, model.getName());
        preparedStatement.setString(2, model.getSurname());
        preparedStatement.setInt(3, model.getAge());
        preparedStatement.setBoolean(4, model.isHuman());
        preparedStatement.execute();
    }

    @Override
    public void delete(int index) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
        preparedStatement.setInt(1, index);
        preparedStatement.execute();
    }

    @Override
    public List<User> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        set = statement.executeQuery(SQL_SELECT_ALL);
        List<User> list = new ArrayList<>();
        while (set.next()) {
            list.add(new User(
                    set.getInt("id"),
                    set.getString("name"),
                    set.getString("surname"),
                    set.getInt("age"),
                    set.getBoolean("isHuman")
            ));
        }
        return list;
    }

}
