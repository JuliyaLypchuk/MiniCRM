package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by Yura on 05.02.2017.
 */
public class adminController {
    @FXML  private TextArea EmplArea;
    @FXML  private TextArea InfoArea;
    @FXML  private Button CreateButton;
    @FXML  private Button ChenButton;
    @FXML  private Button DelButton;
    @FXML  private Button GenButton;

    /*@FXML
    private void onActionCreate() {
        Parent root = null;
        Stage stage = new Stage();
        try{
            root = FXMLLoader.load(getClass().getResource("/view/createEmployeeWindow.fxml"));

        }catch (IOException e){e.printStackTrace();}
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/enterWindow.css");
        stage.setScene(scene);
        stage.show();
    }*/
    @FXML
    private void onActionCreate() {

    }
    @FXML
    private void onActionChen() {
    }
    @FXML
    private void onActionDel() {
    }
    @FXML
    private void onActionGen() {
    }
}
