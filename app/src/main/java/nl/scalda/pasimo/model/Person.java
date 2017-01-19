package nl.scalda.pasimo.model;

import java.util.Date;

public class Person implements Comparable<Person> {

	private String email;
	private int cardID;
	private String firstName;
	private String insertion;
	private String lastName;
	private Date dateOfBirth;
	
	public Person() {}
	
	public Person(String email, int cardID, String firstName, String insertion, String lastName, Date dateOfBirth){
		this.setEmail(email);
		this.setCardID(cardID);
		this.setFirstName(firstName);
		this.setInsertion(insertion);
		this.setLastName(lastName);
		this.setDateOfBirth(dateOfBirth);
	}

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFullName(){
		if(this.insertion != "" && this.insertion != null){
		return this.getFirstName()+" "+this.getInsertion()+" "+this.getLastName();
		}
		return this.getFirstName()+" "+this.getLastName();
	}

	@Override
	public int compareTo(Person o) {
		return email.compareTo(o.getEmail());
	}

}
