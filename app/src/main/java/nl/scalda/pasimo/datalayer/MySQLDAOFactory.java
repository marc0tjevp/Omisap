package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAOTeacher;

/**
 * @deprecated
 */
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

	@Override
	public IDAOTeacher getDAOTeacher() {
		// TODO Auto-generated method stub
		return null;
	}

//methodes
}
