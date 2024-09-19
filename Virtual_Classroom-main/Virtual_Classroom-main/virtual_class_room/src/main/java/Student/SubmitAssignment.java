package Student; //current package

//importing necessary packages
import java.util.Map;
import java.util.List;
import Assignment.Assignment;
import java.util.HashMap;
import Classroom.Interfaces;


/*
SubmitAssignment class here has the single responsibility of submitting student assignment, and hence follow the 
Single Responsibility Principle
 */
public class SubmitAssignment implements Interfaces<Student> {//implementing the interface and it operates on Student type

    private Map<String, String> submissionMap; // Create a map to store student submissions
    private Map<String, List<String>> map_assignment; //map to hold, map of classroom and assignment
    private String classroomName; //classroom to which student belong to
    private String assignmentDesc; //description of assignment
    private String studentId; //Id of a student

    // Constructor to initialize the instance variables
    public SubmitAssignment(Assignment assignment, String classroomName, String assignmentDesc, String StudentId) {

        //intitializing all instance variables
        this.submissionMap = new HashMap<>();
        this.map_assignment = assignment.getClassroomStudentMap();//getClassroomStudentMap is getter method in student 
        //and returns the map of classroom and student
        this.classroomName = classroomName;
        this.assignmentDesc = assignmentDesc;
        this.studentId = StudentId;
    }

    @Override //overriding the interface method
    public void submit(Student student) {
        // Find whether there exist a classroom, to which the assignment is being submitted
        if (map_assignment.containsKey(classroomName)) {
            // Get the list of assignments for the classroom
            List<String> assignments = map_assignment.get(classroomName);

            //Check if the classroom has specified assignment
            if (assignments.contains(assignmentDesc)) {
                // Add studentId as a key to submissionMap and assignmentDesc as its value
                submissionMap.put(studentId, assignmentDesc);
                System.out.println(studentId + " submitted the assignment: " + assignmentDesc);//logging
            } else {//if classroom has no such assignments
                System.out.println("Assignment not present in the classroom.");//logging
            }
        } else { //if classroom not present
            System.out.println("Classroom not found."); //logging
        }
    }
}
