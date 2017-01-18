package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;

public interface IDAOLessonGroup {
	
	public void create(LessonGroup lessonGroup);
	
	public LessonGroup read(LessonGroup lessonGroup);
	
	public void update(LessonGroup oldLessonGroup, LessonGroup newLessonGroup);
	
	// TODO: fill delete parameters
	public void delete(LessonGroup lessonGroup);
	
}
