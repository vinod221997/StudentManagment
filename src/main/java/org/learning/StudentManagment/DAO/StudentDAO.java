package org.learning.StudentManagment.DAO;

import org.learning.StudentManagment.bean.Address;
import org.learning.StudentManagment.bean.Student;
import org.learning.StudentManagment.repository.StudentInterface;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("student")
public  class StudentDAO implements StudentInterface {

    String url = "jdbc:postgresql://localhost:5432/StudentManagement";
    String uname = "postgres";
    String pass = "Chandu@2209";

    @Override
    public int createStudent(Student student) {
        String sql = "INSERT INTO Student (student_first_name,student_last_name," +
                "student_email,student_phone_number,student_date_of_birth," +
                "student_gender,student_enrollment_date,student_status) " +
                "VALUES (?,?,?,?,?,?,?,?) RETURNING student_id";
        try (Connection con = DriverManager.getConnection(url,uname,pass);
             PreparedStatement ps = con.prepareStatement(sql);) {
            Class.forName("org.postgresql.Driver");

            ps.setString(1, student.getStudentFirstName());
            ps.setString(2, student.getStudentLastName());
            ps.setString(3, student.getStudentEmail());
            ps.setLong(4, student.getStudentPhoneNumber());
            ps.setDate(5, Date.valueOf(student.getStudentDateOfBirth()));
            ps.setString(6, student.getStudentGender());
            ps.setDate(7, Date.valueOf(student.getStudentEnrollmentDate()));
            ps.setString(8, student.getStudentGender());
            try (ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                return rs.getInt("student_id");

            }
        }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
    public void registerAddress(Address address, int id) {

    }

    @Override
    public List<Student> getStudentDetialswithID(int id) {
        List<Student> studentList = new ArrayList<>();
        String sql = "select student_first_name,student_last_name,student_email,student_phone_number,student_date_of_birth,student_gender,student_enrollment_date,student_status from student where student_id = ?";
        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            Class.forName("org.postgresql.Driver");
            ps.setInt(1,id);
            try(ResultSet resultSet = ps.executeQuery();) {
                while (resultSet.next()) {
                    studentList.add(new Student(
                            resultSet.getString("student_first_name"),
                            resultSet.getString("student_last_name"),
                            resultSet.getString("student_email"),
                            resultSet.getLong("student_phone_number"),
                            resultSet.getDate("student_date_of_birth").toLocalDate(),
                            resultSet.getString("student_gender"),
                            resultSet.getDate("student_enrollment_date").toLocalDate(),
                            resultSet.getString("student_status")
                    ));
                }
            }

        } catch (SQLException | ClassNotFoundException  e) {
            System.out.println("You got an exception "+e );
        } catch (Exception e ){
            System.out.println("You got an exception "+e );
        }
        return studentList;
    }

    @Override
    public List<Address> getStudentAddressDetails(int id) {
        List<Address> addressList = new ArrayList<>();
        return addressList;
    }

    @Override
    public boolean updateStudentPhoneNumber(int id,long phoneNumber) {
        String sql = "update student set student_phone_number = ? where student_id =?";
        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            Class.forName("org.postgresql.Driver");
            ps.setLong(1,phoneNumber);
            ps.setInt(2,id);
            boolean isupdated = ps.executeUpdate()>0;
            if(isupdated){
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean updateStudentEmail(int id, String email) {
        String sql = "update student set student_email = ? where student_id =?";
        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            Class.forName("org.postgresql.Driver");
            ps.setString(1,email);
            ps.setInt(2,id);
            boolean isupdated = ps.executeUpdate()>0;
            if(isupdated){
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        String sql = "delete from student where student_id = ?";
        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            Class.forName("org.postgresql.Driver");
            ps.setInt(1,id);
            boolean updated = ps.executeUpdate() > 0;
            if(updated){
                return updated;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("we got exception "+e);
        }
        return false;
    }

    @Override
    public boolean updateStudentAddress(Address address, int id) {
        return false;
    }

    @Override
    public List<Student> getAllStudnets() {
        List<Student> studentList = new ArrayList<>();
        String sql = "select student_id, student_first_name,student_last_name,student_email,student_phone_number,student_date_of_birth,student_gender,student_enrollment_date,student_status from student";
        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            Class.forName("org.postgresql.Driver");
            try(ResultSet resultSet = ps.executeQuery();) {
                while (resultSet.next()) {
                    studentList.add(new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getString("student_first_name"),
                            resultSet.getString("student_last_name"),
                            resultSet.getString("student_email"),
                            resultSet.getLong("student_phone_number"),
                            resultSet.getDate("student_date_of_birth").toLocalDate(),
                            resultSet.getString("student_gender"),
                            resultSet.getDate("student_enrollment_date").toLocalDate(),
                            resultSet.getString("student_status")
                    ));
                }
            }

        } catch (SQLException | ClassNotFoundException  e) {
            System.out.println("You got an exception "+e );
        } catch (Exception e ){
            System.out.println("You got an exception "+e );
        }
        return studentList;
    }

}
