package controller;

import enumTypes.Position;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import util.ServiceUtil;

import java.io.IOException;


/**
 * Created by Yura on 05.02.2017.
 */
public class EnterController {
    @FXML TextField loginField;
    @FXML PasswordField passwordField;
    @FXML Button enterButton;
    @FXML Button cancelButton;
    private int counter = 5;

    @FXML
    private void onActionLog() {
        System.out.println(loginField.getText());
    }
    @FXML
    private void onActionPass() {
        System.out.println(passwordField.getText());
    }

    @FXML
    private void onActionEnter() {
        Parent root = null;
        Stage stage = new Stage();
        Position position = ServiceUtil.getUserService().isUser(loginField.getText(), passwordField.getText());

        if (position == null) {
            try {
                root = FXMLLoader.load(getClass().getResource("/view/accessDenied.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/view/adminWindow.css");
            stage.setScene(scene);
            stage.setTitle("Login error");
            stage.show();
            stage.setResizable(false);
            loginField.clear();
            passwordField.clear();
        } else {
            switch (position) {
                case ADMIN:
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/adminWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    stage.setTitle("Admin window");
                    scene.getStylesheets().add("/view/adminWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
                case MANAGER:
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/managerWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scene = new Scene(root);
                    stage.setTitle("Manager window");
                    scene.getStylesheets().add("/view/adminWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
                case CASHIER:
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/sellerWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scene = new Scene(root);
                    stage.setTitle("Cashier window");
                    scene.getStylesheets().add("/view/sellerWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
            }
        }
    }
    @FXML
    private void onActionCancel() {
        System.exit(0);
    }
}
