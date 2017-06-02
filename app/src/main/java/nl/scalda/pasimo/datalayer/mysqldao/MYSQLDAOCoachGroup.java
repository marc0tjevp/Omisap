/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer.mysqldao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Note;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;
import nl.scalda.pasimo.service.TeacherService;

/**
 *
 * @author jeroe
 */
public class MYSQLDAOCoachGroup implements IDAOCoachGroup {

	private SessionFactory factory;
	private static MYSQLDAOCoachGroup instance = null;

	private MYSQLDAOCoachGroup() {
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
	
	/**
	 * Creates coachGroup  
	 * CoachGroup gets added to the DataBase
	 * @Param CoachGroup
	 * @Param EducationTeam
	 */
	@Override
	public void create(CoachGroup CoachGroup, EducationTeam edu) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO coachgroup (name, teacher_employeenumber, educationTeam_educationTeamID)values(:name , :teacher_employeenumber , :educationTeam_educationTeamID );";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("name", CoachGroup.getName());
			query.setParameter("teacher_employeenumber", CoachGroup.getCoach().getEmployeeNumber());
			query.setParameter("educationTeam_educationTeamID", edu.getId());
			query.executeUpdate();

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	
	/**
	 * Reads from the exsiting coachgroups in th DataBase
	 * @param CoachGroup
	 */
	@Override
	public void read(CoachGroup cg) {
		Session session = factory.openSession();
		Transaction tx = null;
	
		try {
			tx = session.beginTransaction();
			Object[] obj = (Object[]) session
					.createNativeQuery( "SELECT * FROM coachgroup WHERE name = :name")
					.setParameter("name", cg.getName()).getSingleResult();
			   cg.setName(String.valueOf(obj[0]));
				
				cg.setCoach(TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(String.valueOf(obj[1]))));
				EducationTeam bla =  EducationTeamService.getInstance().read(Integer.parseInt(String.valueOf(obj[2])));
                bla.getCoachGroups().add(cg);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	/**
	 * Updates choosen variables from coachgroup
	 * @param CoachGroup
	 * @param String
	 */
	@Override
	public void update(CoachGroup coachGroup, String Oldname) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			NativeQuery query2 = session.createNativeQuery("UPDATE coachgroup set name = :name, teacher_employeenumber = :teacher_employeenumber  where name = :oldname ;");
			
			query2.setParameter("name", coachGroup.getName())
			.setParameter("teacher_employeenumber", coachGroup.getCoach().getEmployeeNumber())
			.setParameter("oldname", Oldname);
	
			query2.executeUpdate();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}

	}

	/**
	 * deletes the chosen coachgroup from the DataBase
	 * @param CoachGroup
	 */
	@Override
	public void delete(CoachGroup CoachGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE * FROM coachgroup where name = :name ;")
			.setParameter("name", CoachGroup.getName())
			.executeUpdate();
			session.delete(CoachGroup);
		
			tx.commit();

			System.out.println("deleted");
		} catch(HibernateException e) {
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/**
	 * Reads all exsisting coachgroups from the DataBase
	 * 
	 */
	@Override
	public TreeSet<CoachGroup> readAll() {
		Session session = factory.openSession();
        Transaction tx = null;
        TreeSet<CoachGroup> coachGroups = new TreeSet<>();
        try {
            tx = session.beginTransaction();
            List coachGroupList = session.createNativeQuery("SELECT * FROM coachgroup ;")
                    .getResultList();
            for (Iterator iterator = coachGroupList.iterator(); iterator.hasNext();) {
                Object[] obj = (Object[]) iterator.next();
                CoachGroup cg = new CoachGroup(String.valueOf(obj[0]) , TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(String.valueOf(obj[1]))));
                EducationTeam bla =  EducationTeamService.getInstance().read(Integer.parseInt(String.valueOf(obj[2])));
                bla.getCoachGroups().add(cg);
                coachGroups.add(cg);
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
      
        return coachGroups;
    }
	
	/**
	 * Reads all the EducationTeam ids from the Database
	 * @param EducationTeam
	 */
	@Override
	public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t) {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<CoachGroup> coach = new TreeSet<>();
		CoachGroup cp = new CoachGroup();
		try {
			tx = session.beginTransaction();
			List CoachGroupList = session.createNativeQuery("SELECT * from coachgroup where educationTeam_educationTeamID = :educationTeam_educationTeamID ;")
					.setParameter("educationTeam_educationTeamID", t.getId())
					
					.getResultList();
					
			
			
			for(Iterator iterator = CoachGroupList.iterator();iterator.hasNext();){
				 Object[] obj = (Object[]) iterator.next();
				 
				 CoachGroup cg = new CoachGroup(String.valueOf(obj[0]) , TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(String.valueOf(obj[1]))));
				 coach.add(cg);
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
	
	        return coach;
	}

	public static MYSQLDAOCoachGroup getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOCoachGroup();
		}
		return instance;
	}
}
