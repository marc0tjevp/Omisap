/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.model.employeemanagement;

/**
 *
 * @author jeroe
 */
public class Student extends Person { //deze class word vervangen met die van jos/elroy als die van hun klaar zijn

    private String email;
    private int cardID;

    public Student() {

    }

    public Student(String name, String lastname, String email, int cardID) {
        super(name, lastname);
        this.email = email;
        this.cardID = cardID;
    }

//<editor-fold defaultstate="collapsed" desc="getters and setters">
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
//</editor-fold>

    @Override
    public String toString() {
        return "name= " + super.getName() + " ,lastname= " + super.getLastname() + " ,email=" + email + ", cardID=" + cardID;
    }

}
