package org.learning.StudentManagment.bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Student {
    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private long studentPhoneNumber;
    private LocalDate studentDateOfBirth;
    private String studentGender;
    private Address studentAddress;
    private LocalDate studentEnrollmentDate;
    private Department department;
    private List studentCourse;
    private String studentStatus;

    public Student() {
    }

    public Student( String studentFirstName, String studentLastName, String studentEmail, long studentPhoneNumber, LocalDate studentDateOfBirth, String studentGender,  LocalDate studentEnrollmentDate,  String studentStatus) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentGender = studentGender;
        this.studentEnrollmentDate = studentEnrollmentDate;
        this.studentStatus = studentStatus;
    }

    public Student(int studentId, String studentFirstName, String studentLastName, String studentEmail, long studentPhoneNumber, LocalDate studentDateOfBirth, String studentGender, LocalDate studentEnrollmentDate, String studentStatus) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentEmail = studentEmail;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentDateOfBirth = studentDateOfBirth;
        this.studentGender = studentGender;
        this.studentEnrollmentDate = studentEnrollmentDate;
        this.studentStatus = studentStatus;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public long getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(long studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public LocalDate getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(LocalDate studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }

    public LocalDate getStudentEnrollmentDate() {
        return studentEnrollmentDate;
    }

    public void setStudentEnrollmentDate(LocalDate studentEnrollmentDate) {
        this.studentEnrollmentDate = studentEnrollmentDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(List studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentPhoneNumber='" + studentPhoneNumber + '\'' +
                ", studentDateOfBirth=" + studentDateOfBirth +
                ", studentGender='" + studentGender + '\'' +
                ", studentAddress=" + studentAddress +
                ", studentEnrollmentDate=" + studentEnrollmentDate +
                ", department=" + department +
                ", studentCourse=" + studentCourse +
                ", studentStatus='" + studentStatus + '\'' +
                '}';
    }
}
