package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IEducationTeamDAO;
import nl.scalda.pasimo.interfaces.ITeamDAO;

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

//methods

    @Override
    public ITeamDAO getTeamDAO() {
        return null;
    }

    @Override
    public IEducationTeamDAO getEducationTeamDAO() {
        return null;
    }

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
        // TODO Auto-generated method stub
        return null;
    }
}
