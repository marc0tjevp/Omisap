package nl.scalda.pasimo.datalayer.mysqldao;

import nl.scalda.pasimo.datalayer.factory.MySQLDAOConnection;
import nl.scalda.pasimo.interfaces.IDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

public class MYSQLDAOEducationTeam implements IDAOEducationTeam {
	
	 private static MYSQLDAOEducationTeam instance = null;

	@Override
	public void create(EducationTeam EducationTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EducationTeam read(EducationTeam EducationTeam) {
		// TODO Auto-generated method stub
		return EducationTeam;
	}

	@Override
	public void update(EducationTeam EducationTeam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EducationTeam EducationTeam) {
		// TODO Auto-generated method stub
		
	}
    public static MYSQLDAOEducationTeam getInstance() {
        if (instance == null) {
            instance = new MYSQLDAOEducationTeam();
        }
        return instance;
    }

}