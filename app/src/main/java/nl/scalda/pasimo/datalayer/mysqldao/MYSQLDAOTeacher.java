package nl.scalda.pasimo.datalayer.mysqldao;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.MySQLDAOConnection;
import nl.scalda.pasimo.datalayer.interfaces.IDAOTeacher;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;

public class MYSQLDAOTeacher extends MySQLDAOConnection implements IDAOTeacher {

	@Override
	public void create(Teacher teacher, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Teacher t, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Teacher t, EducationTeam team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeSet<Teacher> readAll() {
		//openConn();
		
		return null;
	}

	@Override
	public Teacher readByEmployeeNumber(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Teacher> readAllForEducationTeam(EducationTeam t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Teacher readByAbbr(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
