package Student; //current package

//importing necessary packages
import Classroom.Classroom;
import Classroom.Interfaces;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/*
AddStudent class here has the single responsibility of adding studnets, and hence follow the 
Single Responsibility Principle
 */
public class AddStudent implements Interfaces<String> {//implements the Interface and operate on String type

    private List<String> list_classroom;// instance variable to hold list of classrooms
    private Map<String, List<String>> map_classroom; //instance variable to hold map of classroom and students
    private String classroomName; //classroom name to which the student is added
    private String studentId;//Id of a student

    public AddStudent(Student student, Classroom classroom, String classroomName, String studentId) {
        //initializing all the instance variables
        this.list_classroom = classroom.getClassrooms();
        this.map_classroom = student.getClassroomStudentMap();
        this.classroomName = classroomName;
        this.studentId = studentId;
    }

    @Override //overriding the interface method add
    public void add(String Student) {
        // Before adding student, find whether the classroom given exist
        if (list_classroom.contains(classroomName)) {
            // One student can register to only one class
            for (Map.Entry<String, List<String>> entry : map_classroom.entrySet()) {
                String key = entry.getKey();
                List<String> studentList = entry.getValue();
                if (studentList.contains(studentId)) {
                    // If the student Id already exists as a value in the map, print the classroom (map key) where it exists
                    System.out.println("Student with the same ID already exists in the classroom: " + key); //logging results
                    return;
                }
            }

            // If the given student id is unique
            map_classroom.computeIfAbsent(classroomName, k -> new ArrayList<>()).add(studentId);
            System.out.println("Student added with ID: " + studentId + " to classroom: " + classroomName); //logging results
        } else {
            // If classroomName is not added before adding students
            System.out.println("Classroom not found: " + classroomName); //logging results
        }
    }
}
