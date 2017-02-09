package nl.scalda.pasimo.model.employeemanagement;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;

import java.util.TreeSet;

public class EducationTeam implements Comparable<EducationTeam>{



    private TreeSet<Teacher> teachers = new TreeSet<>();

    /**
     * Abbreviation of the EducationTeam; e.g. AO
     */
    private String abbreviation;

    /**
     * Name of the EducationTeam; e.g. Applicatie Ontwikkelaar
     */
    private String name;

	public void addTeacher(Teacher t){
		System.out.println(t);
		teachers.add(t);
		System.out.println(teachers);
		if (teachers.add(t)) {
			System.out.println(teachers);
			//DAOFactory.getTheFactory().getDAOTeacher().create(t, this);
		}
		
	}
	
	public void deleteTeacher(Teacher t){
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

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters and setters">

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
    
    public void setTeachers(TreeSet<Teacher> teachers) {
		this.teachers = teachers;
	}

    //</editor-fold>

	@Override
    public int compareTo(EducationTeam o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "EducationTeam{" +
                "abbreviation='" + abbreviation + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}