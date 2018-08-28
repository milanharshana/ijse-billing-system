package lk.ijse.ibs.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import lk.ijse.ibs.controller.ControllerFactory;
import lk.ijse.ibs.controller.custom.CourseController;
import lk.ijse.ibs.dto.CourseDto;
import lk.ijse.ibs.view.tablemodel.CourseTM;
import org.controlsfx.control.Notifications;


import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Course implements Initializable {

    private CourseController courseController;

    @FXML
    private JFXTextField txtCourseid;

    @FXML
    private JFXTextField txtCourseName;

    @FXML
    private JFXTextField txtCourseFee;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private TableView<CourseTM> tblCourse;

    @FXML
    private JFXButton BtnAdd;

    @FXML
    private JFXButton BtnUpdate;

    @FXML
    private JFXComboBox cmbCourseType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbCourseType.getItems().add("FullTime");
        cmbCourseType.getItems().add("PartTime");

        courseController= (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.COURSE);

        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseid"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("coursename"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("coursetype"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblCourse.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("coursefee"));

        loadAllCourses();

    }
    @FXML
    void txtCourseName_OnAction(ActionEvent event) {


        try {
            String courseName=txtCourseName.getText();
            CourseDto courseDto=courseController.search(courseName);

            if (courseDto != null) {

                txtCourseid.setText(courseDto.getCourse_id());
                cmbCourseType.setValue(courseDto.getCourse_type());
                txtDuration.setText(courseDto.getDuration());
                txtCourseFee.setText(courseDto.getCourse_fee());
            }else{

                Image img=new Image("/lk/ijse/ibs/assest/error.png");
                Notifications notifications=Notifications.create()
                        .title("Search Error")
                        .text("You search Customer is not in the Customer List..")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
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


    @FXML
    void BtnAdd_OnAction(ActionEvent event) {
        CourseDto courseDto=new CourseDto(
                txtCourseid.getText(),
                txtCourseName.getText(),
                cmbCourseType.getSelectionModel().getSelectedItem().toString(),
                txtCourseFee.getText(),
                txtDuration.getText());

        try {
            boolean result=courseController.add(courseDto);
            if (result){
                Image img=new Image("/lk/ijse/ibs/assest/correct.png");
                Notifications notifications=Notifications.create()
                        .title("Added Sucessfully")
                        .text("Course has been saved")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("Clicked on Notification");

                            }

                        });
                notifications.darkStyle();
                notifications.show();
                clearAll();
                loadAllCourses();
               // JOptionPane.showMessageDialog(null,"course added");
            }else{
                Image img=new Image("/lk/ijse/ibs/assest/error.png");
                Notifications notifications=Notifications.create()
                        .title("Failed")
                        .text("Course has not saved")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("Clicked on Notification");

                            }

                        });
                notifications.darkStyle();
                notifications.show();
                //JOptionPane.showMessageDialog(null,"course added failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void BtnUpdate_OnAction(ActionEvent event) {

        try {
            String cid=txtCourseid.getText();
            String cname=txtCourseName.getText();
            String coursefee=txtCourseFee.getText();
            String coursetype=cmbCourseType.getSelectionModel().getSelectedItem().toString();
            String duration=txtDuration.getText();

            CourseDto dto=new CourseDto(cid,cname,coursetype,coursefee,duration);

            boolean res=courseController.update(dto);

            if (res){
                Image img=new Image("/lk/ijse/ibs/assest/correct.png");
                Notifications notifications=Notifications.create()
                        .title("Added Sucessfully")
                        .text("Course has been Updated")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                System.out.println("Clicked on Notification");

                            }

                        });
                notifications.darkStyle();
                notifications.show();
                clearAll();
                loadAllCourses();


            }else {
                Image img=new Image("/lk/ijse/ibs/assest/error.png");
                Notifications notifications=Notifications.create()
                        .title("Failed")
                        .text("Course has not updated")
                        .graphic(new ImageView(img))
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
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

    private void loadAllCourses(){
        try {
            ArrayList<CourseDto> alCourses=courseController.getAll();
            ObservableList<CourseTM> courses=tblCourse.getItems();
            courses.removeAll(courses);

            for (CourseDto c: alCourses) {
                courses.add(new CourseTM(c.getCourse_id(),c.getCourse_name(),c.getCourse_type(),c.getDuration(),c.getCourse_fee()));
                System.out.println("course names"+c.getCourse_name());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearAll(){
        txtCourseid.setText("");
        txtDuration.setText("");
        txtCourseFee.setText("");
        txtCourseName.setText("");
        cmbCourseType.setValue("");

    }



}

