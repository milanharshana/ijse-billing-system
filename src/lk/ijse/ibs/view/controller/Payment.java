package lk.ijse.ibs.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Payment implements Initializable {

    @FXML
    private JFXTextField txtNic;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtCourseName;

    @FXML
    private JFXTextField txtBatchName;

    @FXML
    private JFXTextField txtCourseFee;

    @FXML
    private JFXTextField txtPaid;

    @FXML
    private JFXTextField txtBalance;

    @FXML
    private JFXTextField txtDueDate;

    @FXML
    private JFXCheckBox chekFull;

    @FXML
    private JFXCheckBox checkPart;

    @FXML
    private JFXDatePicker dateCurant;

    @FXML
    private JFXTextField txtPaymentFee;

    @FXML
    private JFXTextField txtGovTax;

    @FXML
    private JFXTextField txtDiscount;

    @FXML
    private JFXTextField txtLateTax;

    @FXML
    private JFXTextField txtDiscountBalance;

    @FXML
    private JFXDatePicker dateDuedate;

    @FXML
    private JFXTextField txtGivenAmount;

    @FXML
    private JFXTextField txtTheBalance;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private JFXButton btnPayment;

    @FXML
    void btnPayment_OnAction(ActionEvent event) {

    }

    @FXML
    void txtName_OnAction(ActionEvent event) {

    }

    @FXML
    void txtNic_OnAction(ActionEvent event) {

    }

}
