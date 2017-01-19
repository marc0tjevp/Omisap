/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.scalda.pasimo.interfaces;

import nl.scalda.pasimo.model.EmployeeManagement.LessonGroup;

/**
 *
 * @author jeroe
 */
public interface IDAOLessonGroup {

    public void create(LessonGroup LessonGroup);

    public LessonGroup read(LessonGroup LessonGroup);

    public void update(LessonGroup oldLessonGroup, LessonGroup newLessonGroup);

    public void delete(LessonGroup LessonGroup);
}