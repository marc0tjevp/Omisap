package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;

public class TestDAOLessonGroup implements IDAOLessonGroup{
	
	private static TestDAOLessonGroup instance = null;
	
	private TestDAOLessonGroup() {
		
	}
	
	public static TestDAOLessonGroup getInstance() {
		if(instance == null) {
			instance = new TestDAOLessonGroup();
		}
		return instance;
	}

	@Override
	public void create(LessonGroup lessonGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LessonGroup read(LessonGroup lessonGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(LessonGroup oldLessonGroup, LessonGroup newLessonGroup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LessonGroup lessonGroup) {
		// TODO Auto-generated method stub
		
	}
	
}
