package nl.scalda.pasimo.datalayer;

import nl.scalda.pasimo.interfaces.IDAONote;
import nl.scalda.pasimo.interfaces.IDAOTeacher;

import nl.scalda.pasimo.interfaces.IDAOLessonGroup;

public class TestDAOFactory extends DAOFactory {

    private static TestDAOFactory instance = null;

    private TestDAOFactory() {
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
    }

	@Override
	public IDAONote getDAONote() {
		return TestDAONote.getInstance();
	}

        return TestDAOLessonGroup.getInstance();
}
