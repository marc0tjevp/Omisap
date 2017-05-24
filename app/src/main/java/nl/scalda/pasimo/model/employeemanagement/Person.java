package nl.scalda.pasimo.model.employeemanagement;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TreeSet;

import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class Person implements Comparable<Person> {

    private String email;
    private int cardID;
    private String firstName;
    private String insertion;
    private String lastName;
    private GregorianCalendar dateOfBirth;
    
    
    
    /**
     * default constructor.
     */
	public Person() {}
	
	/**
	 * constructor with only email.
	 * 
	 * @param email
	 */
	public Person(String email) {
		this.email = email;
    }
	public Person(int cardID, String email, String firstName) {
		this.cardID = cardID;
		this.firstName = firstName;
		this.email = email;
    }
	
	public Person(String firstName, String insertion, String lastName) {
		this.firstName = firstName;
		this.insertion = insertion;
		this.lastName = lastName;
    }


	/**
	 * constructor with all variables.
	 * 
	 * @param email
	 * @param cardID
	 * @param firstName
	 * @param insertion
	 * @param lastName
	 * @param yearOfBirth
	 * @param monthOfBirth
	 * @param dayOfBirth
	 */
    public Person(String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth){
		GregorianCalendar gc = new GregorianCalendar();
		this.setEmail(email);
		this.setCardID(cardID);
		this.setFirstName(firstName);
		this.setInsertion(insertion);
		this.setLastName(lastName);
		gc.set(yearOfBirth, monthOfBirth - 1, dayOfBirth);
		this.dateOfBirth = gc;
	}

    /**
     * Adds a note to the teacher.
     *
     * @param Note note
     * @see Note
     */
    /**
     * Removes a note from the person
     *
     * @param Note note
     * @see Note
     */
    

    //getters and setters
    public String getEmail() {
        return email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInsertion() {
        return insertion;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * returns the full name of the person.
     * used for displaying purposes in the view.
     * 
     * @return String
     */
	public String getFullName() {
        if (this.insertion != "null" && this.insertion != "" && this.insertion != null) {
            return this.getFirstName() + " " + this.getInsertion() + " " + this.getLastName();
        }
        return this.getFirstName() + " " + this.getLastName();
    }
    
    /**
     * returns the date of birth as readable string object.
     * 
     * @return String
     */
    public String getDateOfBirthInString(){
    	return this.getDateOfBirth().get(GregorianCalendar.DAY_OF_MONTH) + "-" + (this.getDateOfBirth().get(GregorianCalendar.MONTH)+1) + "-" + this.getDateOfBirth().get(GregorianCalendar.YEAR);
    }

    @Override
    public int compareTo(Person o) {
        return email.compareTo(o.getEmail());
    }
    
    public boolean isAvailable(){
    	
    	
    }
    
    

}