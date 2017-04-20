/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;

/**
 *
 * @author jeroe
 */
public class MYSQLDAOLessonGroup implements IDAOLessonGroup {

    private static MYSQLDAOLessonGroup instance = null;

    @Override
    public void create(LessonGroup LessonGroup) {

    }

    @Override
    public void update(LessonGroup lessonGroup) {

    }

    @Override
    public void delete(LessonGroup LessonGroup) {

    }

    public static MYSQLDAOLessonGroup getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOLessonGroup();
        }
        return instance;
    }

	@Override
	public LessonGroup readLessonGroupByName(String lessonGroupName) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public LessonGroup read(LessonGroup lessonGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<LessonGroup> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<LessonGroup> readAllByCoachGroup(CoachGroup coachGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
