package lk.ijse.ibs.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.ibs.controller.ControllerFactory;
import lk.ijse.ibs.controller.custom.*;
import lk.ijse.ibs.dto.*;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainRegistration implements Initializable {

    private CourseController courseController;
    private BatchController batchController;
    private StudentController studentController;
    private GuardianController guardianController;
    private RegistrationController registrationController;

    @FXML
    private TextField txtNameInitials;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtHomeNo;

    @FXML
    private TextField txtContactNo;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtSchool;

    @FXML
    private TextField txtUni;

    @FXML
    private TextField txtfac;

    @FXML
    private JFXCheckBox checkMale;

    @FXML
    private JFXCheckBox checkFeMale;

    @FXML
    private JFXCheckBox checkOl;

    @FXML
    private JFXCheckBox checkMaster;

    @FXML
    private JFXCheckBox ckeckAl;

    @FXML
    private JFXCheckBox checkDegree;

    @FXML
    private JFXCheckBox checkDiploma;

    @FXML
    private JFXCheckBox checkOther;

    @FXML
    private TextField txtGuardiantId;

    @FXML
    private TextField txtGuardiantName;

    @FXML
    private TextField txtContact1;

    @FXML
    private TextField txtContact2;

    @FXML
    private TextField txtDesignation;

    @FXML
    private TextField txtWorkingPlace;

    @FXML
    private TextField txtRegId;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtRegFee;

    @FXML
    private JFXDatePicker dateCurdate;

    @FXML
    private JFXComboBox cmbCourse;

    @FXML
    private JFXComboBox cmbBatch;

    @FXML
    private JFXButton btnRegister;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseController= (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.COURSE);
        batchController= (BatchController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.BATCH);
        studentController= (StudentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.STUDENT);
        guardianController= (GuardianController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.GUARDIAN);
        registrationController= (RegistrationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.REGISTRATION);

        loadAllCourses();
        loadAllBatches();

    }

    @FXML
    void btnRegister_OnAction(ActionEvent event) {


        try {
            StudentDto studentDto=new StudentDto(
                    txtStudentID.getText(),
                    txtNameInitials.getText(),
                    txtFullName.getText(),
                    txtNic.getText(),
                    txtAddress.getText(),
                    Integer.parseInt(txtHomeNo.getText()),
                    Integer.parseInt(txtContactNo.getText()),
                    txtEmail.getText(),
                    txtDob.getText(),
                    "",
                    txtSchool.getText(),
                    txtUni.getText(),
                    txtfac.getText(),
                    "");

            GuardiantDto guardiantDto=new GuardiantDto(
                    txtGuardiantId.getText(),
                    txtStudentID.getText(),
                    txtGuardiantName.getText(),
                    txtContact1.getText(),
                    txtContact2.getText(),
                    txtDesignation.getText(),
                    txtWorkingPlace.getText(),
                    txtAddress.getText());


            RegistrationDto registrationDto=new RegistrationDto(
                    txtRegId.getText(),
                    txtStudentID.getText(),
                    dateCurdate.getValue().toString(),
                    txtRegFee.getText(),
                    cmbBatch.getSelectionModel().getSelectedItem().toString());

            boolean saveRegistration=registrationController.saveRegister(studentDto,guardiantDto,registrationDto);


            if (saveRegistration){
                Image img=new Image("/lk/ijse/ibs/assest/correct.png");
                Notifications notifications=Notifications.create()
                        .title(" Sucessfully")
                        .text("Registration was sucess")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.CENTER)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                //System.out.println("Clicked on Notification");

                            }

                        });
                notifications.darkStyle();
                notifications.show();
            }else {
                Image img=new Image("/lk/ijse/ibs/assest/error.png");
                Notifications notifications=Notifications.create()
                        .title("Failed")
                        .text("Registration is Failed")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.BOTTOM_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("Clicked on Notification");

                            }

                        });
                notifications.darkStyle();
                notifications.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void loadAllCourses(){
        try {
            ArrayList<CourseDto> cList = courseController.getAll();
            for (CourseDto c1: cList) {
                cmbCourse.getItems().add(c1.getCourse_name());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadAllBatches(){
        try {
            ArrayList<BatchDto> cList = batchController.getAll();
            for (BatchDto c1: cList) {
                cmbBatch.getItems().add(c1.getBatchname());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
