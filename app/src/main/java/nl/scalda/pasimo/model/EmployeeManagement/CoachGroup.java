package nl.scalda.pasimo.model.EmployeeManagement;

import java.util.TreeSet;

/**
 *
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

    public CoachGroup(String name, Teacher teacher, TreeSet<LessonGroup> lessonGroups) {
        this.name = name;
        this.coach = teacher;
        this.lessonGroups = lessonGroups;
    }

    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
    }

    public void updateLessonGroup(LessonGroup lg) {
        for (LessonGroup clg : this.lessonGroups) {
            if (clg.getId() == lg.getId()) {
                clg.setName(lg.getName());
                clg.setStudents(lg.getStudents());
            }
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
        return "\n CoachGroup: id= " + id + ", name= " + name + ", coach= " + coach + ", lessongroup= " + lessonGroups;
    }

    @Override
    public int compareTo(CoachGroup o) {
//        int i = this.getTeacher().getAbbrevation().compareTo(o.getTeacher().getAbbrevation());
//        if(i == 0) return i;
        return name.compareTo(o.getName());
    }
}
