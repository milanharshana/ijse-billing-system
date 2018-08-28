package lk.ijse.ibs.controller;

import lk.ijse.ibs.dto.SuperDto;

import java.util.ArrayList;

public interface SuperController<T extends SuperDto> {

    boolean add(T dto) throws Exception;

    boolean update(T dto) throws Exception;

    boolean delete(String name) throws Exception;

    T search(String name) throws Exception;

    ArrayList<T> getSearched(T dto) throws Exception;

    ArrayList<T> getAll() throws Exception;
}
