package project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import project.Interfaces.Operationable;
import project.models.Role;
import project.models.User;

import java.io.IOException;
import java.sql.SQLException;

public class StartPageController {
    private Operationable operationable;

    @FXML
    private Button workerBtn;


    public void workerBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
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

    public void infoActionButton(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Информация");
            alert.setHeaderText("Добро пожаловать!");
            alert.setContentText("На этой страницей вы можете указать свою роль");
            alert.showAndWait();
        };
        operationable.operation(actionEvent);
    }

    public void guestBtnAction(ActionEvent actionEvent) throws IOException, SQLException {
        operationable = o -> {
            Stage stage = ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            stage.setTitle("Главная страница (Гость)");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../views/tableForGuestView.fxml"));
            Parent root = loader.load();
            TableController controller = loader.getController();
            User guestUser = new User();
            guestUser.setRole(Role.GUEST);
            controller.setCurrentUser(guestUser);
            stage.setScene(new Scene(root, stage.getScene().getWidth(), stage.getScene().getHeight()));
        };
        operationable.operation(actionEvent);
    }
}
