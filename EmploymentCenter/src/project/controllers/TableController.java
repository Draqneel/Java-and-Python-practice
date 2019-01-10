package project.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import project.Interfaces.Operationable;
import project.models.User;
import project.repositories.UsersRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class TableController implements Initializable{
    private static final String URL = *your <url>*;
    private static final String USER = *your <userName>*;
    private static final String PASSWORD = *your <password>*;

    private static UsersRepository repository = new UsersRepository(URL, USER, PASSWORD);
    private User currentUser;
    private Operationable operationable;


    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    private final ObservableList<User> usersData = FXCollections.observableArrayList();

    @FXML
    private TableView<User> usersTable;

    @FXML
    private TableColumn<User, String> userName;

    @FXML
    private TableColumn<User, String> userPatronymic;

    @FXML
    private TableColumn<User, String> userCity;


    @FXML
    private Label nameLabel;

    @FXML
    private Label surnameLabel;

    @FXML
    private Label patronymicLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label numberLabel;

    @FXML
    private Label dataLabel;

    @FXML
    private Button deleteUserBtn;

    @FXML
    private Button changeUserBtn;


    private void showUserDetails(User user){
        if (user != null){
            nameLabel.setText(user.getName());
            surnameLabel.setText(user.getSurname());
            patronymicLabel.setText(user.getPatronymic());
            cityLabel.setText(user.getCity());
            ageLabel.setText(String.valueOf(user.getRegistrationDate().getYear() - user.getBirthDate().getYear()));
            numberLabel.setText(user.getPhoneNumber());
            dataLabel.setText(user.getData());
            currentUser = user;
        } else {
            nameLabel.setText("");
            surnameLabel.setText("");
            patronymicLabel.setText("");
            cityLabel.setText("");
            ageLabel.setText("");
            numberLabel.setText("");
            dataLabel.setText("");
        }
    }

    @Override
    public void initialize(java.net.URL location, ResourceBundle resources) {
        try {
            Stream<User> stream = repository.getAll().stream();
            stream.forEach(user -> {
                usersData.add(user);
                userName.setCellValueFactory(new PropertyValueFactory<>("name"));
                userPatronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
                userCity.setCellValueFactory(new PropertyValueFactory<>("city"));
                usersTable.setItems(usersData);

                showUserDetails(null);

                usersTable.getSelectionModel().selectedItemProperty().addListener(
                        ((observable, oldValue, newValue) -> showUserDetails(newValue)));
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            System.out.println("Log comeback to auth form");
        };
        operationable.operation(actionEvent);
    }

    public void deleteUserBtnAction(ActionEvent actionEvent) throws SQLException, IOException {
        operationable = o -> {
            int selectedIndex = usersTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0){
                deleteUser(usersTable.getItems().remove(selectedIndex));
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(null);
                alert.setTitle("Не выделено");
                alert.setHeaderText("Выберете пользователя");
                alert.setContentText("Выберете пользователя в таблице");
                alert.showAndWait();
            }
        };
        operationable.operation(actionEvent);
    }

    public void changeUserBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            int selectedIndex = usersTable.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0){
                Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
                stage.setTitle("Измените пользователя");
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../views/changeUserView.fxml"));
                Parent root = loader.load();
                ChangeUserController controller = loader.getController();
                controller.setCurrentUser(currentUser);
                stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
                System.out.println("Log comeback to auth form");
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(null);
                alert.setTitle("Не выделено");
                alert.setHeaderText("Выберете пользователя");
                alert.setContentText("Выберете пользователя в таблице");
                alert.showAndWait();
                {}
            }
        };
        operationable.operation(actionEvent);
    }

    public static void deleteUser(User currentUser) throws SQLException {
        repository.delete((int) currentUser.getId());
    }
}
