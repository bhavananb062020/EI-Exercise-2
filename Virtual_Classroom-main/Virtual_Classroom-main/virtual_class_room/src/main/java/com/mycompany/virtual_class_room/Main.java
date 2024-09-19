package com.mycompany.virtual_class_room;//Main package
//Look at documenation for more help
//importing all other packages: 3 different packages for student,classroom,
//and Assignment, Main function is created to modularize the code
import Classroom.Classroom;
import Classroom.ClassroomAdder;
import Classroom.ClassroomLister;
import Classroom.ClassroomRemove;
import Classroom.ClassroomUpdate;
import Student.AddStudent;
import Student.ListStudent;
import Student.Student;
import Student.SubmitAssignment;
import Assignment.Assignment;
import Assignment.AssignmentLister;
import Assignment.AssignmentSchedule;

import java.util.Scanner; //importing Scanner Class

//Main Class has a single responsibility of calling the respective classes on input type
// And thus it follows, Single Responsibility Principle (SRP)
public class Main {

    public static void main(String[] args) {
        System.out.println(Commands.input_format); //taking the user input
        Scanner scan = new Scanner(System.in); //scanner object initialization
        System.out.println("Enter your command: ");
        String input = scan.nextLine(); //accepts a line of text as input
        String[] parts = input.split(" "); //inputs are splitted to identify differnt keywords

        //initializing all the Classes
        Classroom classroom = new Classroom();
        ClassroomAdder classroomAdder = new ClassroomAdder(classroom);
        ClassroomLister classroomLister = new ClassroomLister(classroom);
        ClassroomRemove classroomRemove = new ClassroomRemove(classroom);
        ClassroomUpdate classroomUpdate = new ClassroomUpdate(classroom);
        Student student = new Student();
        Assignment assignment = new Assignment();

        while (true) {
            try {
                if (input.contains(Commands.input_add_class)) {
                    String classroomName = parts[1].trim();
                    classroomAdder.add(classroomName); //call to add class
                } else if (input.contains(Commands.input_list_class)) {
                    classroomLister.list(); //call to list class
                } else if (input.contains(Commands.input_remove_class)) {
                    classroomRemove.remove(parts[1]); //call to remove class
                }else if (input.contains(Commands.input_update_class)) {
                    String oldClassroom = parts[1]; //assignign the splitted input to meaningful keywords
                    String newClassroom = parts[2];
                    classroomUpdate.update(oldClassroom,newClassroom); //call to update class
                }else if (input.contains(Commands.input_add_stu)) {
                    String classroomName = parts[2]; //assignign the splitted input to meaningful keywords
                    String studentId = parts[1];
                    AddStudent addStudent = new AddStudent(student, classroom, classroomName, studentId);
                    addStudent.add(parts[1]); //call to add student
                } else if (input.contains(Commands.input_list_stu)) {
                    String classroomName = parts[1].trim(); //trim is used to remove trailing and leading spaces
                    ListStudent liststudent = new ListStudent(classroom, student, classroomName); // List students in the specified classroom
                    liststudent.list();//call to list student
                } else if (input.contains(Commands.input_submit_assignment)) {
                    String studentId = parts[1]; //assignign the splitted input to meaningful keywords
                    String classroomName = parts[2];
                    String assignmentDesc = parts[3];
                    SubmitAssignment submitAssignment = new SubmitAssignment(assignment, classroomName, assignmentDesc, studentId);
                    submitAssignment.submit(student); //call to submit assignment
                } else if (input.contains(Commands.input_schedule_assignment)) {
                    String classroomName = parts[1]; //assignign the splitted input to meaningful keywords
                    String assignmentDesc = parts[2];
                    AssignmentSchedule addAssignment = new AssignmentSchedule(classroom, assignment, assignmentDesc, classroomName);
                    addAssignment.add(assignment); //call to add assignment
                } else if (input.contains(Commands.input_list_assignment)) {
                    String classroomName = parts[1]; //assignign the splitted input to meaningful keywords
                    AssignmentLister listAssignment = new AssignmentLister(classroom, assignment, classroomName);
                    listAssignment.list(); //call to list assginment
                } else if (input.equals("exit")) {
                    break; //to end the session and end input taking
                } else if (input.equals("help")) { //to print available commands on user request
                    System.out.printf("Available commands are %s\n", Commands.input_format);
                } else {
                    System.out.println("Invalid command. Please try again.");
                }
            } catch (Exception e) { //Exceptional handling to handle any error
                System.out.println(e.getMessage());
                System.out.printf("Available commands are %s\n", Commands.input_format);
            }
            System.out.println("Another input"); //continue taking input
            input = scan.nextLine(); //input line of text
            parts = input.split(" "); //split the input
        }

        scan.close(); //close the scanner class to make avoid resource leak
    }
}
