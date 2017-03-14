/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.model.employeemanagement;

import java.util.TreeSet;

/**
 *
 * @author jeroe
 */
public class LessonGroup implements Comparable<LessonGroup> {

    private int id;
    private String name;
    private TreeSet<Student> students = new TreeSet<>();

    public LessonGroup() {
    }

    public LessonGroup(String name) {
        this.name = name;
    }

    public LessonGroup(String name, TreeSet<Student> students) {
        this.name = name;
        this.students = students;
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public void updateStudent(Student s) {
        for (Student cs : this.students) {
            if (cs.getFirstName().equals(s.getFirstName())) {
                cs.setLastName(s.getLastName());
                cs.setEmail(s.getEmail());
                cs.setCardID(s.getCardID());
            }
        }
    }

    public void deleteStudent(Student s) {
        students.remove(s);
    }

//<editor-fold defaultstate="collapsed" desc="getters and setters">  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }

    public void setStudents(TreeSet<Student> students) {
        this.students = students;
    }
//</editor-fold>

    @Override
    public String toString() {
        return "LessonGroup: id= " + id + ", name= " + name + ", students= " + students;
    }

    @Override
    public int compareTo(LessonGroup lg) {
        return name.compareTo(lg.getName());
    }

}
