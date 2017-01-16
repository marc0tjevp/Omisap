package nl.scalda.pasimo.service;

public class Service {

    private static Service instance = null;

    private Service() {
    }

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public CoachGroupService getCategoryService() {
        return CoachGroupService.getInstance();
    }

}
