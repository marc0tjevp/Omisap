package nl.scalda.pasimo.service;

import java.util.ArrayList;

import nl.scalda.pasimo.model.employeemanagement.Student;
import nl.scalda.pasimo.model.presenceregistration.CheckIn;

public class StudentService
{
	private static StudentService instance = null;

	public void checkInData(Student z)
	{

		ArrayList<CheckIn> tempCheckIns = new ArrayList<>();
		CheckIn c = new CheckIn(0, 211543, 2017, 05, 13, 8, 30, 43);
		CheckIn d = new CheckIn(0, 211543, 2017, 05, 16, 9, 05, 11);
		tempCheckIns.add(c);
		tempCheckIns.add(d);

		z.getStudentCheckIns().addAll(tempCheckIns);
		System.out.println(z.studentCheckIns);
		System.out.println(tempCheckIns);
	}

	public static StudentService getInstance()
	{
		if (instance == null)
		{
			instance = new StudentService();
		}
		return instance;
	}

	public static void setInstance(StudentService instance)
	{
		StudentService.instance = instance;
	}

}
