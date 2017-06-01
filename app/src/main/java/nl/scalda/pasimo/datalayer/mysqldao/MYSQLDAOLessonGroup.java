/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.controller.employeemanagement.LessonGroupListingAction;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.LessonGroupService;

/**
 *
 * @author jeroen
 */
public class MYSQLDAOLessonGroup implements IDAOLessonGroup {

	private SessionFactory factory;

	private static MYSQLDAOLessonGroup instance = null;

	/*
	 * Creates the factory for the lessongroupDAO
	 */

	public MYSQLDAOLessonGroup() {
		initialiseFactory();
	}

	private void initialiseFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/*
	 * Method needed to create lessongroup with name and the coachgroup it's in
	 */
	@Override
	public void create(LessonGroup LessonGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO lessongroups (lessonGroupName, coachgroup_name) VALUES (:lessonGroupName, :coachgroup_name);";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("lessonGroupName", LessonGroup.getName());
			// query.setParameter("CoachGroup",
			// CoachGroupService.getInstance().readAll());
			query.executeUpdate();

			tx.commit();
			System.out.println("Created succesfully");
		} catch (HibernateException s) {
			if (tx != null) {
				tx.rollback();
			}
			s.printStackTrace();
		} finally {
			session.close();
		}
	}

	/*
	 * Updates the lessongroup by updating the name and/or coachgroup inside the
	 * lessongroup table
	 */
	@Override
	public void update(LessonGroup LessonGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "UPDATE lessongroup set name = :name, lessonGroupName :lessonGroupName;";
			NativeQuery query = session.createNativeQuery(sql);

			query.setParameter("lessonGroupName", LessonGroup.getName());
			// query.setParameter("CoachGroup",
			// CoachGroupService.getInstance().readAll());
			query.executeUpdate();

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
	/*
	 * Deletes the lessongroup from the table where the name equals the selected
	 * name
	 */

	@Override
	public void delete(LessonGroup LessonGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM lessongroups WHERE (lessonGroupName) = (:lessonGroupName")
					.setParameter("lessonGroupName", LessonGroup.getName()).executeUpdate();
			session.delete(LessonGroup);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {
			session.close();
		}
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
	public TreeSet<LessonGroup> readAll() {
		TreeSet<LessonGroup> LessonGroups = new TreeSet<>();
		return LessonGroups;

		// Session session = factory.openSession();
		// Transaction tx = null;
		// Set<LessonGroup> lessonGroups = new TreeSet<>();
		// try {
		// tx = session.beginTransaction();
		// List LessonGroupList = session.createNativeQuery("SELECT * FROM
		// lessongroups;").getResultList();
		// for (Iterator iterator = LessonGroupList.iterator();
		// iterator.hasNext();) {
		// Object[] obj = (Object[]) iterator.next();
		//
		// String coachGroupName = String.valueOf(obj[1]);
		// CoachGroup coachGroup =
		// CoachGroupService.getInstance().readCoachGroup(coachGroupName);
		//
		// LessonGroup lg = new LessonGroup(String.valueOf(obj[0]));
		// coachGroup.addLessonGroup(lg);
		//
		//
		// lessonGroups.add(lg);
		// }
		// tx.commit();
		// } catch (Exception e) {
		// if (tx != null) {
		// tx.rollback();
		// }
		// e.printStackTrace();
		// } finally {
		// session.close();
		// }
		// return (TreeSet<LessonGroup>) LessonGroups;

	}

	@Override
	public TreeSet<LessonGroup> readAllByCoachGroup(CoachGroup coachGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		Set<LessonGroup> specificLessonGroupsByCoachGroup = new TreeSet<>();

		try {
			tx = session.beginTransaction();
			List LessonGroupList = session
					.createNativeQuery(
							"SELECT * FROM `lessongroup` WHERE `coachGroup_CoachGroupName` = :coachGroupName")
					.setParameter("coachGroupName", coachGroup.getName())
					.getResultList();

			for (Iterator iterator = LessonGroupList.iterator(); iterator.hasNext();) {
				Object[] obj = (Object[]) iterator.next();

				// Save the current lesson group id from the result set
				int lessonGroupId = Integer.parseInt(String.valueOf(obj[0]));

				// Save the current lesson group name from the result set
				String lessonGroupName = String.valueOf(obj[1]);

				// Save the current coach group name belonging to the lesson
				// group
				String coachGroupNameResult = String.valueOf(obj[2]);

				/*
				 * Search the coachgroup by name and if it doesn´t match with the current coachgroup
				 * were searching lesson groups in just continue
				 */
				CoachGroup coachGroupObject = CoachGroupService.getInstance().readCoachGroup(coachGroupNameResult);
				if (coachGroupObject != coachGroup) {
					continue;
				}
				LessonGroup lessonGroup = new LessonGroup(lessonGroupName);
				lessonGroup.setId(lessonGroupId);
				
				coachGroupObject.addLessonGroup(lessonGroup);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		return (TreeSet<LessonGroup>) specificLessonGroupsByCoachGroup;
	}
	// @Override
	// public TreeSet<LessonGroup> readAllByCoachGroup(CoachGroup coachGroup) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
