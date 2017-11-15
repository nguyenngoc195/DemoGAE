package com.demo.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Student {
@Id
    private long id;
@Index
    private String rollNumber;
    @Index
    private String name;
    @Index
    private String email;
    @Index
    private int status;


    public Student(long id, String rollNumber, String name, String email, int status) {
        this.id = id;
        this.rollNumber = rollNumber;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public Student() {

    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getRollNumber() { return rollNumber; }

    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status; }
}
