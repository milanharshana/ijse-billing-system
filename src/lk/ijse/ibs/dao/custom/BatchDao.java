package lk.ijse.ibs.dao.custom;

import lk.ijse.ibs.dao.SuperDao;
import lk.ijse.ibs.dto.BatchDto;

import java.util.ArrayList;

public interface BatchDao extends SuperDao<BatchDto> {
    @Override
    default boolean add(BatchDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean update(BatchDto dto) throws Exception {
        return false;
    }

    @Override
    default boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    default BatchDto search(String name) throws Exception {
        return null;
    }

    @Override
    default ArrayList<BatchDto> getSearched(BatchDto dto) throws Exception {
        return null;
    }

    @Override
    default ArrayList<BatchDto> getAll() throws Exception {
        return null;
    }
}
