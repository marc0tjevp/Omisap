package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import javax.persistence.*;

import nl.scalda.pasimo.datalayer.testdao.TestDAOLessonGroup;

/**
 * @author jeroe
 */
@Entity
@Table(name="coach_group")
public class CoachGroup implements Comparable<CoachGroup> {

	@Id
	@Column(name="coachGroupID", length=64, nullable=false)
    private int id;
	
	@Column(name="name", length=64)
    private String name;
	
	@OneToOne
    private Teacher teacher;

    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();

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

    public CoachGroup(String name, Teacher teacher, TreeSet<LessonGroup> lessonGroups) {
        this.name = name;
        this.teacher = teacher;
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