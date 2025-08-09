package org.learning;


import org.learning.StudentManagment.bean.Address;
import org.learning.StudentManagment.bean.Student;
import org.learning.StudentManagment.configuration.AppConfiguration;
import org.learning.StudentManagment.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        StudentService studentService = context.getBean("studentService", StudentService.class);
        System.out.println("====Welcome to the Student Management Appliaction====");
        while(true) {
            System.out.println("====Please Select the operation you need to perform====");
            System.out.println("1. Register Student");
            System.out.println("2.View your Student Details");
            System.out.println("3. Update Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Address");
            System.out.println("6. View All The Students");
            System.out.println("7. Exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    createStudent(sc, studentService);
                    break;
                case 2:
                    viewStudent(sc,studentService);
                    break;
                case 3:
                    updateStudent(sc,studentService);
                    break;
                case 4:
                    deleteStudent(sc,studentService);
                    break;
                case 5:
                    updateAddress(sc,studentService);
                    break;
                case 6:
                    viewAllStudents(sc,studentService);
                    break;
                case 7:
                    sc.close();
                    System.out.println("Thanks For using Application");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select correct operation");
            }
        }

    }

    private static void updateAddress(Scanner sc, StudentService studentService) {
        System.out.println("Welcome to Update Address Module");
        System.out.println("Please Enter your student Id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Please Enter your Street Address");
        String street =  sc.nextLine();
        System.out.println("Please Enter your City");
        String city = sc.nextLine();
        System.out.println("Please Enter your State");
        String state = sc.nextLine();
        System.out.println("Please Enter your ZIP Code");
        int zip = sc.nextInt();
        System.out.println("Please Enter your Country Name");
        sc.nextLine();
        String country = sc.nextLine();
        boolean update = studentService.updateStudentAddress(new Address(street,city,state,zip,country),id);
    }

    private static void viewAllStudents(Scanner sc, StudentService studentService) {
        System.out.println("Welcome to View All Students Module");
        List<Student> studentList = studentService.getAllStudnetDetails();
        for(Student s : studentList ){
            System.out.println(s.toString());
        }
    }

    private static void deleteStudent(Scanner sc, StudentService studentService) {
        System.out.println("Welcome to Delete Student Module");
        System.out.println("Enter the Student Id which you want to delete ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean update = studentService.deleteStudent(id);
        if(update){
            System.out.println("Student is deleted");
        }else{
            System.out.println("Something Went Wrong");
        }
    }

    private static void updateStudent(Scanner sc, StudentService studentService) {
        System.out.println("Welcome to  Update Student Details Module");
        System.out.println("Please Enter your Student ID");
        int id = sc.nextInt();
        sc.nextLine();
        boolean value = true;
        while(value){
            System.out.println("Please Enter Your Operation");
            System.out.println("1. Update Phone Number");
            System.out.println("2. Update Email");
            System.out.println("3. Go Back");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input){
                case 1:
                    System.out.println("Please Enter your New Mobile Number");
                    long phoneNumber = sc.nextLong();
                    sc.nextLine();
                    boolean phone = studentService.updateStudentPhoneNumber(id,phoneNumber);
                    if (phone){
                        System.out.println("Phone Number Update Sucessfull");
                    }else{
                        System.out.println("Something Went wrong try after sometime");
                    }
                    break;
                case 2:
                    System.out.println("Please Enter your New EMail");
                    String newemail = sc.nextLine();
                    boolean email = studentService.updateStudentEmail(id,newemail);
                    if (email){
                        System.out.println("Email Update Sucessfull");
                    }else{
                        System.out.println("Something Went wrong try after sometime");
                    }
                    break;
                case 3:
                    value = false;
                    break;
                default:
                    System.out.println("Please Select correct Input");

            }
        }
    }

    private static void viewStudent(Scanner sc, StudentService studentService) {
        System.out.println("Welcome to View Student Module");
        System.out.println("Please Enter your Student ID");
        int id = sc.nextInt();
        List<Student> studentlist = studentService.getStudentDetials(id);
        List<Address> addressList = studentService.getStudentAddressDetails(id);
        boolean value = true;
        while(value) {
            System.out.println("Please Enter Your Operation");
            System.out.println("1. View Student Details");
            System.out.println("2. View Address Details");
            System.out.println("3. View Both");
            System.out.println("4. Go Back");
            int input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 1:
                    System.out.println("Please find the student Details");
                    for (Student s : studentlist) {
                        System.out.println(s.toString());
                    }
                    break;
                case 2:
                    System.out.println("Please find the student Address Details");
                    for (Address a : addressList) {
                        System.out.println(a.toString());
                    }
                    break;
                case 3:
                    System.out.println("Please find the student Details & Address Details");
                    studentlist.forEach(System.out::println);
                    addressList.forEach(System.out::println);
                    break;
                case 4:
                    value = false;
                    break;
                default:
                    System.out.println("Please Select correct Input");
            }
        }
    }

    public static void createStudent(Scanner sc, StudentService studentService){
        System.out.println("Please Enter your First Name");
        sc.nextLine();
        String firstName = sc.nextLine();
        System.out.println("Please Enter your Last Name");
        String lastName = sc.nextLine();
        System.out.println("Please Enter your Email");
        String email = sc.nextLine();
        System.out.println("Please Enter your PhoneNumber");
        long PhoneNumber = sc.nextLong();
        System.out.println("Please Enter your Date of Birth in yyyy-mm-dd");
        sc.nextLine();
        String date = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(date,formatter);
        System.out.println("Please Enter your Gender");
        String gender = sc.nextLine();
        LocalDate enroll = LocalDate.now();
        String status = String.valueOf(Status.ACTIVE);
        int id = studentService.registerStudent(new Student(firstName,lastName,email,PhoneNumber,dob,gender,enroll,status));
        if(id != 0){
            System.out.println("Please Enter your Street Address");
            String street =  sc.nextLine();
            System.out.println("Please Enter your City");
            String city = sc.nextLine();
            System.out.println("Please Enter your State");
            String state = sc.nextLine();
            System.out.println("Please Enter your ZIP Code");
            int zip = sc.nextInt();
            System.out.println("Please Enter your Country Name");
            sc.nextLine();
            String country = sc.nextLine();
            studentService.registerAddress(new Address(street,city,state,zip,country),id);

            System.out.println("Student Registration was Sucessfull");
            System.out.println("Please find your ID"+id);

        }else{
            System.out.println("Registration was Unsucessfull please try later");
        }
    }
}
