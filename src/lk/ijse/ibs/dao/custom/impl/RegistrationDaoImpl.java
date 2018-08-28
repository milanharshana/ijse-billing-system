package lk.ijse.ibs.dao.custom.impl;

import lk.ijse.ibs.dao.custom.RegistrationDao;
import lk.ijse.ibs.dao.db.ConnectionFactory;
import lk.ijse.ibs.dto.GuardiantDto;
import lk.ijse.ibs.dto.RegistrationDto;
import lk.ijse.ibs.dto.StudentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.ArrayList;

public class RegistrationDaoImpl implements RegistrationDao {
    private Connection connection;

    public RegistrationDaoImpl(){
        connection= ConnectionFactory.getInstance().getConnection();
    }
    @Override
    public boolean add(RegistrationDto dto) throws Exception {
        System.out.println("registration : "+dto);

        String SQL="Insert into registers values(?,?,?,?,?)";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,dto.getRegid());
        stm.setObject(2,dto.getBatchid());
        stm.setObject(3,dto.getStudentid());
        stm.setObject(4,dto.getRegdate());
        stm.setObject(5,dto.getRegfee());
      int res=stm.executeUpdate();
      if (res>0){
          return true;
     }
     return false;

    }

    @Override
    public boolean update(RegistrationDto dto) throws Exception {
        return false;
    }

    @Override
    public RegistrationDto search(String name) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationDto> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean saveRegistere(StudentDto studentDto, GuardiantDto guardiantDto, RegistrationDto registrationDto) throws Exception {
//        Statement stm=connection.createStatement();
//        String SQL="update student set student_id=?,name_initilas=?,fullname=?,address=?,home_no=?,contact=?,email=?,dob=?,gender=?,school=?,university=?,faculty=?,higherquli=? where nic=?";
//        connection.setAutoCommit(false);

        return false;

    }
}
