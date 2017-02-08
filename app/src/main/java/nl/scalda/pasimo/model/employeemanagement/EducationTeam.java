package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

public class EducationTeam implements Comparable<EducationTeam> {

    private String name;
    private String abbreviation;
    private TreeSet<Teacher> teachers = new TreeSet<>();
    private TreeSet<CoachGroup> coachGroups = new TreeSet<>();

    public EducationTeam() {
    }

    public EducationTeam(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public EducationTeam(String name, String abbreviation, TreeSet<CoachGroup> couchGroups) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.coachGroups = couchGroups;
    }

    public EducationTeam(String name, String abbreviation, TreeSet<Teacher> teachers, TreeSet<CoachGroup> coachGroups) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.teachers = teachers;
        this.coachGroups = coachGroups;
    }

    public void addCouchGroup(CoachGroup coachGroup) {
        coachGroups.add(coachGroup);
    }

    public void updateCoachGroup(CoachGroup coachGroup) {
        for (CoachGroup ccg : coachGroups) {
            if (coachGroup.getId() == ccg.getId()) {
                ccg.setName(coachGroup.getName());
                ccg.setTeacher(coachGroup.getTeacher());
                ccg.setLessonGroups(coachGroup.getLessonGroups());
            }
        }
    }

    public void deleteCoachGroup(CoachGroup coachGroup) {
        coachGroups.remove(coachGroup);
    }
    
        public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        for (Teacher ct : teachers) {
            if (teacher.getAbbreviation().equals(ct.getAbbreviation())) {
                ct.setFirstName(teacher.getFirstName());
                ct.setInsertion(teacher.getInsertion());
                ct.setLastName(teacher.getLastName());
                ct.setCardID(teacher.getCardID());
                ct.setEmployeeNumber(teacher.getEmployeeNumber());
                ct.setEmail(teacher.getEmail());
 //               ct.setDateOfBirth(teacher.getDateOfBirth());
                ct.setNoteList(teacher.getNoteList());
            }
        }
    }

    public void deleteTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public TreeSet<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(TreeSet<Teacher> teachers) {
        this.teachers = teachers;
    }

    public TreeSet<CoachGroup> getCoachGroups() {
        return coachGroups;
    }

    public void setCoachGroups(TreeSet<CoachGroup> coachGroups) {
        this.coachGroups = coachGroups;
    }

    @Override
    public String toString() {
        return "EducationTeam{" + "name=" + name + ", abbreviation=" + abbreviation + ", couchGroups=" + coachGroups + '}';
    }

    @Override
    public int compareTo(EducationTeam o) {
        return abbreviation.compareTo(o.getAbbreviation());
    }
}
