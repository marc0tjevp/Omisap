package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAOEducationTeam;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeam;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkingDay;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOCoachGroup;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOLessonGroup;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOTeacher;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOWorkBlock;


public class MySQLDAOFactory extends DAOFactory {

    private static MySQLDAOFactory instance = null;

    private  MySQLDAOFactory() {
    }

    public static MySQLDAOFactory getInstance() {
        if (instance == null) {
            instance = new MySQLDAOFactory();
        }
        return instance;
    }

    /**
     * methods from interface
     */
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
        return MYSQLDAOTeacher.getInstance();
    }

    @Override
    public IDAOWorkingDay getDAOWorkingDay() {
        return null;
    }

    @Override
    public IDAOTeam getDAOTeam() {

        // TODO Auto-generated method stub
        return null;
    }

	public IDAOEducationTeam getDAOEducationTeam() {
		return MYSQLDAOEducationTeam.getInstance();

	}

	/* (non-Javadoc)
	 * @see nl.scalda.pasimo.datalayer.factory.DAOFactory#getDAOWorkBlock()
	 */
	@Override
	public IDAOWorkBlock getDAOWorkBlock() {
		
		return MYSQLDAOWorkBlock.getInstance();
	}

}
