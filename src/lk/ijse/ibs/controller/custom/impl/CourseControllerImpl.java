package lk.ijse.ibs.controller.custom.impl;

import lk.ijse.ibs.controller.custom.CourseController;
import lk.ijse.ibs.dao.DaoFactory;
import lk.ijse.ibs.dao.custom.CourseDao;
import lk.ijse.ibs.dto.CourseDto;

import java.util.ArrayList;

public class CourseControllerImpl implements CourseController {
    private CourseDao courseDao;

    public CourseControllerImpl(){
        courseDao= (CourseDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.COURSE);
    }

    @Override
    public boolean add(CourseDto dto) throws Exception {
        return courseDao.add(dto);
    }

    @Override
    public boolean update(CourseDto dto) throws Exception {
        return courseDao.update(dto);
    }

    @Override
    public boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    public CourseDto search(String name) throws Exception {
       return courseDao.search(name);
    }

    @Override
    public ArrayList<CourseDto> getSearched(CourseDto dto) throws Exception {
        return null;
    }

    @Override
    public ArrayList<CourseDto> getAll() throws Exception {
        //System.out.println("sdfghjksdfgh");
        return courseDao.getAll();
    }
}
