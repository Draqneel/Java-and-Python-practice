package singleton.enum_example;

import singleton.enum_example.repositories.UsersRepository;

import java.sql.SQLException;

public class MainEnumSingleton {
    public static void main(String[] args) {
        // test repository
        System.out.println("--- ALL USERS ---");
        try {
            UsersRepository.INSTANCE.getAll().forEach(user -> System.out.println(user.toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
