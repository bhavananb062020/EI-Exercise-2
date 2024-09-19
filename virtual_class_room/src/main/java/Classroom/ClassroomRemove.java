/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classroom;//current package

//importing required packages
import java.util.List;

/*
ClassroomRemove class here has the single responsibility of removing class, and hence follow the 
Single Responsibility Principle
*/
public class ClassroomRemove implements Interfaces<String> {//The class implements the Interface and Operate on String

    private Classroom classroom;

    public ClassroomRemove(Classroom classroom) {
        this.classroom = classroom;     //initializing the instance variable

    }

    @Override //overrideing the Interface
    public void remove(String className) {
        List<String> classrooms = classroom.getClassrooms(); //getClassrooms is a getter method in Classroom.java 
        //getClassrooms will return list of classrooms added so far

        // Check if the classroom name exists
        try {
            // Attempt to remove the classroom
            if (classrooms.contains(className)) {
                classrooms.remove(className); //remove the classroom
                System.out.println("Classroom removed: " + className); //loging the result
                System.out.println("Remaining classrooms: " + classrooms); //logging the result
            } else {
                System.out.println("Classroom not found: " + className); //logging the result
            }
        } catch (Exception e) {
            System.out.println("Error removing classroom: " + e.getMessage()); //logging the result
        }
    }
}
