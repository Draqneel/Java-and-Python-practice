package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import project.Interfaces.Operationable;
import project.models.User;
import project.repositories.UsersRepository;
import project.tools.Hasher;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Properties;

public class SignUpController {

    public void helpPhoneBtnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText("Это поле для ввода даты рождения");
        alert.setContentText("Введите дату вашего рождения в формате ГГГГ-ММ-ДД (Год-месяц-день) " +
                "Чтобы ваш будущий работадатель больше знал о Вас");
        alert.showAndWait();
    }

    private UsersRepository repository;
    private Properties properties = new Properties();

    private Hasher hasher;
    private Operationable operationable;

    @FXML
    private ImageView iconImg;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField patronymicField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField dataField;

    public SignUpController() {
        try {
            this.properties.load(new FileInputStream("src/project/properties/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.repository = new UsersRepository(properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password"));
    }

    public void cancelBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            stage.setTitle("Авторизация");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/signInView.fxml"));
            Parent root = loader.load();
            SignInController controller = loader.getController();
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
        };
        operationable.operation(actionEvent);
    }

    public void signUpBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            try {
                User newUser = new User(1,
                        nameField.getText(),
                        surnameField.getText(),
                        patronymicField.getText(),
                        cityField.getText(),
                        Date.valueOf(dateField.getText()),
                        new Date(System.currentTimeMillis()),
                        numberField.getText(),
                        loginField.getText(),
                        hasher.md5Custom(passwordField.getText()),
                        dataField.getText());

                repository.add(newUser);

                Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setTitle("Авторизация");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/signInView.fxml"));
                Parent root = loader.load();
                SignInController controller = loader.getController();
                //
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Поздравляем");
                alert.setHeaderText("Вы успешно зарегестрированы в системе");
                alert.setContentText("Зайдите под своим логином и паролем чтобы продолжить");
                alert.showAndWait();
                //stage.show();
                stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Что-то пошло не так");
                alert.setContentText("Ошибка при регистрации");
                alert.showAndWait();
            }
        };
        operationable.operation(actionEvent);
    }
}
