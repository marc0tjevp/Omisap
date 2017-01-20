package nl.scalda.pasimo.model.EmployeeManagement;

import nl.scalda.pasimo.datalayer.DAOFactory;

import java.util.TreeSet;

public class EducationTeam {

    private int id;
    private String name;
    private TreeSet<LessonGroup> lessonGroups = new TreeSet<>();

    public EducationTeam() {

    }

    public EducationTeam(int id, String name, TreeSet<LessonGroup> lessonGroups) {
        this.id = id;
        this.name = name;
        this.lessonGroups = lessonGroups;
    }

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

    public TreeSet<LessonGroup> getLessonGroups() {
        return lessonGroups;
    }

    public void setLessonGroups(TreeSet<LessonGroup> lessonGroups) {
        this.lessonGroups = lessonGroups;
    }

    public boolean addLessonGroup(LessonGroup lg) {
        return lessonGroups.add(lg);

    }

    public void save() {

    }
}
