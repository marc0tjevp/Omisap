package nl.scalda.pasimo.service;

import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.interfaces.ILessonGroupService;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;


public class LessonGroupService implements ILessonGroupService {

    private static LessonGroupService instance = null;

    private LessonGroupService() {
        DAOFactory.setTheFactory(TestDAOFactory.getInstance());
    }

    public static LessonGroupService getInstance() {
        if (instance == null) {
            instance = new LessonGroupService();
        }

        return instance;
    }

    @Override
    public void create(LessonGroup lessonGroup) {
    	/*
    	 * Coachgroeps iets?
    	 */

    	
        DAOFactory.getTheFactory().getDAOLessonGroup().create(lessonGroup);
    }

    @Override
    public LessonGroup read(LessonGroup lessonGroup) {
    	return null;
    }

    @Override
    public void update(LessonGroup newLessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().update(newLessonGroup);
    }

    @Override
    public void delete(LessonGroup lessonGroup) {
        DAOFactory.getTheFactory().getDAOLessonGroup().delete(lessonGroup);
    }

	@Override
	public TreeMap<CoachGroup, TreeSet<LessonGroup>> readAll() {
		TreeMap<CoachGroup, TreeSet<LessonGroup>> lessonGroups = new TreeMap<>();
		
		/*
		 * TODO Get all coach groups
		 */
		TreeSet<CoachGroup> coachGroups = null;
		for(CoachGroup coachGroup : coachGroups) {
			lessonGroups.put(coachGroup, coachGroup.getLessonGroups());
		}
		
		//DAOFactory.getTheFactory().getDAOLessonGroup().readAll();
		return null;
	}
}