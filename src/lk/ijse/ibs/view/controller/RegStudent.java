package lk.ijse.ibs.view.controller;

import com.jfoenix.transitions.JFXFillTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegStudent implements Initializable {

    static{
        newPane=new AnchorPane();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      newPane=s_mainPane;
        if (s != null){
            s_mainPane.getChildren().remove(s);
        }

        try {
            s= FXMLLoader.load(getClass().getResource("../MainRegistration.fxml"));
            JFXFillTransition jfxFillTransition = new JFXFillTransition();
            jfxFillTransition.setDuration(Duration.millis(2000));
            s_mainPane.getChildren().add(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }


    }

    @FXML
    private Label btnp_Detail;

    @FXML
    private Label btnE_Detail;

    @FXML
    private Label BtnD_Detail;

    @FXML
    public  AnchorPane s_mainPane;

    public static AnchorPane newPane;

    Node s;

    @FXML
    void BtnD_Detail_OnMouseClicked(MouseEvent event) {


    }



    @FXML
    void btnE_Detail_OnMouseClicked(MouseEvent event) {



    }


    @FXML
    void btnp_Detail_OnMouseClicked(MouseEvent event) {


    }
}
