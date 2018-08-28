package lk.ijse.ibs.dao;

import lk.ijse.ibs.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory factory;

    public enum DAOTypes{
        STUDENT, COURSE,GUARDIAN, REGISTRATION, PAYMENT, BATCH,STUDENTTRANSER, QUERY
    }

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        if (factory==null){
            factory=new DaoFactory();
        }
        return factory;
    }

    public SuperDao getDAO(DAOTypes dao){
        switch (dao){
            case BATCH:
                return new BatchDaoImpl();
            case COURSE:
                return new CourseDaoImpl();
            case PAYMENT:
                return new PaymentDaoImpl();
            case REGISTRATION:
                return new RegistrationDaoImpl();
            case STUDENT:
                return new StudentDaoImpl();
            case GUARDIAN:
                return new GuardianDaoImpl();
            case STUDENTTRANSER:
                return new StudentTransferDaoImpl();
            default:
                        return null;

        }

    }

}
