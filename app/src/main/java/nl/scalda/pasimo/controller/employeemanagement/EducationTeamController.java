package nl.scalda.pasimo.controller.employeemanagement;


import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.service.EducationTeamService;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import java.util.TreeSet;

public class EducationTeamController extends ActionSupport {

    public EducationTeam educationTeam = new EducationTeam();
    public String name;
    public String abbreviation;
    private int id;
    
    public TreeSet<EducationTeam>educationteams = new TreeSet<>();
    
    
    public String index(){
    	
    	return SUCCESS;
    }
    
    public String create(){

        return SUCCESS;
    }
    
    public String addEducationTeam(){
        educationTeam.getAbbreviation();
        EducationTeam e = getEducationTeamID(id);
        e.addEducationTeam(educationTeam);
        MYSQLDAOEducationTeam.getInstance().create(e);
        
        	
    	return SUCCESS;
    }

    
    public String delete(){

    	return SUCCESS;
    }

    public String deleteEducationTeam() {
      	 educationTeam = getEducationTeamID(id);
      	 educationTeam.removeEducationTeam(educationTeam);

   		return null;
       }
        
    
    public String edit(){

        return SUCCESS;
  }




    

    private EducationTeam getEducationTeamID(int id) {
    	try{
    		return (EducationTeam) EducationTeamService.getInstance().getEducationTeams(id);
    	}catch(Exception e){
    		return null;
    	}
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
