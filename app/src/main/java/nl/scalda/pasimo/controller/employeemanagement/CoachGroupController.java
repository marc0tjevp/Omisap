package nl.scalda.pasimo.controller.employeemanagement;

import java.util.TreeSet;
import com.opensymphony.xwork2.ActionSupport;

import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.model.employeemanagement.CoachGroup;
import nl.scalda.pasimo.model.employeemanagement.EducationTeam;
import nl.scalda.pasimo.model.employeemanagement.Teacher;
import nl.scalda.pasimo.test.CoachGroupList;

/**
 *
 * @author jeroe
 */
public class CoachGroupController extends ActionSupport {

	public String name;
	public TreeSet<Teacher> teacher;
	public EducationTeam educationTeam;
	CoachGroup coach = new CoachGroup();
	public TreeSet<CoachGroup> coachGroup = new TreeSet<>();

	public String execute() {
		this.readCoachGroup();
		return SUCCESS;
	}

	public String readCoachGroup() {
		getCoachGroup();
		return SUCCESS;
	}

	public String addCoachGroup() {
		TreeSet<Integer> count = new TreeSet<>();
		int id = 0;
		for (CoachGroup cg : CoachGroupList.getInstance().getCoachgroups()) {
			count.add(cg.getId());
		}
		while (true) {
			if (!count.contains(id)) {
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

	public EducationTeam getEducationTeam() {
		return educationTeam;
	}

	public void setEducationTeam(EducationTeam educationTeam) {
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
