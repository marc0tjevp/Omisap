package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IEducationTeamDAO;
import nl.scalda.pasimo.datalayer.interfaces.ITeamDAO;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAONote;
import nl.scalda.pasimo.interfaces.IDAOTeacher;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;

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
    public IDAOCoachGroup getDAOCoachGroup() {
        return MYSQLDAOCoachGroup.getInstance();
    }

    @Override
    public IDAOLessonGroup getDAOLessonGroup() {
        return MYSQLDAOLessonGroup.getInstance();
    }
    
	@Override
	public IDAONote getDAONote() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override

	public IDAOTeacher getDAOTeacher() {
		return TestDAOTeacher.getInstance();
	}

	@Override
	public ITeamDAO getTeamDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEducationTeamDAO getEducationTeamDAO() {
		// TODO Auto-generated method stub
		return null;
	}
}
