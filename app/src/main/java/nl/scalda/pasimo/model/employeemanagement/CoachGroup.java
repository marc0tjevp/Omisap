package nl.scalda.pasimo.model.employeemanagement;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author jeroe
 */
public class CoachGroup implements Comparable<CoachGroup> {

    private int id;
    private String name;
    private Teacher teacher;
    private static TreeSet<CoachGroup> coachgroups = new TreeSet<>();
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
    private TreeSet<Student> students = new TreeSet<>();

    public CoachGroup() {
    }

    public CoachGroup(int id, String name, TreeSet<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.coachgroups.add(this);
    }

    public CoachGroup(String name, Teacher teacher ,TreeSet<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
        this.coachgroups.add(this);
    }

    public CoachGroup(String name, Teacher teacher, TreeSet<LessonGroup> lessonGroups, TreeSet<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.lessonGroups = lessonGroups;
        this.students = students;
        this.coachgroups.add(this);
    }

    public void addStudent(Student s, CoachGroup cg){
    	for(CoachGroup c : coachgroups){
    		if(cg.getId() == c.getId()){
    			c.students.add(s);
       		}
    	}
    }
    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TreeSet<LessonGroup> getLessonGroups() {
        return lessonGroups;
    }

    public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
        this.lessonGroups = lessonGroups;
    }
    
    public TreeSet<CoachGroup> getCoachgroups() {
		return coachgroups;
	}

	public void setCoachgroups(TreeSet<CoachGroup> coachgroups) {
		this.coachgroups = coachgroups;
	}

	public TreeSet<Student> getStudents() {
		return students;
	}

	public void setStudents(TreeSet<Student> students) {
		this.students = students;
	}
    
//</editor-fold>


	@Override
    public String toString() {
        return "\n CoachGroup: id= " +
               id +
               ", name= " +
               name +
               ", teacher= " +
               teacher +
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