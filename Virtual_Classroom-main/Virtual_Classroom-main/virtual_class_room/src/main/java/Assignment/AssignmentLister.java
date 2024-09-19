/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment; //current package

//Importing necessary Packages
import Classroom.Classroom;
import Classroom.Interfaces;
import java.util.List;
import java.util.Map;

/*
AssginmentLister class here has the single responsibility of listing Assignments, and hence follow the 
Single Responsibility Principle
*/
public class AssignmentLister implements Interfaces<Assignment> { //it implements the interface named Interface of type Assignment

    private List<String> list_classroom; //instance variable to hold list of classrooms
    private Map<String, List<String>> map_assignment; //instance variable to hold map of classroom and students
    private String classroomName; //classroom name of which the assginment should be listed

    public AssignmentLister(Classroom classroom, Assignment assignment, String classroomName) {
        //initializing all the instance variables
        this.list_classroom = classroom.getClassrooms();
        this.map_assignment = assignment.getClassroomStudentMap(); //getClassroomStudentMap() is a getter class in Assigment.java
        this.classroomName = classroomName;

    }

    @Override //overriding add method in Interface
    public List<Assignment> list() {
        // find whether the classroom is present for which listing assingment is requested
        if (list_classroom.contains(classroomName)) {
            // if classroom present, print all the assignments assigned
            if (map_assignment.containsKey(classroomName)) {
                List<String> assignmentInClassroom = map_assignment.get(classroomName);
                System.out.println("Assignment in classroom " + classroomName + ":"); //logging the result
                for (String desc : assignmentInClassroom) {
                    System.out.println(desc);
                }
            }
        } else {
            // If the classroom is not found in list_classroom, print classroom not found
            System.out.println("Classroom not found: " + classroomName); //logging the result
        }
        return null;
    }

}
