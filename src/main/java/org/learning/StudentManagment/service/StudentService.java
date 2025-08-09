package org.learning.StudentManagment.service;

import org.learning.StudentManagment.bean.Address;
import org.learning.StudentManagment.bean.Student;
import org.learning.StudentManagment.repository.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentInterface studentOperation;
    private final StudentInterface addressOperation;

    @Autowired
    public StudentService(@Qualifier("student") StudentInterface studentOperation,
                          @Qualifier("address") StudentInterface addressOperation) {
        this.studentOperation = studentOperation;
        this.addressOperation = addressOperation;
    }

    public int registerStudent(Student student){
        int id = studentOperation.createStudent(student);
        return id;
    }

    public void registerAddress(Address address, int id){
       addressOperation.registerAddress(address,id);

    }

    public List<Student> getStudentDetials(int id) {
        List<Student> studentList = studentOperation.getStudentDetialswithID(id);
        return studentList;
    }

    public List<Address> getStudentAddressDetails(int id) {
        List<Address> addressList = addressOperation.getStudentAddressDetails(id);
    return addressList;
    }

    public boolean updateStudentPhoneNumber(int id, long phoneNumber) {
        return studentOperation.updateStudentPhoneNumber(id,phoneNumber);
    }

    public boolean updateStudentEmail(int id, String newemail) {
    return studentOperation.updateStudentEmail(id,newemail);
    }

    public boolean deleteStudent(int id) {
    return studentOperation.deleteStudent(id);
    }

    public boolean updateStudentAddress(Address address, int id) {
    return addressOperation.updateStudentAddress(address,id);
    }

    public List<Student> getAllStudnetDetails() {
        List<Student> studentList = studentOperation.getAllStudnets();
        return studentList;
    }
}
