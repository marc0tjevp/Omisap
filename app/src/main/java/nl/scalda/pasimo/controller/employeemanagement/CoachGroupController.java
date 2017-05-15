package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Set;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;

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

	public TreeSet<Teacher> teacher = TeacherService.getInstance().readAll();

	public Set<EducationTeam> educationTeam = EducationTeamService.getInstance().getEducationTeams();
	public TreeSet<CoachGroup> coachGroup = CoachGroupService.getInstance().readAll();
 CoachGroup coach = new CoachGroup();
	public TreeSet<CoachGroup> deleteCoaches = new TreeSet<>();
	public String s1;
	public String s2;

	public String execute() {
		Teacher tc = new Teacher(124564, "k@k.com", 215950, "hallo", "vanerg", "klaas", 1999, 9, 15);
		Teacher tc1 = new Teacher(12456, "k@k.com", 21595, "hallo", "vanerg", "klaas", 1999, 9, 15);
		Teacher tc2 = new Teacher(1245, "k@k.com", 2159, "hallo", "vanerg", "klaas", 1999, 9, 15);
		//
		
		EducationTeam edu1 = new EducationTeam("ICOa", "ICO41b", 2);
		EducationTeam edu2 = new EducationTeam("ICOc", "ICO41c", 3);
		EducationTeam edu = new EducationTeam("ICOb", "ICO41A", 1);
		//
		coach = new CoachGroup("ICO41A", tc);
		coach = new CoachGroup("ICO41B", tc);
		coach = new CoachGroup("ICO41C", tc);
		edu.getCoachGroups().add(coach);
		coachGroup.add(coach);
		 //coachGroup.add(cg1);
		teacher.add(tc);
		teacher.add(tc1);
		teacher.add(tc);
		educationTeam.add(edu);
		educationTeam.add(edu1);
		educationTeam.add(edu2);
		// EducationTeam edu1 = new EducationTeam("ICOc", "ICO41B", 2);
		// EducationTeam edu2 = new EducationTeam("ICOd", "ICO41C", 3);
		// EducationTeam edu3 = new EducationTeam("ICOe", "ICO41D", 4);
		// EducationTeam edu4 = new EducationTeam("ICOf", "ICO41E", 5);
		// educationTeam.add(edu);
		// educationTeam.add(edu1);
		// educationTeam.add(edu2);
		// educationTeam.add(edu3);
		// educationTeam.add(edu4);
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
		for (CoachGroup cg : coachGroup) {
			if (cg.getName().equals(coach.getName())) {
				String b = cg.getName();
				cg.setName(coach.getName());
				cg.setCoach(TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(s1)));
				CoachGroupService.getInstance().update(cg, EducationTeamService.getInstance().read(Integer.parseInt(s2)), b);
		}
		}
		return SUCCESS;
	}

	public String ArrayCoach() {
		String[] parts = s1.split("\\,");
		
		for (String cg : parts){
			if(!cg.equals("")){
			//coachGroup.remove(cg);
			//CoachGroupService.getInstance().delete(CoachGroupService.getInstance().readCoachGroup(cg));
			}
		}
		return SUCCESS;
		
	}

	public String getThisCoach() {
		coach = CoachGroupService.getInstance().readCoachGroup(s1);
		return SUCCESS;
	}

	public void setTeacher(TreeSet<Teacher> teacher) {
		this.teacher = teacher;
	}

	public Set<EducationTeam> getEducationTeam() {
		return educationTeam;
	}

	public void setEducationTeam(Set<EducationTeam> educationTeam) {
		this.educationTeam = educationTeam;
	}

	public TreeSet<CoachGroup> getDeleteCoaches() {
		return deleteCoaches;
	}

	public void setDeleteCoaches(TreeSet<CoachGroup> deleteCoaches) {
		this.deleteCoaches = deleteCoaches;
	}


	public CoachGroup getCoach() {
		return coach;
	}

	public void setCoach(CoachGroup coach) {
		this.coach = coach;
	}

	public String getS2() {
		return s2;
	}

	public void setS2(String s2) {
		this.s2 = s2;
	}

	public void setS1(String s1) {
		this.s1 = s1;
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
	public TreeSet<Teacher> getTeacher() {
		return teacher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
