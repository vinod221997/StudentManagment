package org.learning.StudentManagment.repository;

import org.learning.StudentManagment.bean.Address;
import org.learning.StudentManagment.bean.Student;
import org.springframework.stereotype.Component;

import java.util.List;


public interface StudentInterface {

    public int createStudent(Student student);
    public void registerAddress(Address address, int id);

    List<Student> getStudentDetialswithID(int id);

    List<Address> getStudentAddressDetails(int id);

    boolean updateStudentPhoneNumber(int id, long phoneNumber);

    boolean updateStudentEmail(int id,String newemail);

    boolean deleteStudent(int id);

    boolean updateStudentAddress(Address address, int id);

    List<Student> getAllStudnets();
}
