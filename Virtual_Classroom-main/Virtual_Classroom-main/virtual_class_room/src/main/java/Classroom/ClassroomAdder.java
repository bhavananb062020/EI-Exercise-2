package Classroom; //current package

//importing required packages
import java.util.List;

/*
ClassroomAdder class here has the single responsibility of adding classrooms, and hence follow the 
Single Responsibility Principle
*/
public class ClassroomAdder implements Interfaces<String> {

    private Classroom classroom;

    public ClassroomAdder(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public void add(String className) {
        List<String> classrooms = classroom.getClassrooms();//getClassrooms is a getter method in Classroom.java 
        //getClassrooms will return list of classrooms added so far

        // Check if the classroom name is unique
        if (!classrooms.contains(className)) {
            classrooms.add(className); //add to the list
            System.out.println("Classroom added: " + className); //logging the result
            System.out.println("Classrooms added so far: " + classrooms);
        } else {
            System.out.println("Classroom with the same name already exists: " + className); //logging the result
        }
    }
}
