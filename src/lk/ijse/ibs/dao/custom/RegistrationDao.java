package lk.ijse.ibs.dao.custom;

import lk.ijse.ibs.dao.SuperDao;
import lk.ijse.ibs.dto.GuardiantDto;
import lk.ijse.ibs.dto.RegistrationDto;
import lk.ijse.ibs.dto.StudentDto;

import java.util.ArrayList;

public interface RegistrationDao extends SuperDao<RegistrationDto> {

    @Override
    default boolean add(RegistrationDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean update(RegistrationDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    default RegistrationDto search(String name) throws Exception {
        return null;
    }

    @Override
    default ArrayList<RegistrationDto> getSearched(RegistrationDto dto) throws Exception {
        return null;
    }

    @Override
    default ArrayList<RegistrationDto> getAll() throws Exception {
        return null;
    }

    default boolean saveRegistere(StudentDto studentDto, GuardiantDto guardiantDto,RegistrationDto registrationDto)throws Exception{
        return false;
    }
}
