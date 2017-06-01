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
	public void create(LessonGroup LessonGroup, CoachGroup coachGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "SET FOREIGN_KEY_CHECKS=0;";
			String sqlinsert = "INSERT INTO `lessongroup` (lessonGroupID, lessonGroupName, coachGroup_CoachGroupName) VALUES (NULL, :lessonGroupName, :coachgroup_name);";
			String foreignkeyclose = "SET FOREIGN_KEY_CHECKS=1;";

			NativeQuery query = session.createNativeQuery(sql);
			NativeQuery insertquery = session.createNativeQuery(sqlinsert);
			NativeQuery foreignkeychecks = session.createNativeQuery(foreignkeyclose);

			query.executeUpdate();

			insertquery.setParameter("lessonGroupName", LessonGroup.getName());
			insertquery.setParameter("coachgroup_name", coachGroup.getName());
			insertquery.executeUpdate();
			foreignkeychecks.executeUpdate();

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
			String sql = "UPDATE `lessongroup` SET `lessongroup`.`lessonGroupName` = :lessonGroupName WHERE `lessongroup`.`lessonGroupID` = :lessonGroupId";

			NativeQuery query = session.createNativeQuery(sql);
			
			query.setParameter("lessonGroupName", LessonGroup.getName());
			query.setParameter("lessonGroupId", LessonGroup.getId());
						
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
            
			NativeQuery foreignKeyChecksOff = session.createNativeQuery("SET FOREIGN_KEY_CHECKS=0;");
			foreignKeyChecksOff.executeUpdate();
			
            NativeQuery deleteQuery = session.createNativeQuery("DELETE FROM `lessongroup` WHERE `lessongroup`.`lessonGroupID` = :lessonGroupId");
            deleteQuery.setParameter("lessonGroupId", LessonGroup.getId());
            deleteQuery.executeUpdate();
            
			NativeQuery foreignKeyChecksOn = session.createNativeQuery("SET FOREIGN_KEY_CHECKS=1;");
			foreignKeyChecksOn.executeUpdate();

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
		return null;
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
					.setParameter("coachGroupName", coachGroup.getName()).getResultList();

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
				 * Search the coachgroup by name and if it doesn´t match with
				 * the current coachgroup were searching lesson groups in just
				 * continue
				 */
				CoachGroup coachGroupObject = CoachGroupService.getInstance().readCoachGroup(coachGroupNameResult);
				LessonGroup lessonGroup = new LessonGroup(lessonGroupName);
				lessonGroup.setId(lessonGroupId);

				// Add the lesson group to the coachgroup
				coachGroupObject.addLessonGroup(lessonGroup, false);

				// Add the lesson group to the list
				specificLessonGroupsByCoachGroup.add(lessonGroup);
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

}
