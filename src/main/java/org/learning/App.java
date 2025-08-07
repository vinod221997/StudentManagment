package org.learning;


import org.learning.StudentManagment.bean.Student;
import org.learning.StudentManagment.configuration.AppConfiguration;
import org.learning.StudentManagment.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        StudentService studentService = context.getBean("studentService",StudentService.class);
        studentService.registerStudent(new Student());
    }
}
