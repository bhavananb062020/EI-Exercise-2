package Student; //current package

//importing necessary packages
import Classroom.Classroom;
import Classroom.Interfaces;
import java.util.List;
import java.util.Map;

/*
ListStudent class here has the single responsibility of listing studnets, and hence follow the 
Single Responsibility Principle
 */
public class ListStudent implements Interfaces<String> {//implementing Interface and operates on String type

    private Classroom classroom;
    private List<String> list_classroom; //list to hold list of classrooms
    private Map<String, List<String>> map_classroom; //map to hold, map of classroom and students
    private String classroomName; //classroom name of which the students must be listed

    public ListStudent(Classroom classroom, Student student, String classroomName) {

        //initializing all instance variables
        this.classroom = classroom;
        this.list_classroom = classroom.getClassrooms(); //getClassrooms is a getter method in Classroom.java 
        //and returns the list of classrooms
        this.map_classroom = student.getClassroomStudentMap(); //getClassroomStudentMap is getter method in student 
        //and returns the map of classroom and student
        this.classroomName = classroomName;
    }

    @Override
    public List<String> list() {
        // Find whether the classroom requested exist
        if (list_classroom.contains(classroomName)) {
            // if yes, loop through map and print all the values of key that matches the classroomName
            if (map_classroom.containsKey(classroomName)) {
                List<String> studentsInClassroom = map_classroom.get(classroomName);

                System.out.println("Students in classroom " + classroomName + ":");
                for (String studentId : studentsInClassroom) {
                    System.out.println(studentId);
                }
            }
        } else {
            // If the classroom is not found in list_classroom, print classroom not found
            System.out.println("Classroom not found: " + classroomName); //logging
        }
        return null;
    }
}
