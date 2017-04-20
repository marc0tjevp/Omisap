package nl.scalda.pasimo.datalayer.mysqldao;

import nl.scalda.pasimo.datalayer.interfaces.IDAOWorkWeek;
import nl.scalda.pasimo.model.timeregistration.WorkWeek;

public class MYSQLDAOWorkWeek implements IDAOWorkWeek {

	private static MYSQLDAOWorkWeek instance = null;

	public static MYSQLDAOWorkWeek getInstance() {
		if (instance == null) {
			instance = new MYSQLDAOWorkWeek();
			

		}
		return instance;

	}

	@Override
	public WorkWeek read(int id) {
		
		return null;
	}

	@Override
	public WorkWeek readAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
