package nl.scalda.pasimo.datalayer.mysqldao;

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

import nl.scalda.pasimo.datalayer.interfaces.IDAOEducationTeam;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Person;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.model.employeemanagement.Team;

	public class MYSQLDAOEducationTeam implements IDAOEducationTeam {
		
		private SessionFactory factory;
		private static MYSQLDAOEducationTeam instance = null;
		
		/**
		 * 
		 */
		private MYSQLDAOEducationTeam() {
			initialiseFactory();
		}
		
		/**
		 * initialises the configuration of hibernate.
		 * called once from getInstance() method
		 */
		private  void initialiseFactory() {
			try{
				factory = new Configuration().configure().buildSessionFactory();
			} catch(Throwable ex) {
				System.err.println("Failed to create sessionFactory object." + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}

		/**
		 * creates a teacher in the database.
		 * 
		 * @param EducationTeam EducationTeam
		 */
		@Override
		public void create(EducationTeam e) {
			Session session = factory.openSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();
				String sql = "INSERT INTO EducationTeam (educationTeamID, name, abbreviation) VALUES (:educationTeamID, :name, :abbreviation );";
				NativeQuery query = session.createNativeQuery(sql);
				query.setParameter("educationTeamID", e.getId());
				query.setParameter("name", e.getName());
				query.setParameter("abbreviation", e.getAbbreviation());
				query.executeUpdate();
				tx.commit();
			} catch(HibernateException s) {
				if(tx!=null) tx.rollback();
				s.printStackTrace();
			} finally {
				session.close();
			}
		}

		/**
		 * updates the teacher in the database.
		 * 
		 * @param Teacher t
		 */
		@Override
		public void update(EducationTeam o) {
			Session session = factory.openSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();

				String sql = "UPDATE educationTeam SET name = :name, abbreviation = :abbreviation WHERE name = :name";

				
				session.createNativeQuery("UPDATE educationTeam SET educationTeamID = :educationTeamID, name = :name, abbreviation = :abbreviation")
				.setParameter("educationTeamID", o.getId())
				.setParameter("name", o.getName())
				.setParameter("abbreviation", o.getAbbreviation());
				
				
				tx.commit();
				
			} catch(HibernateException e) {
				if(tx!=null) tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			
		}
		@Override
		public void delete(EducationTeam p) {
			Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            session.createNativeQuery("DELETE FROM educationTeam WHERE name = :name")
	                    .setParameter("name", p.getName()).executeUpdate();
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null)
	                tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
			
		


	@Override
	public void save(EducationTeam educationTeam) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param String abbreviation
	 */
	@Override
	public EducationTeam read(String abbreviation) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * reads all the education in the database
	 * 
	 * @return Set<EducationTeam>
	 */
	@Override
	public Set<EducationTeam> readAll() {
		Session session = factory.openSession();
		Transaction tx = null;
		Set<EducationTeam> teams = new TreeSet<>();
		try {
		   tx = session.beginTransaction();
		   List educationTeamList = session.createNativeQuery("SELECT * FROM education_team;")
				   .getResultList();
		   for(Iterator iterator = educationTeamList.iterator();iterator.hasNext();){
			   Object[] obj = (Object[]) iterator.next();
			   EducationTeam et = new EducationTeam(String.valueOf(obj[2]), String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[0])));
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

	/**
	 * @param String abbr
	 */
	@Override
	public boolean exist(String abbr) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * adds the given teacher to the given education team.
	 * 
	 * @param Teacher teacher
	 * @param EducationTeam educationTeam
	 */
	@Override
	public void addTeacherToEducationTeam(Teacher teacher, EducationTeam educationTeam) {
		Session session = factory.openSession();
		Transaction tx = null;
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
	
	/**
	 * deletes the given teacher from the given education team.
	 * 
	 * @param Teacher teacher
	 * @param EducationTeam educationTeam
	 */
	@Override
	public void deleteTeacherFromEducationTeam(Teacher teacher, EducationTeam educationTeam) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.createNativeQuery("DELETE FROM teacher_education_team WHERE teacher_employeeNumber = :employeeNumber")
				.setParameter("employeeNumber", teacher.getEmployeeNumber()).executeUpdate();
			tx.commit();
		}
		catch (Exception e) {
		   if (tx!=null) tx.rollback();
		   e.printStackTrace(); 
		}finally {
		   session.close();
		}
	}
	
	/**
	 * check if there already is an instance of this class and returns it.
	 * 
	 * @return MYSQLDAOEducationTeam
	 */
	public static MYSQLDAOEducationTeam getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOEducationTeam();
        }
        return instance;
    }



}
