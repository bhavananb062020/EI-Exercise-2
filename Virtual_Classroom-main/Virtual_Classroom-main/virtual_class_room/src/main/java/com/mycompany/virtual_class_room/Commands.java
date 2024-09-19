/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.virtual_class_room;

//Commands has the single functionality to define the pre-defined commands that the user can use
public class Commands {
    //defining action commands
    static String input_add_class = "add_classroom";
    static String input_list_class = "list_classroom";
    static String input_remove_class = "remove_classroom";

    static String input_update_class = "update_classroom";
    static String input_add_stu = "add_student";
    static String input_list_stu = "list_students";
    static String input_submit_assignment = "submit_assignment";
    static String input_schedule_assignment = "schedule_assignment";
    static String input_list_assignment = "list_assignments";


    
    //string formatted and stored in a variable for easy acess
    static String input_format = String.format("Enter any one of the below command or press exit to stop\n\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n\n",
            input_add_class, " classroom_name: to create class",
            input_list_class, ": to list classes",
            input_remove_class, " classroom_name: to remove class",
            input_update_class,"oldClassroom newClassroom : to update class",
            input_add_stu, " student_id classroom_name : to add student",
            input_list_stu, " classroom_name: to list students",
            input_submit_assignment, " student_id classroom_name assignment_description: to submit assignment",
            input_schedule_assignment, " classroom_name assignment_description: to add assignment",
            input_list_assignment, " classroom_name: to list assignments");
    

}

