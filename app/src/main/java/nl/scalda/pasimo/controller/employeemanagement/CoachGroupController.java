package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import com.opensymphony.xwork2.ActionSupport;
import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.service.CoachGroupService;
import nl.scalda.pasimo.service.EducationTeamService;
import nl.scalda.pasimo.service.TeacherService;

/**
 *
 * @author Collin and Ismet
 */
public class CoachGroupController extends ActionSupport {
	public String name;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TreeSet<Teacher> teacher = new TreeSet<>();

	public TreeSet<EducationTeam> educationTeam = new TreeSet<>();
	public TreeSet<CoachGroup> coachGroup = new TreeSet<>();
	CoachGroup coach = new CoachGroup();

	public String s1;
	public String s2;

	public String execute() {
		Teacher tc = new Teacher(124564, "k@k.com", 215950, "hallo", "vanerg", "klaas", 1999, 9, 15);
	

		EducationTeam edu = new EducationTeam("ICOb", "ICO41A", 1);
	
		EducationTeam edu1 = new EducationTeam("ICOc", "ICO41B", 2);
		EducationTeam edu2 = new EducationTeam("ICOd", "ICO41C", 3);
		EducationTeam edu3 = new EducationTeam("ICOe", "ICO41D", 4);
		EducationTeam edu4 = new EducationTeam("ICOf", "ICO41E", 5);
		educationTeam.add(edu);
		educationTeam.add(edu1);
		educationTeam.add(edu2);
		educationTeam.add(edu3);
		educationTeam.add(edu4);
		CoachGroup cg = new CoachGroup("123",tc);
		coachGroup.add(cg);
		teacher.add(tc);

		//educationTeam = EducationTeamService.getInstance().getEducationTeams();
		//coachGroup = CoachGroupService.getInstance().readAll();
		// teacher = TeacherService.getInstance().readAll();
		return SUCCESS;
	}

	public String readCoachGroup() {
		getCoachGroup();
		return SUCCESS;
	}

	public String addCoachGroup() {

		for (EducationTeam o : educationTeam) {
			if (o.getId() == Integer.parseInt(s1)) {
				coach.setName(coach.getName());
				coach.setCoach(TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(s2)));
				CoachGroupService.getInstance().create(coach, o);
				break;
			}

		}

		return SUCCESS;
	}

	public String updateCoachGroup() {
		for (CoachGroup cg : CoachGroupService.getInstance().readAll()) {
			if (cg.getName() == coach.getName()) {
				cg.setName(s1);
				cg.setCoach(TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(s1)));
				cg.setCoach(coach.getCoach());
				CoachGroupService.getInstance().update(cg);
			}

		}
		return SUCCESS;
	}

	public String deleteCoachGroup() {

		CoachGroupService.getInstance().delete(coach);

		return SUCCESS;
	}

	public TreeSet<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(TreeSet<Teacher> teacher) {
		this.teacher = teacher;
	}

	public TreeSet<EducationTeam> getEducationTeam() {
		return educationTeam;
	}

	public void setEducationTeam(TreeSet<EducationTeam> educationTeam) {
		this.educationTeam = educationTeam;
	}

	public CoachGroup getCoach() {
		return coach;
	}

	public void setCoach(CoachGroup coach) {
		this.coach = coach;
	}

	public TreeSet<CoachGroup> getCoachGroup() {
		return coachGroup;
	}

	public void setCoachGroup(TreeSet<CoachGroup> coachGroup) {
		this.coachGroup = coachGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getS1() {
		return s1;
	}

	public void setS1(String s1) {
		this.s1 = s1;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

}
