package nl.scalda.pasimo.datalayer.mysqldao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nl.scalda.pasimo.datalayer.interfaces.IDAOAcount;

public class MYSQLDAOAcount implements IDAOAcount{

	private static MYSQLDAOAcount instance = null;
	private SessionFactory factory;
	
	private MYSQLDAOAcount() {
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
	
	public static MYSQLDAOAcount getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOAcount();
		}
		return instance;
	}

}
