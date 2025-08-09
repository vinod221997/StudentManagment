package org.learning.StudentManagment.DAO;

import org.learning.StudentManagment.bean.Address;
import org.learning.StudentManagment.bean.Student;
import org.learning.StudentManagment.repository.StudentInterface;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



@Repository("address")
public  class AddressDAO implements StudentInterface {
    String url = "jdbc:postgresql://localhost:5432/StudentManagement";
    String uname = "postgres";
    String pass = "Chandu@2209";

    @Override
    public int createStudent(Student student) {
        return 0;
    }

    @Override
    public void registerAddress(Address address, int id) {
        String sql = "insert into address values(?,?,?,?,?,?)";

        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            Class.forName("org.postgresql.Driver");
            ps.setString(1,address.getStreet());
            ps.setString(2,address.getCity());
            ps.setString(3,address.getState());
            ps.setInt(4,address.getPostalCode());
            ps.setString(5, address.getCountry());
            ps.setInt(6,id);
             ps.execute();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> getStudentDetialswithID(int id) {


        List<Student> students = new ArrayList<>();
        return students;
    }

    @Override
    public List<Address> getStudentAddressDetails(int id) {
        List<Address> addressList = new ArrayList<>();
        String sql = "select street,city,state,zipcode,country from address where student_id = ?";
        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            Class.forName("org.postgresql.Driver");
            ps.setInt(1,id);
            try(ResultSet resultSet = ps.executeQuery()){
                while(resultSet.next()){
                    addressList.add(new Address(
                            resultSet.getString("street"),
                            resultSet.getString("city"),
                            resultSet.getString("state"),
                            resultSet.getInt("zipcode"),
                            resultSet.getString("country")
                    ));
                }
            }
            } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return addressList ;
    }

    @Override
    public boolean updateStudentPhoneNumber(int id, long phoneNumber) {
        return false;
    }

    @Override
    public boolean updateStudentEmail(int id, String email) {
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }

    @Override
    public boolean updateStudentAddress(Address address, int id) {
        String sql = "update address set street =?,city = ?,state = ?,zipcode = ?,country = ? where student_id = ?";
        try(
                Connection con = DriverManager.getConnection(url,uname,pass);
                PreparedStatement ps = con.prepareStatement(sql);
                ){
            Class.forName("org.postgresql.Driver");
            ps.setString(1,address.getStreet());
            ps.setString(2,address.getCity());
            ps.setString(3,address.getState());
            ps.setInt(4,address.getPostalCode());
            ps.setString(5, address.getCountry());
            ps.setInt(6,id);
            boolean update = ps.executeUpdate() > 0;
            if (update){
                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public List<Student> getAllStudnets() {
        List<Student> student = new ArrayList<>();
        return student;
    }
}
