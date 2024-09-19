package Classroom;
import java.util.List;

public class ClassroomUpdate implements Interfaces<String> {
    private Classroom classroom;

    public ClassroomUpdate(Classroom classroom) {
        this.classroom = classroom;
    }

    public void update(String oldClassName, String newClassName) {
        List<String> classrooms = classroom.getClassrooms();

        try {
            int index = classrooms.indexOf(oldClassName);
            if (index != -1) {
                classrooms.set(index, newClassName);
                System.out.println("Classroom updated: " + oldClassName + " to " + newClassName);
                System.out.println("Updated classrooms: " + classrooms);
            } else {
                System.out.println("Classroom not found: " + oldClassName);
            }
        } catch (Exception e) {
            System.out.println("Error updating classroom: " + e.getMessage());
        }
    }
}