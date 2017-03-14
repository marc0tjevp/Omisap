package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import nl.scalda.pasimo.datalayer.interfaces.IDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAOEducationTeam implements IDAOEducationTeam {
	
	private static SessionFactory factory;
	private static MYSQLDAOEducationTeam instance = null;
	
	public static void initialiseFactory() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@Override
	public void create(EducationTeam educationTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EducationTeam educationTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(EducationTeam educationTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EducationTeam educationTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EducationTeam read(String abbreviation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EducationTeam> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		Set<EducationTeam> teams = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		   List educationTeamList = session.createNativeQuery("SELECT * FROM education_team INNER JOIN teacher_education_team ON teacher_education_team.education_team_id = education_team.educationTeamID ;")
				   .getResultList();
		   for(Iterator iterator = educationTeamList.iterator();iterator.hasNext();){
			   Object[] obj = (Object[]) iterator.next();
			   EducationTeam et = new EducationTeam(Integer.parseInt(String.valueOf(obj[0])));
			   teams.add(et);
		   }
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
		return teams;
	}

	@Override
	public boolean exist(String abbr) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static MYSQLDAOEducationTeam getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOEducationTeam();
            initialiseFactory();
        }
        return instance;
    }

	@Override
	public void addTeacherToEducationTeam(Teacher teacher, EducationTeam educationTeam) {
		Session session = factory.openSession();
		Transaction tx = null;
		Set<EducationTeam> teams = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		   session.createNativeQuery("INSERT INTO teacher_education_team (teacher_employeeNumber, education_team_id) VALUES (:teacheremployeeNumber, :educationTeamID);")
				   .setParameter("teacheremployeeNumber", teacher.getEmployeeNumber()).setParameter("educationTeamID", educationTeam.getId()).executeUpdate();
		   tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
}
