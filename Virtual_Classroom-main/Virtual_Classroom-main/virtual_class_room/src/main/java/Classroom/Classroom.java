package Classroom;//current package

//importing necessary packages
import java.util.ArrayList;
import java.util.List;


//The Classroom Class is solely responsible for holding data
//Business logic is implemented in differnt files, to separate data and logic
//Thereby it follows Single Responsibility Principle
public class Classroom {
    //List data structure to store the list of classrooms
    private List<String> classrooms = new ArrayList<>();
    

    public List<String> getClassrooms() { //getter method for classrooms
        return classrooms;
    }
}
