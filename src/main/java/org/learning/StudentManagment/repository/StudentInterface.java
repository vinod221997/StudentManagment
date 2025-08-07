package org.learning.StudentManagment.repository;

import org.learning.StudentManagment.bean.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentInterface {

    public void createStudent(Student student);
}
