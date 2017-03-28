package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.testdao.TestDAOCoachGroup;
import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;





/**
 * @author jeroe
 */
public class CoachGroup implements Comparable<CoachGroup> {

    private int id;
    private String name;
    private Teacher coach;
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();


    public CoachGroup() {
    }

    public CoachGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CoachGroup(String name, Teacher coach) {
        this.name = name;
        this.coach = coach;
    }

    
    public CoachGroup(String name, Teacher coach, TreeSet<LessonGroup> lessonGroups) {
        this.name = name;
        this.coach = coach;
        this.lessonGroups = lessonGroups;
    }

    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
        TestDAOLessonGroup.getInstance().create(lg);
    }


    public void updateLessonGroup(LessonGroup lessonGroup) {
        for (LessonGroup eachLessonGroup : this.lessonGroups) {
            if (eachLessonGroup != lessonGroup) {
                continue;
            }
            eachLessonGroup.setName(lessonGroup.getName());
            eachLessonGroup.setStudents(lessonGroup.getStudents());
        }
    }



	public void deleteLessonGroup(LessonGroup lg) {

        lessonGroups.remove(lg);
        TestDAOLessonGroup.getInstance().delete(lg);

    }
	
	public void addCoachGroup(){
		
		TestDAOCoachGroup.getInstance().create(this);
	}
	
	public void updateCoachGroup(CoachGroup coach){
		this.setName(coach.name);
		this.setCoach(coach.coach);
		TestDAOCoachGroup.getInstance().update(this);
	}

    //<editor-fold defaultstate="collapsed" desc="getters and setters">
    public int getId() {
        return id;
    }

	public void setId(int id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getCoach() {
		return coach;
	}

	public void setCoach(Teacher coach) {
		this.coach = coach;
	}

	public TreeSet<LessonGroup> getLessonGroups() {
        return lessonGroups;
    }

    public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
        this.lessonGroups = lessonGroups;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "\n CoachGroup: id= " +
               id +
               ", name= " +
               name +
               ", coach= " +
               coach +
               ", lessongroup= " +
               lessonGroups;
    }

    @Override
    public int compareTo(CoachGroup o) {
//        int i = this.getTeacher().getAbbrevation().compareTo(o.getTeacher().getAbbrevation());
//        if(i == 0) return i;
        return name.compareTo(o.getName());
    }
}