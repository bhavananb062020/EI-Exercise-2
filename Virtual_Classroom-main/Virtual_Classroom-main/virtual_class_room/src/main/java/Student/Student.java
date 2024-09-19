package Student;//current package

//Importing Necessary packages
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//The Student Class is solely responsible for holding data
//Business logic is implemented in differnt files, to separate data and logic
//Thereby it follows Single Responsibility Principle
public class Student {
    // Map to associate classrooms with lists of student IDs
    private static Map<String, List<String>> classroomStudentMap = new HashMap<>();

    public static Map<String, List<String>> getClassroomStudentMap() { //getter method for classroomStudentMap
        return classroomStudentMap;
    }
}
