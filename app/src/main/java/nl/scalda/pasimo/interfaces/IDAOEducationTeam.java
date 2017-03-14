package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.model.employeemanagement.EducationTeam;

public interface IDAOEducationTeam {
	
	
	public void create(EducationTeam EducationTeam);
	
	public EducationTeam read(EducationTeam EducationTeam);
	
	public void update(EducationTeam EducationTeam);
	
	public void delete(EducationTeam EducationTeam);

}
