package lk.ijse.ibs.controller.custom;

import lk.ijse.ibs.controller.SuperController;
import lk.ijse.ibs.dto.GuardiantDto;
import lk.ijse.ibs.dto.RegistrationDto;
import lk.ijse.ibs.dto.StudentDto;

import java.util.ArrayList;

public interface RegistrationController extends SuperController<RegistrationDto> {
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

    default boolean saveRegister(StudentDto sdto, GuardiantDto gdto,RegistrationDto rdto)throws Exception{
        return false;

    }


}
