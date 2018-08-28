package lk.ijse.ibs.controller.custom.impl;

import lk.ijse.ibs.controller.custom.RegistrationController;
import lk.ijse.ibs.dao.DaoFactory;
import lk.ijse.ibs.dao.custom.GuardianDao;
import lk.ijse.ibs.dao.custom.RegistrationDao;
import lk.ijse.ibs.dao.custom.StudentDao;
import lk.ijse.ibs.dao.db.ConnectionFactory;
import lk.ijse.ibs.dto.GuardiantDto;
import lk.ijse.ibs.dto.RegistrationDto;
import lk.ijse.ibs.dto.StudentDto;

import java.sql.Connection;
import java.util.ArrayList;

public class RegistrationControllerImpl implements RegistrationController {
    private RegistrationDao registrationDao;
    private GuardianDao guardianDao;
    private StudentDao studentDao;
    private Connection connection;

    public RegistrationControllerImpl() {
        guardianDao = (GuardianDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.GUARDIAN);
        studentDao = (StudentDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.STUDENT);
        registrationDao = (RegistrationDao) DaoFactory.getInstance().getDAO(DaoFactory.DAOTypes.REGISTRATION);
        connection = ConnectionFactory.getInstance().getConnection();
    }


    @Override
    public boolean add(RegistrationDto dto) throws Exception {
        System.out.println("fghjk" + dto);
        return registrationDao.add(dto);
    }

    @Override
    public boolean update(RegistrationDto dto) throws Exception {
        return false;
    }

    @Override
    public RegistrationDto search(String name) throws Exception {
        return null;
    }

    @Override
    public ArrayList<RegistrationDto> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean saveRegister(StudentDto sdto, GuardiantDto gdto, RegistrationDto rdto) throws Exception {
        connection.setAutoCommit(false);

//        System.out.println(sdto);
//        System.out.println(rdto);
//        System.out.println(gdto);

        try {

            StudentDto studentDto = new StudentDto(
                    sdto.getStudentid(),
                    sdto.getNameinitials(),
                    sdto.getFullname(),
                    sdto.getNic(),
                    sdto.getAddress(),
                    sdto.getHomeno(),
                    sdto.getContact(),
                    sdto.getEmail(),
                    sdto.getDob(),
                    sdto.getGender(),
                    sdto.getSchool(),
                    sdto.getUni(),
                    sdto.getFac(),
                    sdto.getHigherquli());

            GuardiantDto guardiantDto = new GuardiantDto(
                    gdto.getGuardiantid(),
                    gdto.getStudentid(),
                    gdto.getGuardiantname(),
                    gdto.getHomeno(),
                    gdto.getContact(),
                    gdto.getDesignation(),
                    gdto.getWorkingplace(),
                    gdto.getAddress());

            RegistrationDto registrationDto = new RegistrationDto(
                    rdto.getRegid(),
                    rdto.getStudentid(),
                    rdto.getRegdate(),
                    rdto.getRegfee(),
                    rdto.getBatchid());

            boolean studentAdd = studentDao.add(studentDto);
            //System.out.println(studentDto);
            if (studentAdd) {
                boolean guardiantAdd = guardianDao.add(guardiantDto);
                // System.out.println(guardiantDto);
                if (guardiantAdd) {
                    boolean registrationAdd = registrationDao.add(registrationDto);
                    // System.out.println(registrationDto);
                    if (registrationAdd) {

                    } else {
                        connection.rollback();
                        return false;
                    }
                }

            }
                }finally{
                    connection.setAutoCommit(true);
                    return true;
                }
            }
        }






