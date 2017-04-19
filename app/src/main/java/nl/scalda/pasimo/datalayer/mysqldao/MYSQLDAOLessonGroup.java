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
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.LessonGroupService;

/**
 *
 * @author jeroe
 */
public class MYSQLDAOLessonGroup implements IDAOLessonGroup {

	private SessionFactory factory;

	private static MYSQLDAOLessonGroup instance = null;
/*
 * Creates the factory for the lessongroupDAO
 */
	private void initialiseFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
   /*
    *Method needed to create lessongroup with name and the coachgroup it's in 
    */
	@Override
	public void create(LessonGroup LessonGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO LessonGroup (lessonGroupName,CoachGroup) VALUES (:LessonGroupName, :CoachGroup);";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("lessonGroupName", LessonGroup.getName());
			query.setParameter("CoachGroup", CoachGroupService.getInstance().readAll());
			query.executeUpdate();

			tx.commit();

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
 * Updates the lessongroup by updating the name and/or coachgroup inside the lessongroup table
 */
	@Override
	public void update(LessonGroup LessonGroup) {
	        Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            String sql = "UPDATE LessonGroup SET name = :Name , abbreviation = :Abbreviation 	WHERE educationTeamID = :educationTeamID ;";
	            NativeQuery query = session.createNativeQuery(sql);

	            
				query.setParameter("lessonGroupName", LessonGroup.getName());
				query.setParameter("CoachGroup", CoachGroupService.getInstance().readAll());
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
	 * Deletes the lessongroup from the table where the name equals the selected name
	 */

	@Override
	public void delete(LessonGroup LessonGroup) {
		Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createNativeQuery("DELETE FROM LessonGroup WHERE lessonGroupName = :lessonGroupName")
            .setParameter("lessonGroupName", LessonGroup.getName()).executeUpdate();

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
		 Session session = factory.openSession();
	        Transaction tx = null;
	        Set<LessonGroup> lessonGroups = new TreeSet<>();
	        try {
	            tx = session.beginTransaction();
	            List LessonGroupList = session.createNativeQuery("SELECT * FROM LessonGroups;")
	               .getResultList();
	            for (Iterator iterator = LessonGroupList.iterator(); iterator.hasNext();) {
	                Object[] obj = (Object[]) iterator.next();
	                
	                String coachGroupName = String.valueOf(obj[2]);
	                CoachGroup coachGroup = CoachGroupService.getInstance().readCoachGroup(coachGroupName);
	                
	                //...
	                
	                LessonGroup lg = new LessonGroup(Integer.parseInt(String.valueOf(obj[0])), String.valueOf(obj[1]));
	                coachGroup.addLessonGroup(lg);
	                
	                
	                lessonGroups.add(lg);
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
	        return (TreeSet<LessonGroup>) lessonGroups;
	    }


	@Override
	public TreeSet<LessonGroup> readAllByCoachGroup(CoachGroup coachGroup) {
		// TODO Auto-generated method stub
		return null;
	}

}
