package nl.scalda.pasimo.controller.employeemanagement;

import java.util.Set;
import java.util.TreeSet;

import com.opensymphony.xwork2.ActionSupport;
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
import nl.scalda.pasimo.datalayer.interfaces.IDAOEducationTeam;

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

    public TreeSet<Teacher> coaches = TeacherService.getInstance().readAll();

    public Set<EducationTeam> educationTeam = EducationTeamService.getInstance().getEducationTeams();
    public TreeSet<CoachGroup> coachGroup = CoachGroupService.getInstance().readAll();
    CoachGroup cgp = new CoachGroup();
    public TreeSet<CoachGroup> deleteCoaches = new TreeSet<>();
    public String s1;
    public String s2;
    public String s3;

    public String execute() {

		if(s1 != null){
		cgp = CoachGroupService.getInstance().readCoachGroup(s1);
		}
        return SUCCESS;

    }

    public String readCoachGroup() {
        getCoachGroup();
        return SUCCESS;
    }

    public String addCoachGroup() {
        
        for (EducationTeam o : educationTeam) {
            if (o.getId() == Integer.parseInt(s1)) {

                cgp.setCoach(TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(s2)));
                CoachGroupService.getInstance().create(cgp, o);
                break;
            }

        }
        return SUCCESS;
    }

    public String updateCoachGroup() {
        for (CoachGroup cg : coachGroup) {
            if (cg.getName().equals(s1)) {
                String b = cg.getName();
                cg.setName(s3);
                cg.setCoach(TeacherService.getInstance().getTeacherByEmployeeID(Integer.parseInt(s2)));
                CoachGroupService.getInstance().update(cg, b);
            }
        }
        return SUCCESS;
    }

    public String ArrayCoach() {
        String[] parts = s1.split("\\,");

        for (String cg : parts) {
            if (cg != "") {
                CoachGroupService.getInstance().delete(CoachGroupService.getInstance().readCoachGroup(cg));
            }
        }
        return SUCCESS;

    }

    public String getThisCoach() {
        cgp = CoachGroupService.getInstance().readCoachGroup(s1);
        return SUCCESS;
    }


    public TreeSet<Teacher> getCoaches() {
		return coaches;
	}

	public void setCoaches(TreeSet<Teacher> coaches) {
		this.coaches = coaches;
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

    public CoachGroup getCgp() {
		return cgp;
	}

	public void setCgp(CoachGroup cgp) {
		this.cgp = cgp;
	}

	public String getS3() {
		return s3;
	}

	public void setS3(String s3) {
		this.s3 = s3;
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


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
