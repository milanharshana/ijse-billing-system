package lk.ijse.ibs.dao.custom;

import lk.ijse.ibs.dao.SuperDao;
import lk.ijse.ibs.dto.StudentTransferDto;

import java.util.ArrayList;

public interface StudentTransferDao extends SuperDao<StudentTransferDto> {
    @Override
    default boolean add(StudentTransferDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean update(StudentTransferDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    default StudentTransferDto search(String name) throws Exception {
        return null;
    }

    @Override
    default ArrayList<StudentTransferDto> getSearched(StudentTransferDto dto) throws Exception {
        return null;
    }

    @Override
    default ArrayList<StudentTransferDto> getAll() throws Exception {
        return null;
    }
}
