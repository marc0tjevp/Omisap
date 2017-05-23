package nl.scalda.pasimo.controller.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.factory.MySQLDAOFactory;
import nl.scalda.pasimo.datalayer.mysqldao.MYSQLDAOEducationTeam;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.LessonGroup;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.EducationTeamService;
import nl.scalda.pasimo.service.LessonGroupService;
import nl.scalda.pasimo.service.TeacherService;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Set;
import java.util.TreeSet;

public class EducationTeamController extends ActionSupport {

	public EducationTeam educationTeam = new EducationTeam();
	public String name;
	public String abbreviation;
	private int id;

	public TreeSet<EducationTeam> educationteams = new TreeSet<>();

	public TreeSet<EducationTeam> getEducationTeam() {
		try {
			educationteams.addAll(EducationTeamService.getInstance().readAll());
			return educationteams;
		} catch (Exception e) {
			return null;
		}
		
	}

	public String index() {
		
		return SUCCESS;
	}

	public String execute() {
		return SUCCESS;
	}

	public String create() {

		return SUCCESS;
	}

	public String addEducationTeam() {
		educationTeam.setAbbreviation(abbreviation);
		educationTeam.addEducationTeam(educationTeam);
		EducationTeam et = getEducationTeamID(id);
		et.addEducationTeam(et);
		return SUCCESS;

	}

	public String delete() {

		return SUCCESS;
	}

	public String deleteEducationTeam() {
		educationTeam = getEducationTeamID(id);
		educationTeam.removeEducationTeam(educationTeam);

		return SUCCESS;
	}

	public String edit() {

		return SUCCESS;
	}

	public String updateEducationTeam() {
		EducationTeam educationteam = EducationTeamService.getInstance().read(this.educationTeam);
		if (educationteam == null) {
			return ERROR;
		}
		educationteam.setName(this.name);
		educationteam.updateEducationTeam(educationteam);
		return SUCCESS;
	}

	private EducationTeam getEducationTeamID(int id) {
		try {
			return (EducationTeam) EducationTeamService.getInstance().getEducationTeams(id);
		} catch (Exception e) {
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
