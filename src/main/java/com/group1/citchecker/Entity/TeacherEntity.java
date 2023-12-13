package com.group1.citchecker.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblteacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int tid;

    @Column(name = "firstname")
    private String fname;

    @Column(name = "lastname")
    private String lname;
    
    private String username;
    
    private String email;
    
    private String password;
    
    private String department;
    
    // 1(Male) 0(Female)
    private int gender;

    @OneToMany
    private List<ClassEntity> classes;

    public TeacherEntity() {
        super();
        this.classes = new ArrayList<>();
    }

    public TeacherEntity(int tid, String fname, String lname,String username, String email, String password, String department, int gender) {
        super();
        this.tid = tid;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.department = department;
        this.gender = gender;
        this.classes = new ArrayList<>();
    }

    public List<ClassEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassEntity> classes) {
        this.classes = classes;
    }

    public void addClass(ClassEntity newClass) {
        if (newClass != null && !classes.contains(newClass)) {
            // Ensure that the classes list is initialized
            if (classes == null) {
                classes = new ArrayList<>();
            }

            // Add the new class to the teacher's classes list
            classes.add(newClass);

            // Set the teacher for the new class
            newClass.setTeacher(this);
        }
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}