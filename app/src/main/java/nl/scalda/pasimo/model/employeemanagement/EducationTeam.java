package nl.scalda.pasimo.model.employeemanagement;

<<<<<<< HEAD
import nl.scalda.pasimo.datalayer.factory.DAOFactory;
=======
>>>>>>> develop
import java.util.TreeSet;

public class EducationTeam implements Comparable<EducationTeam> {

    private TreeSet<Teacher> teachers;

    /**
     * Abbreviation of the EducationTeam; e.g. AO
     */
    private String abbreviation;
    /**
     * Name of the EducationTeam; e.g. Applicatie Ontwikkelaar
     */
    private String name;

    public void addTeacher(Teacher t) {
        if (teachers.add(t)) {
            //DAOFactory.getTheFactory().getDAOTeacher().create(t, this);
        }

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

    public void deleteTeacher(Teacher t) {
        if (teachers.remove(t)) {
            //DAOFactory.getTheFactory().getDAOTeacher().delete(t, this);
        }

    }

    public TreeSet<Teacher> getTeachers() {
        return teachers;
    }

    public EducationTeam(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(EducationTeam o) {
        return this.name.compareTo(o.getName());

    }

    @Override
    public String toString() {
        return "EducationTeam{" + "abbreviation='" + abbreviation + '\'' + ", name='" + name + '\'' + '}';
    }    
}
