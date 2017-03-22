/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import nl.scalda.pasimo.model.employeemanagement.Student;

/**
 *
 * @author jeroe
 */
public class CSVReader {

    private TreeSet<Student> students = new TreeSet<>();

    public TreeSet<Student> readFile(String fileLocation) {
        String csvFile = fileLocation;
        String line = "";
        String cvsSplitBy = ";";
        int iteration = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                Student s = new Student("test");
                if (iteration != 0) {
                    iteration++;

                    // use comma as separator
                    String[] currentstudent = line.split(cvsSplitBy);

                    //System.out.println("Country [code= " + currentstudent[0] + " , name=" + currentstudent[1] + "]");
                    s.setFirstName(currentstudent[1]);
                    if(currentstudent[2].equals("")){
                        s.setLastName(currentstudent[3]);
                    }else{
                        s.setLastName(currentstudent[2] + " " + currentstudent[3]);
                    }
                    s.setEmail(currentstudent[4]);
                s.setCardID(Integer.parseInt(currentstudent[0]));
                    students.add(s);
                } else {
                    iteration++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }

}
