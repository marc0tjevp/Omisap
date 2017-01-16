/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.models.EmployeeManagement;

/**
 *
 * @author jeroe
 */
public class CoachGroup {

    private int id;
    private String name;
//    private Teacher teacher;
//    private TreeSet<Student> students;

    public CoachGroup() {
    }

    public CoachGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    public CoachGroup(String name, Teacher teacher){
//        this.name = name;
//        this.teacher = teacher;
//    }
//    public CoachGroup(String name, Teacher teacher, TreeSet<Student> students){
//        this.name = name;
//        this.teacher = teacher;
//        this.students.add(students);
//    }
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

//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//    public TreeSet<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(TreeSet<Student> students) {
//        this.students = students;
//    }
//</editor-fold>
}
