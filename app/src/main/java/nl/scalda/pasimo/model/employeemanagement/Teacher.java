package nl.scalda.pasimo.model.employeemanagement;

<<<<<<< HEAD
=======

>>>>>>> develop
public class Teacher extends Person {

    private String abbreviation;
    private int employeeNumber;

    public Teacher() {

    }

    public Teacher(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Teacher(String abbreviation, int employeeNumber) {
        this.abbreviation = abbreviation;
        this.employeeNumber = employeeNumber;
    }

    public Teacher(int employeeNumber, String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        super(email, cardID, firstName, insertion, lastName, yearOfBirth, monthOfBirth, dayOfBirth);
        this.employeeNumber = employeeNumber;
        setAbbreviation();
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation() {
        this.abbreviation = getLastName().substring(0, 4).toUpperCase() + getFirstName().substring(0, 2).toUpperCase();
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
<<<<<<< HEAD

    public CoachGroup getCoachGroup() {
        //TODO
        return null;
=======
    
    public CoachGroup getCoachGroup(){
    	//TODO What todo???
    	return null;
    }
    
    public EducationTeam getEducationTeam(){
    	//FIXME this is terribly wrong!  Why use a EducationTeamlist in a testpackage? Use TestDAO instead.
//    	for(EducationTeam et : EducationTeamList.getInstance().getTeams()){
//			if(et.getTeachers().contains(this)){
//				return et;
//			}
//		}
    	return null;
>>>>>>> develop
    }

    @Override
    public String toString() {
        return "Teacher [abbreviation=" + abbreviation + ", employeeNumber=" + employeeNumber
                + ", cardID=" + getCardID() + ", name=" + getFullName() + "]";
    }

}
