package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.Interfaces.Operationable;
import project.models.Role;
import project.models.User;
import project.repositories.UsersRepository;
import project.tools.Hasher;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class SignInController {
    private UsersRepository repository;
    private Properties properties = new Properties();

    private Hasher hasher;
    private Operationable operationable;

    @FXML
    private ImageView iconImg;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    public SignInController() {
        try {
            this.properties.load(new FileInputStream("src/project/properties/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repository = new UsersRepository(properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password"));
    }

    public void signInBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            String login = loginField.getText();
            String password = hasher.md5Custom(passwordField.getText());
            try {
                User checkedUser = repository.getByLogin(login);
                if (checkedUser.getLogin().equals(login)) {
                    if (checkedUser.getHashpassword().equals(password)) {
                        if (login.equals("draqneel") && password.equals(repository.getByLogin("draqneel").getHashpassword())){
                            checkedUser.setRole(Role.ADMIN);
                        } else {
                            checkedUser.setRole(Role.USER);
                        }
                        Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
                        FXMLLoader loader = new FXMLLoader();
                        if (checkedUser.getRole().equals(Role.ADMIN)) {
                            stage.setTitle("Главная страница (Администратор)");
                            loader.setLocation(getClass().getResource("../views/tableForAdminView.fxml"));
                        } else {
                            stage.setTitle("Главная страница (Пользователь)");
                            loader.setLocation(getClass().getResource("../views/tableForUserView.fxml"));
                        }
                        Parent root = loader.load();
                        TableController controller = loader.getController();
                        controller.setCurrentUser(checkedUser);
                        stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
                    } else {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Ошибка");
                        alert.setHeaderText("Что-то пошло не так");
                        alert.setContentText("Неправильный пароль");
                        alert.showAndWait();
                    }
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Что-то пошло не так");
                alert.setContentText("Пользователь не найден");
                alert.showAndWait();
            }
        };
        operationable.operation(actionEvent);
    }

    public void cancelBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            stage.setTitle("Добро пожаловать");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/startPageView.fxml"));
            Parent root = loader.load();
            StartPageController controller = loader.getController();
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
        };
        operationable.operation(actionEvent);
    }

    public void helpBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информация");
            alert.setHeaderText("Вы находитесь на стадии авторизации");
            alert.setContentText("На этой страницей вы можете зайти в свою учетную запись " +
                    "или зарегестрировать нового пользователя");
            alert.showAndWait();
        };
        operationable.operation(actionEvent);
    }

    public void registrationLinkAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            stage.setTitle("Регистрация");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/signUpView.fxml"));
            Parent root = loader.load();
            SignUpController controller =  loader.getController();
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
        };
        operationable.operation(actionEvent);
    }
}
