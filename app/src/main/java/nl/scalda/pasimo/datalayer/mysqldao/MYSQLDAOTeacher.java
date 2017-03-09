package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.List;
import java.util.TreeSet;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import nl.scalda.pasimo.datalayer.factory.MySQLDAOConnection;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAOTeacher extends MySQLDAOConnection implements IDAOTeacher {
	
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		MYSQLDAOTeacher MT = new MYSQLDAOTeacher();
		
		Teacher t1 = new Teacher("henkie", 123456, "henkie@email.com");
		Teacher t2 = new Teacher("klaase", 654321, "klaase@email.com");
		MT.create(t1);
		MT.create(t2);
		
//		MT.listTeachers();
//		
//		MT.updateTeacher();
//		
//		MT.deleteTeacher();
//		
//		MT.listTeachers();
		
	}

	@Override
	public void create(Teacher teacher) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer teacherEmployeeNumber = null;
		try{
			tx = session.beginTransaction();
			String sql = "INSERT INTO person (email) VALUES (:email);";
			NativeQuery query = session.createNativeQuery(sql);
			query.setParameter("email", teacher.getEmail());
			query.executeUpdate();
			String sql1 = "INSERT INTO teacher (person_email,employeeNumber,abbreviation,coach_group_coachGroupID) VALUES (:email,:employeeNumber,:abbreviation,:coachGroup);";
			NativeQuery query1 = session.createNativeQuery(sql1);
			query1.setParameter("email", teacher.getEmail());
			query1.setParameter("employeeNumber", teacher.getEmployeeNumber());
			query1.setParameter("abbreviation", teacher.getAbbreviation());
			query1.setParameter("coachGroup", 0);
			query1.executeUpdate();
			tx.commit();
		} catch(HibernateException e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Teacher t, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Teacher t, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeSet<Teacher> readAll() {
		//openConn();
		//TODO
		Session session = factory.openSession();
		Transaction tx = null;
		try {
		   tx = session.beginTransaction();
		   // do some work
		   
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		
		return null;
	}

	@Override
	public Teacher readByEmployeeNumber(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher readByAbbr(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
