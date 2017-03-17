package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;
import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.test.CoachGroupList;
import nl.scalda.pasimo.test.EducationTeamList;
import nl.scalda.pasimo.test.TeacherList;

/**
 *
 * @author jeroe
 */
public class CoachGroupController extends ActionSupport {

	public String name;
	public TreeSet<Teacher> teacher = TeacherList.getInstance().getTeachers();
	public TreeSet<EducationTeam> educationTeam = EducationTeamList.getInstance();
	CoachGroup coach = new CoachGroup();
	public TreeSet<CoachGroup> coachGroup = CoachGroupList.getInstance().getCoachgroups();

	public String execute() {
		educationTeam = EducationTeamList.getInstance();
		teacher = TeacherList.getInstance().getTeachers();
		coachGroup = CoachGroupList.getInstance().getCoachgroups();
		
		//CoachGroup a1 = new CoachGroup();
		EducationTeam a2 = new EducationTeam("ao", "1");
		 Teacher a3 = new Teacher(12,"1", 12, "fgkerbjfnkbjergkbjersbknj", "1", "fegwbjufbverbj", 1988, 12, 12);
		teacher.add(a3);
		educationTeam.add(a2);
	//	coachGroup.add(a1);
		return SUCCESS;
	}

	public String readCoachGroup() {
		getCoachGroup();
		return SUCCESS;
	}

	public String addCoachGroup() {
	 int id = 0;
		while (true) {
			if (!CoachGroupList.getInstance().getCoachgroups().contains(id)) {
				break;
			}
			id++;
		}
		coach.setId(id);
		
		CoachGroupList.getInstance().addCoachGroup(coach);
		
		coachGroup.add(coach);
		
		TestDAOCoachGroup.getInstance().create(coach);
	
		
		return SUCCESS;
	}

	public String updateCoachGroup() {
		for (CoachGroup cg : CoachGroupList.getInstance().getCoachgroups()) {
			if (cg.getId() == coach.getId()) {
				cg.setName(coach.getName());
				cg.setTeacher(coach.getTeacher());
				cg.setCurrentEducationTeam(coach.getCurrentEducationTeam());

			}

		}
		return SUCCESS;
	}

	public String deleteCoachGroup() {
		
		CoachGroupList.getInstance().removeCoachGroup(coach);
		coachGroup.remove(coach);
		TestDAOCoachGroup.getInstance().delete(coach);

		return SUCCESS;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
