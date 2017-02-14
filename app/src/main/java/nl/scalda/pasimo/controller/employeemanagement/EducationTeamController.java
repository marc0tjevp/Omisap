package nl.scalda.pasimo.controller.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.TestDAOFactory;
import nl.scalda.pasimo.datalayer.testdao.TestEducationTeamDAO;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import com.opensymphony.xwork2.ActionSupport;

import java.util.TreeSet;

/**
 * Created by Diederik on 8-2-2017.
 */
public class EducationTeamController extends ActionSupport {
	

	
 public EducationTeam educationTeam = new EducationTeam();

    public String index() {
        return SUCCESS;
    }


    public String create() {

        return SUCCESS;
    }

    public String delete() {

        return SUCCESS;
    }

    public String update() {

        return SUCCESS;
    }
    
    //public String addEducationTeam(){
    	
    	//return SUCCESS;
   // }
    public String addEducationTeam() {
 //  		EducationTeam.setAbbreviation();
    	TestEducationTeamDAO.getInstance().create(educationTeam);
    	System.out.println("kut project");
    
  return SUCCESS;
    }

}
