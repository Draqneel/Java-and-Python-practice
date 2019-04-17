package singleton.best_practise;

import singleton.best_practise.repositories.UsersRepository;

import java.sql.SQLException;

public class MainSingleton {
    public static void main(String[] args) {
        UsersRepository repository = UsersRepository.getInstance();

        // test repository
        System.out.println("--- ALL USERS ---");
        try {
            repository.getAll().forEach(user -> System.out.println(user.toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
