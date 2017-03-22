package nl.scalda.pasimo.datalayer.factory;

import nl.scalda.pasimo.datalayer.interfaces.IDAOCoachGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.datalayer.interfaces.IDAONote;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkBlock;
import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkingDay;
import nl.scalda.pasimo.datalayer.testdao.TestEducationTeamDAO;
import nl.scalda.pasimo.datalayer.testdao.TestTeamDAO;

import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAONote;
import nl.scalda.pasimo.datalayer.testdao.TestDAOTeacher;
import nl.scalda.pasimo.datalayer.testdao.TestDAOWorkBlock;
import nl.scalda.pasimo.datalayer.testdao.TestDAOWorkingDay;
import nl.scalda.pasimo.interfaces.*;

public class TestDAOFactory extends DAOFactory {

    private static TestDAOFactory instance = null;

    private TestDAOFactory() {

    }
    
    @Override
    public ITeamDAO getTeamDAO() {
        return TestTeamDAO.getInstance();
    }

    @Override
    public IEducationTeamDAO getEducationTeamDAO() {
        return TestEducationTeamDAO.getInstance();
    }

    @Override
    public IDAOCoachGroup getDAOCoachGroup() {
        return TestDAOCoachGroup.getInstance();
    }

    @Override
    public IDAOLessonGroup getDAOLessonGroup() {
        return TestDAOLessonGroup.getInstance();
    }

    @Override
    public IDAOTeacher getDAOTeacher() {
        return TestDAOTeacher.getInstance();
    }

    @Override
    public IDAONote getDAONote() {
        return TestDAONote.getInstance();
    }

    public static TestDAOFactory getInstance() {
        if (instance == null) {
            instance = new TestDAOFactory();
        }
        return instance;
    }


	@Override
	public IDAOWorkingDay getDAOWorkingDay() {

		return TestDAOWorkingDay.getInstance();
	}

	@Override
	public IDAOWorkBlock getDAOWorkBlock() {
	
		return TestDAOWorkBlock.getInstance();
	}


}
