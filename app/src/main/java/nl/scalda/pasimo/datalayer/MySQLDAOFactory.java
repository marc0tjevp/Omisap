package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAONote;
import nl.scalda.pasimo.interfaces.IDAOTeacher;

public class MySQLDAOFactory extends DAOFactory {

    private static MySQLDAOFactory instance = null;

    private MySQLDAOFactory() {
    }

    public static MySQLDAOFactory getInstance() {
        if (instance == null) {
            instance = new MySQLDAOFactory();
        }
        return instance;
    }

  //methodes
    
	@Override
	public IDAONote getDAONote() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public TestDAOTeacher getDAOTeacher() {
		// TODO Auto-generated method stub
		return TestDAOTeacher.getInstance();
	}

}
