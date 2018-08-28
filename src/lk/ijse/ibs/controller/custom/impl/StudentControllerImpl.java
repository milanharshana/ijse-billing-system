package lk.ijse.ibs.controller.custom.impl;

import lk.ijse.ibs.controller.ControllerFactory;
import lk.ijse.ibs.controller.custom.StudentController;
import lk.ijse.ibs.dao.DaoFactory;
import lk.ijse.ibs.dao.custom.StudentDao;
import lk.ijse.ibs.dto.StudentDto;

import java.util.ArrayList;

public class StudentControllerImpl implements StudentController {

    private StudentDao studentDao;

    public StudentControllerImpl(){
        studentDao= (StudentDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.STUDENT);
    }
    @Override
    public boolean add(StudentDto dto) throws Exception {
        System.out.println(dto);
        return studentDao.add(dto);
    }

    @Override
    public boolean update(StudentDto dto) throws Exception {
        return false;
    }

    @Override
    public StudentDto search(String name) throws Exception {
        return null;
    }

    @Override
    public ArrayList<StudentDto> getAll() throws Exception {
        return null;
    }
}
