package nl.scalda.pasimo.service;

import nl.scalda.pasimo.employeemanagement.service.NoteService;

public class Service {

    private static Service instance = null;

    private Service() {
    }
    
    public NoteService getNoteService(){
    	return NoteService.getInstance();
    };

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

}
