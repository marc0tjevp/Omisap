package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAONote;
import nl.scalda.pasimo.datalayer.testdao.TestDAOTeacher;
import nl.scalda.pasimo.interfaces.*;

import nl.scalda.pasimo.interfaces.IDAONote;
import nl.scalda.pasimo.interfaces.IDAOLessonGroup;
import nl.scalda.pasimo.interfaces.IDAOTeacher;

public class TestDAOFactory extends DAOFactory {

    private static TestDAOFactory instance = null;

    private TestDAOFactory() {
    }

    @Override
    public IDAOCoachGroup getDAOCoachGroup() {
        return TestDAOCoachGroup.getInstance();
    }

    public static TestDAOFactory getInstance() {
        if (instance == null) {
            instance = new TestDAOFactory();
        }
        return instance;
    }
    
    @Override
    public IDAOTeacher getDAOTeacher() {
        return TestDAOTeacher.getInstance();
    }

    @Override
    public IDAOLessonGroup getDAOLessonGroup() {
        return TestDAOLessonGroup.getInstance();
    }

    @Override
	public IDAONote getDAONote() {
		return TestDAONote.getInstance();
	}

}
