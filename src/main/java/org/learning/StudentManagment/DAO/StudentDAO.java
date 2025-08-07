package org.learning.StudentManagment.DAO;

import org.learning.StudentManagment.bean.Student;
import org.learning.StudentManagment.repository.StudentInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public class StudentDAO implements StudentInterface {

    @Override
    public void createStudent(Student student) {
        System.out.println("Student profile Created");
    }
}
