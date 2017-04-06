package nl.scalda.pasimo.service;

public class Service {

    private static Service instance = null;

    private Service() {}
    
    public TeacherService getTeacherService() {
        return TeacherService.getInstance();
    }
    
    public NoteService getNoteService(){
    	return NoteService.getInstance();
    }

    public static Service getInstance() {
        if (instance == null)
            instance = new Service();
        return instance;
    }
    
    public EducationTeamService getEducationTeamService() {
        return EducationTeamService.getInstance();
    }

    public CoachGroupService getCoachGroupService() {
        return CoachGroupService.getInstance();
    }

    public LessonGroupService getLessonGroupService() {
        return LessonGroupService.getInstance();
    }

}
