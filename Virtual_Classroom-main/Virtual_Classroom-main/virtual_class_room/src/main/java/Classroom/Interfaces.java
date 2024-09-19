package Classroom; //current package

//importing necessary packages
import java.util.List;

/*The interface here is built according to factory design patter
It allows the subclasses to define there own methods by implementing Interfaces
*/

/*
Also the Interface follows the Interface Segregation Principle by not forcing the 
subclasses to implement the method that they don't want to, by defining methods as default
and Open/Closed principle by which any extra functionality can be added with the use of Interface without, 
disturbing the rest of code
*/
public interface Interfaces<T> { //defining interface that can operate on the type T

    default void add(T entity) { //to add items:used by ClassroomAdder.java, AddStudent.java
        // Default empty implementation
    }

    default List<T> list() { //to list items: used by ClassroomLister.java, ListStudent.java
        // Default empty implementation
        return null;
    }

    default void remove(T entity) { //to remove items: used by ClassroomRemove.java
        // Empty default implementation
    }

    default void submit(T entity) { //to submit items : used by SubmitAssignment.java
        // Empty default implementation
    }

    default void schedule(T entity) { //to schedule items: used by AssignmentSchedule.java
        // Empty default implementation
    }
}
