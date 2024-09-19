package Classroom; //current package


/*
ClassroomLister class here has the single responsibility of listing classrooms, and hence follow the 
Single Responsibility Principle
*/
public class ClassroomLister {

    private Classroom classroom;

    public ClassroomLister(Classroom classroom) {
        this.classroom = classroom; //initializing the instance variable
    }

    public void list() {
        System.out.println("List of Classrooms:");
        for (String className : classroom.getClassrooms()) { //getClassrooms is a getter method in Classroom.java 
        //getClassrooms will return list of classrooms added so far
            System.out.println(className);//looping through list and printing items
        }
    }
}
