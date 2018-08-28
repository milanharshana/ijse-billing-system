package lk.ijse.ibs.dao.custom.impl;

import lk.ijse.ibs.dao.custom.BatchDao;
import lk.ijse.ibs.dao.db.ConnectionFactory;
import lk.ijse.ibs.dto.BatchDto;
import lk.ijse.ibs.dto.CourseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BatchDaoImpl implements BatchDao {

    private Connection connection;

    public BatchDaoImpl() {
        connection= ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(BatchDto dto) throws Exception {
        String SQL="Insert into batch values(?,?,?,?,?,?)";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,dto.getBatchid());
        stm.setObject(2,dto.getBatchname());
        stm.setObject(3, dto.getCourseid());
        stm.setObject(4,dto.getStudentlimit());
        stm.setObject(5,dto.getStatus());
        stm.setObject(6,dto.getStartdate());

        int res=stm.executeUpdate();
        if (res>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(BatchDto dto) throws Exception {
       String SQL="update batch set batchid=?,cId =?,studentlimit =?,status =?,startdate =? where batchname=?";
       PreparedStatement stm=connection.prepareStatement(SQL);
       stm.setObject(1,dto.getBatchid());
       stm.setObject(2,dto.getCourseid());
       stm.setObject(3,dto.getStudentlimit());
       stm.setObject(4,dto.getStatus());
       stm.setObject(5,dto.getStartdate());
       stm.setObject(6,dto.getBatchname());
       int res=stm.executeUpdate();
       if (res>0){
           return true;
       }
       return false;
    }

    @Override
    public boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    public BatchDto search(String name) throws Exception {
       String SQL="select * from batch where batchname=?";
       PreparedStatement stm=connection.prepareStatement(SQL);
       stm.setObject(1,name);
       ResultSet rst=stm.executeQuery();

       if (rst.next()){
           BatchDto dto=new BatchDto(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6));
           return dto;
           }
           return null;

    }

    @Override
    public ArrayList<BatchDto> getSearched(BatchDto dto) throws Exception {
        return null;
    }

    @Override
    public ArrayList<BatchDto> getAll() throws Exception {
       String SQL="select * from batch";
       Statement stm=connection.createStatement();
       ResultSet rst=stm.executeQuery(SQL);
       ArrayList<BatchDto> alDetails=new ArrayList<>();
       while (rst.next()){
           BatchDto dto=new BatchDto(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6));
           alDetails.add(dto);

       }
       return alDetails;
    }
}
