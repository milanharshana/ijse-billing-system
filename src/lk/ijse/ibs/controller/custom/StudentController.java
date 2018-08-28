package lk.ijse.ibs.controller.custom;

import lk.ijse.ibs.controller.SuperController;
import lk.ijse.ibs.dto.StudentDto;

import java.util.ArrayList;

public interface StudentController extends SuperController<StudentDto> {

    @Override
    default boolean add(StudentDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean update(StudentDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    default StudentDto search(String name) throws Exception {
        return null;
    }

    @Override
    default ArrayList<StudentDto> getSearched(StudentDto dto) throws Exception {
        return null;
    }

    @Override
    default ArrayList<StudentDto> getAll() throws Exception {
        return null;
    }
}
