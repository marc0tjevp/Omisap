package nl.scalda.pasimo.model.employeemanagement;

import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Person implements Comparable<Person> {

    private String email;
    private int cardID;
    private String firstName;
    private String insertion;
    private String lastName;
    private TreeSet<Note> noteList;
    private GregorianCalendar dateOfBirth;

	public Person() {
    }

    public Person(String email, int cardID, String firstName, String insertion, String lastName, int yearOfBirth, int monthOfBirth, int dayOfBirth){
		GregorianCalendar gc = new GregorianCalendar();
		this.setEmail(email);
		this.setCardID(cardID);
		this.setFirstName(firstName);
		this.setInsertion(insertion);
		this.setLastName(lastName);
		gc.set(yearOfBirth, monthOfBirth - 1, dayOfBirth);
		this.dateOfBirth = gc;
		this.noteList = new TreeSet<Note>();
	}

    /**
     * Adds a note to the teacher.
     *
     * @param Note note
     * @see Note
     */
    public void addNote(Note note) {
        this.noteList.add(note);
    }

    /**
     * Removes a note from the person
     *
     * @param Note note
     * @see Note
     */
    public void removeNote(Note note) {
        this.noteList.remove(note);
    }

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

	public String getFullName() {
        if (this.insertion != "" && this.insertion != null) {
            return this.getFirstName() + " " + this.getInsertion() + " " + this.getLastName();
        }
        return this.getFirstName() + " " + this.getLastName();
    }

    public TreeSet<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(TreeSet<Note> noteList) {
        this.noteList = noteList;
    }

    @Override
    public int compareTo(Person o) {
        return email.compareTo(o.getEmail());
    }

}
