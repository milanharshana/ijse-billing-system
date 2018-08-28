package lk.ijse.ibs.controller.custom.impl;

import lk.ijse.ibs.controller.custom.BatchController;
import lk.ijse.ibs.dao.DaoFactory;
import lk.ijse.ibs.dao.custom.BatchDao;
import lk.ijse.ibs.dto.BatchDto;

import java.util.ArrayList;

public class BatchControllerImpl implements BatchController {

    private BatchDao batchDao;

    public BatchControllerImpl(){
        batchDao= (BatchDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.BATCH);
    }

    @Override
    public boolean add(BatchDto dto) throws Exception {
        return batchDao.add(dto);
    }

    @Override
    public boolean update(BatchDto dto) throws Exception {
       return batchDao.update(dto);
    }

    @Override
    public boolean delete(String name) throws Exception {
        return false;
    }

    @Override
    public BatchDto search(String name) throws Exception {
        return batchDao.search(name);
    }

    @Override
    public ArrayList<BatchDto> getSearched(BatchDto dto) throws Exception {
        return null;
    }

    @Override
    public ArrayList<BatchDto> getAll() throws Exception {
        return batchDao.getAll();
    }
}
