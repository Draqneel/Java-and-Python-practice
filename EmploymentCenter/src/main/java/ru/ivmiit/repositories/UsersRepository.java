package ru.ivmiit.repositories;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.ivmiit.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Repository of employment center users
 * it can:
 * 1) Get all Users from DB (List<User>)
 * 2) Add new User in DB
 * 3) Get User by id
 */

public class UsersRepository {
    JdbcTemplate template;

    private RowMapper<User> rowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("patronymic"),
                    resultSet.getString("city"),
                    resultSet.getDate("birthdate"),
                    resultSet.getDate("registrationdate"),
                    resultSet.getString("phonenumber"));
        }
    };


    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO users(name, surname, patronymic, city, birthdate, registrationdate, phonenumber) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_ALL =
            "SELECT * FROM users";

    //language=SQL
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM users WHERE id = ?";

    public UsersRepository(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public List<User> getList() {
        return template.query(SQL_SELECT_ALL, rowMapper);
    }

    public void setUser(User user) {
        template.update(SQL_INSERT_USER, user.getName(), user.getSurname(), user.getPatronymic(), user.getCity(),
                user.getBirthDate(), user.getRegistrationDate(), user.getPhoneNumber());
    }

    public User getUserById(long id) {
        return template.queryForObject(SQL_FIND_BY_ID, rowMapper, id);
    }
}


