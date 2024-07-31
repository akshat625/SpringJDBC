package com.akshat.SpringJDBC.repo;

import com.akshat.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class StudentRepo {

    //What is JdbcTemplate?
    //JdbcTemplate is a class that simplifies the use of JDBC and helps to avoid common errors. It is a part of the Spring JDBC module.
    //It is used to perform database operations. It provides methods to query the database and to update the database.
    JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    //What is the role of save() method?
    //save() method is used to save the student details in the database. It takes a Student object as a parameter and saves the details in the database.
    //It uses the JdbcTemplate object to perform the database operations.
    public void save(Student s) {

        String sql = "insert into student (rollno, name, marks) values (?,?,?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println(rows + " affected");
    }

    public List<Student> findAll(){

        String sql = "select * from student";



        //What is the role of RowMapper?
        //RowMapper is an interface that is used to map the rows of the ResultSet to the objects.
        // It is used to convert the rows of the ResultSet to the objects of the specified type.
        //It has a method mapRow() that is used to map the rows of the ResultSet to the objects.


/*        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));


                return s;
            }
        };*/


 /*       RowMapper<Student> mapper = (rs, rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));

            return s;
        };*/

        return jdbc.query(sql,(rs, rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));

            return s;
        });
    }




}
