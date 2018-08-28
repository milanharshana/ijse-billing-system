package lk.ijse.ibs.dao.custom.impl;

import lk.ijse.ibs.dao.custom.GuardianDao;
import lk.ijse.ibs.dao.db.ConnectionFactory;
import lk.ijse.ibs.dto.GuardiantDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class GuardianDaoImpl implements GuardianDao {

    private Connection connection;

    public  GuardianDaoImpl(){
        connection= ConnectionFactory.getInstance().getConnection();
    }


    @Override
    public boolean add(GuardiantDto dto) throws Exception {

        System.out.println("Gurd : " +dto);

        String SQL="insert into gardiant values(?,?,?,?,?,?,?,?)";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,dto.getGuardiantid());
        stm.setObject(2,dto.getStudentid());
        stm.setObject(3,dto.getGuardiantname());
        stm.setObject(4,dto.getHomeno());
        stm.setObject(5,dto.getContact());
        stm.setObject(6,dto.getDesignation());
        stm.setObject(7,dto.getWorkingplace());
        stm.setObject(8,dto.getAddress());

        int res=stm.executeUpdate();
        if (res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(GuardiantDto dto) throws Exception {
       // String SQL="update gardiant set ";
        return false;
    }

    @Override
    public GuardiantDto search(String name) throws Exception {
        return null;
    }

    @Override
    public ArrayList<GuardiantDto> getAll() throws Exception {
        return null;
    }
}
