package lk.ijse.ibs.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private ImageView btnClose;

    @FXML
    void btnClose_MouseClicked(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void btnLogin_OnAction(ActionEvent event) {

        try {
            Stage primaryStage=new Stage();
            Parent root= FXMLLoader.load(getClass().getResource("/lk/ijse/ibs/view/Dashboard.fxml"));

            Scene scene=new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();

            ((Stage) (((JFXButton) event.getSource()).getScene().getWindow())).hide();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
