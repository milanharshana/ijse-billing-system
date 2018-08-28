package lk.ijse.ibs.dao.custom.impl;

import lk.ijse.ibs.dao.custom.CourseDao;
import lk.ijse.ibs.dao.db.ConnectionFactory;
import lk.ijse.ibs.dto.CourseDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDaoImpl implements CourseDao {

    private Connection connection;

    public CourseDaoImpl(){
        connection= ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    public CourseDto search(String name) throws Exception {
        String SQL="select * from course where courseName=?";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,name);
        ResultSet rst=stm.executeQuery();
        CourseDto c=null;
        if (rst.next()){
            c=new CourseDto(rst.getString(1),rst.getString(2),rst.getString(4),rst.getString(3),rst.getString(5));

        }
        return c;


    }

    @Override
    public boolean add(CourseDto dto) throws Exception {
        String SQL="INSERT INTO course VALUES (?,?,?,?,?)";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,dto.getCourse_id());
        stm.setObject(2,dto.getCourse_name());
        stm.setObject(3,dto.getCourse_fee());
        stm.setObject(4,dto.getCourse_type());
        stm.setObject(5,dto.getDuration());
        int res=stm.executeUpdate();
        return (res > 0);
    }

    @Override
    public boolean update(CourseDto dto) throws Exception {
        String SQL="update course set cId=?,coursefee=?,courseType=?,duration=? where cId=?";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1,dto.getCourse_id());
        stm.setObject(2,dto.getCourse_fee());
        stm.setObject(3,dto.getCourse_type());
        stm.setObject(4,dto.getDuration());
        stm.setObject(5,dto.getCourse_id());

        int res=stm.executeUpdate();
        if (res>0){
            return true;
        }
            return false;
    }



    @Override
    public ArrayList<CourseDto> getSearched(CourseDto dto) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CourseDto> getAll() throws Exception {
        String SQL="select * from course";
        Statement stm=connection.createStatement();
        ResultSet rst=stm.executeQuery(SQL);
        ArrayList<CourseDto>alDetails=new ArrayList<>();
        while (rst.next()){
            CourseDto details=new CourseDto(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5));
            alDetails.add(details);
        }
        return alDetails;
    }
}
