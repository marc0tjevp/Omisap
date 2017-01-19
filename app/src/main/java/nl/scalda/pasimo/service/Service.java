package nl.scalda.pasimo.service;

public class Service {

    private static Service instance = null;

    private Service() {}
    
    public TeacherService getTeacherService() {
        return TeacherService.getInstance();
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

}
