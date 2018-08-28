package lk.ijse.ibs.controller;

import lk.ijse.ibs.controller.custom.impl.*;

public class ControllerFactory {
    public enum ControllerTypes{
        STUDENT, COURSE,GUARDIAN, REGISTRATION, PAYMENT, BATCH,STUDENTTRANSER
    }

    private static ControllerFactory controllerFactory;

    private ControllerFactory(){



    }

    public static ControllerFactory getInstance(){
        if (controllerFactory == null){
            controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }

    public SuperController getController(ControllerTypes controller) {
        switch (controller){
            case STUDENT:
                return new StudentControllerImpl();

            case COURSE:
                return new CourseControllerImpl();

            case BATCH:
               return new BatchControllerImpl();

            case GUARDIAN:
                return new GuardiantControllerImpl();
            case REGISTRATION:
                return new RegistrationControllerImpl();
            default:
                return null;
        }
    }
}
