package project.repositories;

import project.Interfaces.CrudDAO;
import project.models.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsersRepository implements CrudDAO<User> {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet set;

    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO users(name, surname, patronymic, city, birthdate, registrationdate, phonenumber, login," +
                    " hashpassword, data) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    //language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM users";

    //language=SQL
    private static final String SQL_FIND_BY_LOGIN =
            "SELECT * FROM users WHERE login = ?";

    //language=SQL
    private static final String SQL_DELETE_BY_ID =
            "DELETE FROM users WHERE id = ?";

    //language=SQL
    private static final String SQL_UPDATE_BY_ID =
            "UPDATE users SET name = ?, surname = ?, patronymic = ?, city = ?, birthdate = ? , registrationdate = ?," +
                    "phonenumber = ?, login = ?, hashpassword = ?, data = ? WHERE id = ?";

    public UsersRepository(String URL, String USER, String PASSWORD) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    // work +
    @Override
    public User getByLogin(String login) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_FIND_BY_LOGIN);
        preparedStatement.setString(1, login);
        set = preparedStatement.executeQuery();
        set.next();
        return new User(set.getLong("id"),
                set.getString("name"),
                set.getString("surname"),
                set.getString("patronymic"),
                set.getString("city"),
                set.getDate("birthdate"),
                set.getDate("registrationdate"),
                set.getString("phonenumber"),
                set.getString("login"),
                set.getString("hashpassword"),
                set.getString("data")
        );
    }

    @Override
    public void update(User model, int index) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
        preparedStatement.setString(1, model.getName());
        preparedStatement.setString(2, model.getSurname());
        preparedStatement.setString(3, model.getPatronymic());
        preparedStatement.setString(4, model.getCity());
        preparedStatement.setDate(5, model.getBirthDate());
        preparedStatement.setDate(6, model.getRegistrationDate());
        preparedStatement.setString(7, model.getPhoneNumber());
        preparedStatement.setString(8, model.getLogin());
        preparedStatement.setString(9, model.getHashpassword());
        preparedStatement.setString(10, model.getData());
        preparedStatement.setLong(11, index);
        preparedStatement.execute();
    }

    @Override
    public void add(User model) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
        preparedStatement.setString(1, model.getName());
        preparedStatement.setString(2, model.getSurname());
        preparedStatement.setString(3, model.getPatronymic());
        preparedStatement.setString(4, model.getCity());
        preparedStatement.setDate(5, model.getBirthDate());
        preparedStatement.setDate(6, model.getRegistrationDate());
        preparedStatement.setString(7, model.getPhoneNumber());
        preparedStatement.setString(8, model.getLogin());
        preparedStatement.setString(9, model.getHashpassword());
        preparedStatement.setString(10, model.getData());
        preparedStatement.execute();
    }

    @Override
    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    @Override
    public List<User> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        set = statement.executeQuery(SQL_SELECT_ALL);
        List<User> list = new ArrayList<>();
        while (set.next()) {
            list.add(new User(set.getLong("id"),
                    set.getString("name"),
                    set.getString("surname"),
                    set.getString("patronymic"),
                    set.getString("city"),
                    set.getDate("birthdate"),
                    set.getDate("registrationdate"),
                    set.getString("phonenumber"),
                    set.getString("login"),
                    set.getString("hashpassword"),
                    set.getString("data")
            ));

        }
        return list;
    }

    @Override
    public void addAllInFile(Collection<User> collection) throws SQLException, IOException {
        try(FileWriter writer = new FileWriter("notes.txt", false))
        {
            for (User user: collection){
                String text = user.toStringForFile();
                writer.write(text + "/");
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addRecordInFile(User object) throws SQLException {
        try(FileWriter writer = new FileWriter("notes.txt", false))
        {
            String text = object.toStringForFile();
            writer.write(text + "/");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getAllFromFile() {
        try(FileReader reader = new FileReader("notes.txt"))
        {
            int c;
            while((c = reader.read()) != -1){
                if (c == '/'){
                    System.out.println();
                } else {
                    System.out.print((char) c);
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}