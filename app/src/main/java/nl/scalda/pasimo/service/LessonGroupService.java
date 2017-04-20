package nl.scalda.pasimo.service;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.interfaces.ILessonGroupService;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Student;

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

	}

	@Override
	public LessonGroup read(LessonGroup lessonGroup) {
		return null;
	}

	public LessonGroup read(int id) {

		for (CoachGroup cg : CoachGroupService.getInstance().readAll()) {
			for (LessonGroup lg : cg.getLessonGroups()) {
				if (lg.getId() == id) {
					return lg;
				}
			}
		}
		return null;
	}

	// TODO Get rid of these DAO's
	@Override
	public void update(LessonGroup newLessonGroup) {
		DAOFactory.getTheFactory().getDAOLessonGroup().update(newLessonGroup);
	}

	@Override
	public void delete(LessonGroup lessonGroup) {
		DAOFactory.getTheFactory().getDAOLessonGroup().delete(lessonGroup);
	}

	@Override
	public TreeSet<CoachGroup> readAll() {
		TreeSet<CoachGroup> coachGroupsWithLessonGroups = new TreeSet<>();

		for (CoachGroup coachGroup : CoachGroupService.getInstance().readAll()) {
			coachGroup.loadLessonGroups();
			if (coachGroup.getLessonGroups().size() <= 0) {
				continue;
			}
			coachGroupsWithLessonGroups.add(coachGroup);
		}

		return coachGroupsWithLessonGroups;
	}

	public LessonGroup readByLessonGroupName(String lessonGroupName, String coachGroupName) {
		CoachGroup specificCoachGroup = CoachGroupService.getInstance().readCoachGroup(coachGroupName);
		if (specificCoachGroup == null) {
			return null;
		}
		return specificCoachGroup.getLessonGroupByName(lessonGroupName);
	}
}
