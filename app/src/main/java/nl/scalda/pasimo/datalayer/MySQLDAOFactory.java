package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeam;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkingDay;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAOEducationTeam;
import nl.scalda.pasimo.datalayer.testdao.TestDAOTeacher;


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
    //methodes

    @Override
    public IDAONote getDAONote() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override

    public IDAOTeacher getDAOTeacher() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public nl.scalda.pasimo.datalayer.interfaces.IDAOEducationTeam getDAOEducationTeam() {
    	MYSQLDAOEducationTeam.getInstance();
        return null;
    }

	@Override
	public IDAOTeam getDAOTeam() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public IDAOWorkingDay getDAOWorkingDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDAOWorkBlock getDAOWorkBlock() {
		// TODO Auto-generated method stub
		return null;
	}
}
