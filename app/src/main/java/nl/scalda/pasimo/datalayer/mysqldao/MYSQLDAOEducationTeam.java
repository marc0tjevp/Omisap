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
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAOEducationTeam implements IDAOEducationTeam {
	
	private static SessionFactory factory;
	private static MYSQLDAOEducationTeam instance = null;
	
	/**
	 * initialises the configuration of hibernate.
	 * called once from getInstance() method
	 */
	public static void initialiseFactory() {
		try{
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public MYSQLDAOEducationTeam(){
		initialiseFactory();
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
		   session.createNativeQuery("INSERT INTO educationTeam_teacher (teachers_bsn, EducationTeam_educationTeamID) VALUES (:teacherBsn, :educationTeamID);")
				   .setParameter("teacherBsn", teacher.getBsn()).setParameter("educationTeamID", educationTeam.getId()).executeUpdate();
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
			session.createNativeQuery("DELETE FROM educationTeam_teacher WHERE teachers_bsn = :teachers_bsn")
				.setParameter("teachers_bsn", teacher.getBsn()).executeUpdate();
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
     * creates a educationTeam in the database.
     *
     * @param EducationTeam EducationTeam
     */
    @Override
    public void create(EducationTeam thiseducationTeam) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "INSERT INTO EducationTeam (educationTeamID, name, abbreviation) VALUES (:educationTeamID, :name, :abbreviation );";
            NativeQuery query = session.createNativeQuery(sql);
            query.setParameter("educationTeamID", thiseducationTeam.getId());
            query.setParameter("name", thiseducationTeam.getName());
            query.setParameter("abbreviation", thiseducationTeam.getAbbreviation());
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

    /**
     * updates a educationTeam
     *
     * @param
     */
    @Override
    public void update(EducationTeam thiseducationTeam) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String sql = "UPDATE educationTeam SET name = :Name , abbreviation = :Abbreviation 	WHERE educationTeamID = :educationTeamID ;";
            NativeQuery query = session.createNativeQuery(sql);

            query.setParameter("educationTeamID", thiseducationTeam.getId());
            query.setParameter("Name", thiseducationTeam.getName());
            query.setParameter("Abbreviation", thiseducationTeam.getAbbreviation());
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

    @Override
    public void delete(EducationTeam thiseducationTeam) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.createNativeQuery("DELETE FROM educationTeam WHERE educationTeamID = :educationTeamID")
                    .setParameter("educationTeamID", thiseducationTeam.getId()).executeUpdate();

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

    @Override
    public void save(EducationTeam educationTeam) {
        // TODO Auto-generated method stub

    }

    /**
     * @param String abbreviation
     */
    @Override
    public EducationTeam read(int Id) {
      
    	
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
            List educationTeamList = session.createNativeQuery("SELECT * FROM educationTeam;")
                    .getResultList();
            for (Iterator iterator = educationTeamList.iterator(); iterator.hasNext();) {
                Object[] obj = (Object[]) iterator.next();
                EducationTeam et = new EducationTeam(String.valueOf(obj[1]), String.valueOf(obj[2]), Integer.parseInt(String.valueOf(obj[0])));
                teams.add(et);
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
        return teams;
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
