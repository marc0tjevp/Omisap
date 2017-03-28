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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TreeSet<Teacher> teacher = new TreeSet<>();


	public TreeSet<EducationTeam> educationTeam  = new TreeSet<>();
	CoachGroup coach = new CoachGroup();
	public TreeSet<CoachGroup> coachGroup  = new TreeSet<>();

	public String s1; 
	public String s2;


	public String execute() {
		coachGroup = CoachGroupList.getInstance().getCoachgroups();
		
		//CoachGroup a1 = new CoachGroup();
		EducationTeam a2 = new EducationTeam("ao", "edu");
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
				coach.setId(id);
				break;
			}
			id++;
		}
		for (EducationTeam o: educationTeam){
			if(o.getId() == Integer.parseInt(s1)){
				coach.setCurrentEducationTeam(o);
				break;
			}
		}
		for (Teacher o: teacher){
			if(o.getCardID() == Integer.parseInt(s2)){
				coach.setTeacher(o);
				break;
			}
		}
		coach.setName(coach.getName());
		
		CoachGroupList.getInstance().addCoachGroup(coach);
		
		coachGroup.add(coach);
		
		TestDAOCoachGroup.getInstance().create(coach);
	
		System.out.println(CoachGroupList.getInstance().getCoachgroups());
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
	 
	public String CheckCoach() {

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
