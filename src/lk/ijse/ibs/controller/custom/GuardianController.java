package lk.ijse.ibs.controller.custom;

import lk.ijse.ibs.controller.SuperController;
import lk.ijse.ibs.dto.GuardiantDto;

import java.util.ArrayList;

public interface GuardianController extends SuperController<GuardiantDto> {


    @Override
    default boolean add(GuardiantDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean update(GuardiantDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    default GuardiantDto search(String name) throws Exception {
        return null;
    }

    @Override
    default ArrayList<GuardiantDto> getSearched(GuardiantDto dto) throws Exception {
        return null;
    }

    @Override
    default ArrayList<GuardiantDto> getAll() throws Exception {
        return null;
    }
}
