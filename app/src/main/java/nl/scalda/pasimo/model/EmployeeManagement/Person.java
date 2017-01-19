/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.model.EmployeeManagement;

/**
 *
 * @author jeroe
 */
public class Person implements Comparable<Person>{ //deze class word vervangen met die van jos/elroy als die van hun klaar zijn

    private String name;
    private String lastname;

    public Person() {
    }

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

//<editor-fold defaultstate="collapsed" desc="getters and setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
//</editor-fold>

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "name= " + name + ", lastname= " + lastname;
    }

}
