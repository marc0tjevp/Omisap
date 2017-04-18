/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.Iterator;
import java.util.List;
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
import nl.scalda.pasimo.service.CoachGroupService;

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

	@Override
	public void create(CoachGroup CoachGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "INSERT INTO coachgroup (name, teacher_employeenumber, educationTeam_educationTeamID)values(:name , :teacher_employeenumber , :educationTeam_educationTeamID );";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("name", CoachGroup.getName());
			query.setParameter("teacher_employeenumber", CoachGroup.getCoach().getEmployeeNumber());
			query.setParameter("educationTeam_educationTeamID",
					CoachGroupService.getInstance().getEducationTeam(CoachGroup).getId());
			query.executeUpdate();

			tx.commit();

			System.out.println("created");
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public CoachGroup read(CoachGroup CoachGroup) {
		return CoachGroup;
	}

	@Override
	public void update(CoachGroup coachGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			NativeQuery query1 = session.createNativeQuery("SET foreign_keys_checks = 0;");
			NativeQuery query2 = session.createNativeQuery(
					"UPDATE coachgroup set name = :name, teacher_employeenumber: teacher_employeenumber, educationTeam_educationTeamID: educationTeam_educationTeamID ;");
			NativeQuery query3 = session.createNativeQuery("SET foreign_key_checks = 1;");
			query1.executeUpdate();
			session.createNativeQuery("UPDATE coachgroup set name: name;").setParameter("name", coachGroup.getName())
					.executeUpdate();
			query2.setParameter("name", coachGroup.getName());
			query2.executeUpdate();
			query3.executeUpdate();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}

	}

	@Override
	public void delete(CoachGroup CoachGroup) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM coachgroup where name = :name , teacher_employeenumber = :teacher_employeenumber , educationTeam_educationTeamID = :educationTeam_educationTeamID ;")
			.setParameter("name", CoachGroup.getName())
			.setParameter("teacher_employeenumber",CoachGroup.getCoach().getEmployeeNumber())
			.setParameter("educationTeam_educationTeamID", CoachGroupService.getInstance().getEducationTeam(CoachGroup).getId())
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

	@Override
	public TreeSet<CoachGroup> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static MYSQLDAOCoachGroup getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOCoachGroup();
		}
		return instance;
	}

	@Override
	public TreeSet<CoachGroup> readAllBYTeam(EducationTeam t) {
		Session session = factory.openSession();
		Transaction tx = null;
		TreeSet<CoachGroup> coach = new TreeSet<>();
		try {
			tx = session.beginTransaction();
			String sql = "SELECT * from coachgroup where educationTeam_educationTeamID = :educationTeamID ;";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("educationTeamID", t.getId());
			List CoachGroupList = query.getResultList();
			
			for(Iterator iterator = CoachGroupList.iterator();iterator.hasNext();){
				 Object[] obj = (Object[]) iterator.next();
	                CoachGroup cg = new CoachGroup(String.valueOf(obj[0]));
	                coach.add(cg);
			 }
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

}
