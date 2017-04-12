package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

import nl.scalda.pasimo.datalayer.factory.DAOFactory;

public class LessonGroup implements Comparable<LessonGroup> {

	/**
	 * 
	 */
	private int id;
	
	/**
	 * The name of this lesson group
	 * <p>
	 * e.g. ICO41A, ICO42B
	 */
	private String name;

	/**
	 * The {@link Student}'s who are in this lesson group
	 */
	private TreeSet<Student> students;

	/**
	 * @param name The name of this lesson group
	 */
	public LessonGroup(String name) {
		this.name = name;
		this.students = new TreeSet<>();
	}

	/**
	 * @param name
	 *            The name of this lesson group
	 */
	public LessonGroup(int id, String name) {
		this(name);
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Retrieves the index of this lesson group
	 *
	 * @return The index of this lesson group
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the index of this lesson group
	 *
	 * @param name
	 *            The index of this lesson group to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the {@link Student}'s who are in this lesson group
	 *
	 * @return The {@link Student}'s who are in this lesson group
	 */
	public TreeSet<Student> getStudents() {
		return this.students;
	}

	/**
	 * Sets the {@link Student}'s who are in this lesson group
	 *
	 * @param students
	 *            The {@link Student}s to set who are in this lesson group
	 */
	public void setStudents(TreeSet<Student> students) {
		this.students = students;
	}

	/**
	 * Adds an {@link Student} to the lesson group
	 *
	 * @param student
	 *            The student to add to the lesson group
	 */
	public void addStudent(Student student) {
		this.students.add(student);
		
	}

	/**
	 * Removes an {@link Student} from the lesson group
	 *
	 * @param student
	 *            The student to remove from the lesson group
	 */
	public void deleteStudent(Student student) {
		this.students.remove(student);
	}

	@Override
	public String toString() {
		return "LessonGroup: name= " + name + ", students= " + students;
	}

	/**
	 * Sorts the lesson groups by name when adding a lesson group to a TreeSet
	 *
	 * @param lessonGroup
	 *            The {@link LessonGroup} to sort
	 * @return ..
	 */
	@Override
	public int compareTo(LessonGroup lessonGroup) {
		return name.compareTo(lessonGroup.getName());
	}
}