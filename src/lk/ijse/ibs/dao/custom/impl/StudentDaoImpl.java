package lk.ijse.ibs.dao.custom.impl;

import lk.ijse.ibs.dao.custom.StudentDao;
import lk.ijse.ibs.dao.db.ConnectionFactory;
import lk.ijse.ibs.dto.StudentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    private Connection connection;

    public StudentDaoImpl(){
        connection= ConnectionFactory.getInstance().getConnection();
    }
    @Override
    public boolean add(StudentDto dto) throws Exception {

        System.out.println("Student :"+dto);

        String SQL="Insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,dto.getStudentid());
        stm.setObject(2,dto.getNameinitials());
        stm.setObject(3,dto.getFullname());
        stm.setObject(4,dto.getNic());
        stm.setObject(5,dto.getAddress());
        stm.setObject(6,dto.getHomeno());
        stm.setObject(7,dto.getContact());
        stm.setObject(8,dto.getEmail());
        stm.setObject(9,dto.getDob());
        stm.setObject(10,dto.getGender());
        stm.setObject(11,dto.getSchool());
        stm.setObject(12,dto.getUni());
        stm.setObject(13,dto.getFac());
        stm.setObject(14,dto.getHigherquli());

        int res=stm.executeUpdate();
        if (res>0){
            return true;

        }
        return false;



    }

    @Override
    public boolean update(StudentDto dto) throws Exception {
        String SQL="update student set student_id=?,name_initilas=?,fullname=?,address=?,home_no=?,contact=?,email=?,dob=?,gender=?,school=?,university=?,faculty=?,higherquli=? where nic=?";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,dto.getStudentid());
        stm.setObject(2,dto.getNameinitials());
        stm.setObject(3,dto.getFullname());
        stm.setObject(4,dto.getAddress());
        stm.setObject(5,dto.getHomeno());
        stm.setObject(6,dto.getContact());
        stm.setObject(7,dto.getEmail());
        stm.setObject(8,dto.getDob());
        stm.setObject(9,dto.getGender());
        stm.setObject(10,dto.getSchool());
        stm.setObject(11,dto.getUni());
        stm.setObject(12,dto.getFac());
        stm.setObject(13,dto.getHigherquli());
        stm.setObject(14,dto.getNic());

        int res=stm.executeUpdate();

        if (res>0){
            return true;
        }
        return false;

    }

    @Override
    public StudentDto search(String name) throws Exception {
       String SQL="select * from student where fullname=?";
       PreparedStatement stm=connection.prepareStatement(SQL);
       stm.setObject(1,name);
        ResultSet rst=stm.executeQuery();

        if (rst.next()){
            StudentDto studentDto=new StudentDto(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12),rst.getString(13),rst.getString(14));
            return studentDto;
        }
        return null;
    }

    @Override
    public ArrayList<StudentDto> getAll() throws Exception {
        String SQL="select * from student";
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<StudentDto> alDetails=new ArrayList<>();

        while (rst.next()){
            StudentDto studentDto=new StudentDto(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12),rst.getString(13),rst.getString(14));
            alDetails.add(studentDto);

        }
        return alDetails;
    }

    @Override
    public StudentDto searchByNic(String nic) throws Exception {
        String SQL="select * from student where nic=?";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,nic);
        ResultSet rst=stm.executeQuery();

        if (rst.next()){
            StudentDto studentDto=new StudentDto(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getInt(6),rst.getInt(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11),rst.getString(12),rst.getString(13),rst.getString(14));
            return studentDto;
        }
        return null;
    }
}
