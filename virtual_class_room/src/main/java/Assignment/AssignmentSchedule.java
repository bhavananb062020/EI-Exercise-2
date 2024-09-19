/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment; //current package

//importing necessary packages
import java.util.List;
import Classroom.Interfaces;
import java.util.Map;
import Classroom.Classroom;
import java.util.ArrayList;

/*
AssginmentSchedule class here has the single responsibility of scheduling assignments, and hence follow the 
Single Responsibility Principle
*/
public class AssignmentSchedule implements Interfaces<Assignment> { //This class implements the interface 

    private List<String> list_classroom; //list to store the list of classrooms
    private Map<String, List<String>> map_assignment; //map to store the map of assignment and classrooms
    private String description; //assignment description
    private String classroomName; //classroom name

    public AssignmentSchedule(Classroom classroom, Assignment assignment, String description, String classroomName) {
        //Intializaing all the instance variables
        list_classroom = classroom.getClassrooms(); //getClassrooms() is a getter method in Classroom.java
        map_assignment = assignment.getClassroomStudentMap(); //getClassroomStudentMap is a getter method in Assignment.java
        this.description = description;
        this.classroomName = classroomName;

    }

    @Override //overriding the interface method add
    public void add(Assignment assignment) {

        //Find whether the classroom present for which the assignment to be added
        if (list_classroom.contains(classroomName)) {
            List<String> assignments = map_assignment.get(classroomName);

            // No two assignments with the same name is submitted in the class
            if (assignments != null) {
                // The assignments list is not null, so it's safe to check for duplicates
                if (assignments.contains(description)) {
                    System.out.println("The classroom already has this assignment."); //logging the result
                    //No two assginments in the same class should be same
                } else {
                    // Add the assignment to the list
                    assignments.add(description);
                    System.out.println("added assignment :  " + description + " to classroom: " + classroomName);
                    //logging the result
                }
//       
            } else {
                // If the given assignment is unique, 
                map_assignment.computeIfAbsent(classroomName, k -> new ArrayList<>()).add(description);
                System.out.println("added assignment :  " + description + " to classroom: " + classroomName);
                //loging the result
            }
        } else {
            // If classroomName is not in list_classroom, print classroom not found
            System.out.println("Classroom not found: " + classroomName);//logging the result
        }
    }

}
