package lk.ijse.ibs.controller.custom.impl;

import lk.ijse.ibs.controller.custom.GuardianController;
import lk.ijse.ibs.dao.DaoFactory;
import lk.ijse.ibs.dao.custom.GuardianDao;
import lk.ijse.ibs.dto.GuardiantDto;

import java.util.ArrayList;

public class GuardiantControllerImpl implements GuardianController {
    private GuardianDao guardianDao;

    public GuardiantControllerImpl(){
        guardianDao= (GuardianDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.GUARDIAN);
    }
    @Override
    public boolean add(GuardiantDto dto) throws Exception {
        System.out.println(dto);
        return guardianDao.add(dto);

    }

    @Override
    public boolean update(GuardiantDto dto) throws Exception {
        return false;
    }

    @Override
    public GuardiantDto search(String name) throws Exception {
        return null;
    }

    @Override
    public ArrayList<GuardiantDto> getAll() throws Exception {
        return null;
    }
}
