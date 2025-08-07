package org.learning.StudentManagment.service;

import org.learning.StudentManagment.bean.Student;
import org.learning.StudentManagment.repository.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class StudentService {

    public StudentInterface studentInterface;
    @Autowired
    public StudentService(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    public void registerStudent(Student student){
        studentInterface.createStudent(student);
    }
}
