package com.akshat.SpringJDBC.model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    int rollNo;
    String name;
    int marks;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student {" +
                "\n    rollNo: " + rollNo +
                ",\n    name: '" + name + '\'' +
                ",\n    marks: " + marks +
                "\n}";
    }
}
