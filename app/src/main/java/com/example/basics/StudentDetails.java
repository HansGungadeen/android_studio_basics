package com.example.basics;

public class StudentDetails {
    private String name;
    private String phoneNumber;

    public StudentDetails() {
//        This is default constructor.
    }

    public String getStudentName() {
        return name;
    }

    public void setStudentName(String name) {
        this.name = name;
    }

    public String getStudentPhoneNumber() {
        return phoneNumber;
    }

    public void setStudentPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
