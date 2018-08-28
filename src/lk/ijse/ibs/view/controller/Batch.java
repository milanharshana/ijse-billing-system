package lk.ijse.ibs.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
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
import lk.ijse.ibs.controller.custom.BatchController;
import lk.ijse.ibs.controller.custom.CourseController;
import lk.ijse.ibs.dao.custom.BatchDao;
import lk.ijse.ibs.dao.custom.CourseDao;
import lk.ijse.ibs.dao.db.ConnectionFactory;
import lk.ijse.ibs.dto.BatchDto;
import lk.ijse.ibs.dto.CourseDto;
import lk.ijse.ibs.view.tablemodel.BatchTM;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Batch implements Initializable {
    @FXML
    private JFXTextField txtbatchid;

    @FXML
    private JFXTextField txtbatchName;

    @FXML
    private JFXTextField txtstatus;


    @FXML
    private JFXDatePicker txtstartDate;


    @FXML
    private JFXComboBox cmbcourse;



    @FXML
    private TableView<BatchTM> tblBatch;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtstudentLimit;

    private CourseController courseController;
    private BatchController batchController;

    private String courseid;

    public Batch(){
        courseController= (CourseController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.COURSE);
        batchController= (BatchController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.BATCH);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblBatch.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("batchid"));
        tblBatch.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("batchname"));
        tblBatch.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("course"));
        tblBatch.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));
        tblBatch.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("startdate"));

        loadCourses();
        loadAllBatches();

    }

    @FXML
    void btnAdd_OnAction(ActionEvent event) {
        BatchDto batchDto=new BatchDto(
                txtbatchid.getText(),
                txtbatchName.getText(),
               // cmbcourse.getSelectionModel().getSelectedItem().toString(),
                courseid,
                Integer.parseInt(txtstudentLimit.getText()),
                txtstatus.getText(),
                txtstartDate.getValue().toString());

        try {
            boolean result=batchController.add(batchDto);
            if (result){
                Image img=new Image("/lk/ijse/ibs/assest/correct.png");
                Notifications notifications=Notifications.create()
                        .title("Added Sucessfully")
                        .text("Batch has been saved")
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
                loadAllBatches();
                clearAll();

            }else{
                Image img=new Image("/lk/ijse/ibs/assest/error.png");
                Notifications notifications=Notifications.create()
                        .title("Failed")
                        .text("Batch has not saved")
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
    void btnUpdate_OnAction(ActionEvent event) {
        BatchDto batchDto=new BatchDto(
                txtbatchid.getText(),
                txtbatchName.getText(),
                cmbcourse.getSelectionModel().getSelectedItem().toString(),
                //courseid,
                Integer.parseInt(txtstudentLimit.getText()),
                txtstatus.getText(),
                txtstartDate.getValue().toString());

        try {
            boolean result=batchController.update(batchDto);
            if (result){
                Image img=new Image("/lk/ijse/ibs/assest/correct.png");
                Notifications notifications=Notifications.create()
                        .title("Added Sucessfully")
                        .text("Batch has been Updated")
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
                loadAllBatches();
                clearAll();

            }else {
                Image img=new Image("/lk/ijse/ibs/assest/error.png");
                Notifications notifications=Notifications.create()
                        .title("Failed")
                        .text("Batch has not Updated")
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
    void txtbatchName_OnAction(ActionEvent event) {


        try {
            String batchName=txtbatchName.getText();
            BatchDto batchDto=batchController.search(batchName);

            if (batchDto != null){
                txtbatchid.setText(batchDto.getBatchid());
                txtstudentLimit.setText(batchDto.getStudentlimit()+"");
                cmbcourse.setValue(batchDto.getCourseid());
                txtstatus.setText(batchDto.getStatus());
                String date=batchDto.getStartdate();
                txtstartDate.setValue(LocalDate.parse(date));

            }else {

                Image img=new Image("/lk/ijse/ibs/assest/error.png");
                Notifications notifications=Notifications.create()
                        .title("Search Error")
                        .text("You search Batch is not in the Customer List..")
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
    void cmbcourse_OnAction(ActionEvent event) {

        String cid=cmbcourse.getSelectionModel().getSelectedItem().toString();
        if(cid !=null){
            try {
                CourseDto courseDto=courseController.search(cid);
                if (courseDto != null){
                    this.courseid=courseDto.getCourse_id();
                   // System.out.println(courseDto.getCourse_id());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public  void loadCourses(){
        try {
            ArrayList<CourseDto> cList = courseController.getAll();
            for (CourseDto c1: cList) {
                cmbcourse.getItems().add(c1.getCourse_name());
               // System.out.println("names :"+c1.getCourse_name());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void loadAllBatches(){
        try {
            ArrayList<BatchDto> alBatches=batchController.getAll();
            ObservableList<BatchTM> batches=tblBatch.getItems();

            batches.removeAll(batches);

            for (BatchDto b :alBatches) {
                batches.add(new BatchTM(b.getBatchid(),b.getBatchname(),b.getCourseid(),b.getStatus(),b.getStartdate()));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearAll(){
       // txtstartDate.setValue("",(""));
        txtstatus.setText("");
        txtstudentLimit.setText("");
        txtbatchid.setText("");
        txtbatchName.setText("");
        cmbcourse.setValue("");
    }


}
