package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import nl.scalda.pasimo.test.CoachGroupList;

/**
 * @author jeroe
 */
public class CoachGroup implements Comparable<CoachGroup> {

    private int id;
    private String name;
    private Teacher teacher;
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();
    private EducationTeam currentEducationTeam;

    public CoachGroup() {
    }

    public CoachGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CoachGroup(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public CoachGroup(String name, Teacher teacher, EducationTeam currentEducationTeam) {
        this.name = name;
        this.teacher = teacher;
        this.currentEducationTeam = currentEducationTeam;
    }
    
    public CoachGroup(String name, Teacher teacher, TreeSet<LessonGroup> lessonGroups) {
        this.name = name;
        this.teacher = teacher;
        this.lessonGroups = lessonGroups;
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

    public EducationTeam getCurrentEducationTeam() {
		return currentEducationTeam;
	}

	public void setCurrentEducationTeam(EducationTeam currentEducationTeam) {
		this.currentEducationTeam = currentEducationTeam;
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