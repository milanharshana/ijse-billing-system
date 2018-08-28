package lk.ijse.ibs.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.transitions.JFXFillTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (s != null){
            mainPane.getChildren().remove(s);
        }

        try {
            s=FXMLLoader.load(getClass().getResource("../Home.fxml"));
            JFXFillTransition jfxFillTransition = new JFXFillTransition();
            jfxFillTransition.setDuration(Duration.millis(2000));
            mainPane.getChildren().add(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }

    @FXML
    private JFXButton btnHome;

    @FXML
    private JFXButton btnRStudent;

    @FXML
    private JFXButton btnPayment;

    @FXML
    private JFXButton btnCourse;

    @FXML
    private JFXButton BtnBatch;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnExit;

    public static Stage parentWindow;

    @FXML
    void BtnBatch_OnAction(ActionEvent event) {
        if (s != null){
            mainPane.getChildren().remove(s);
        }

        try {
            s=FXMLLoader.load(getClass().getResource("../Batch.fxml"));
            JFXFillTransition jfxFillTransition = new JFXFillTransition();
            jfxFillTransition.setDuration(Duration.millis(2000));
            mainPane.getChildren().add(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }

    @FXML
    void btnCourse_OnAction(ActionEvent event) {
        if (s != null){
            mainPane.getChildren().remove(s);
        }

        try {
            s=FXMLLoader.load(getClass().getResource("../Course.fxml"));
            JFXFillTransition jfxFillTransition = new JFXFillTransition();
            jfxFillTransition.setDuration(Duration.millis(2000));
            mainPane.getChildren().add(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

    @FXML
    void btnExit_OnAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnHome_OnAction(ActionEvent event) {
        if (s != null){
            mainPane.getChildren().remove(s);
        }

        try {
            s=FXMLLoader.load(getClass().getResource("../Home.fxml"));
            JFXFillTransition jfxFillTransition = new JFXFillTransition();
            jfxFillTransition.setDuration(Duration.millis(2000));
            mainPane.getChildren().add(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }



    }

    @FXML
    void btnLogOut_OnAction(ActionEvent event) {

    }

    @FXML
    void btnPayment_OnAction(ActionEvent event) {
        if (s != null){
            mainPane.getChildren().remove(s);
        }

        try {
            s=FXMLLoader.load(getClass().getResource("../Payment.fxml"));
            JFXFillTransition jfxFillTransition = new JFXFillTransition();
            jfxFillTransition.setDuration(Duration.millis(2000));
            mainPane.getChildren().add(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }

    Node s;
    @FXML
    void btnRStudent_OnAction(ActionEvent event) {
        if (s != null){
            mainPane.getChildren().remove(s);
        }

        try {
            s=FXMLLoader.load(getClass().getResource("../RegStudent.fxml"));
            JFXFillTransition jfxFillTransition = new JFXFillTransition();
            jfxFillTransition.setDuration(Duration.millis(2000));
            mainPane.getChildren().add(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }




}
