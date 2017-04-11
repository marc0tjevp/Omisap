package nl.scalda.pasimo.datalayer.interfaces;


import java.util.TreeSet;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public interface IDAOCheckIn {

	public TreeSet<CheckIn> readAll();

}
